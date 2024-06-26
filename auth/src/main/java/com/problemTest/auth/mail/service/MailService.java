package com.problemTest.auth.mail.service;

import com.problemTest.auth.common.EmailSendService;
import com.problemTest.auth.common.object.SendEmailObjectDto;
import com.problemTest.auth.dto.RequestMailDto;
import com.problemTest.auth.entity.redis.MailRequestEntity;
import com.problemTest.auth.enums.VerifyType;
import com.problemTest.auth.exception.EmailVerifyFailedException;
import com.problemTest.auth.exception.EmailVerifyMaxRequestException;
import com.problemTest.auth.exception.EmailVerifyMaxRequestPerTimeException;
import com.problemTest.auth.mail.dto.ResponseMailVerifyDto;
import com.problemTest.auth.mail.dto.ResponseVerifyDto;
import com.problemTest.auth.repository.redis.MailRequestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Transactional
public class MailService {

    @Value("${spring.mail.max-request-count}")
    private Integer maxRequestCount;

    @Value("${spring.mail.max-request-minutes}")
    private Integer maxRequestMinutes;

    @Value("${spring.mail.max-request-per-time}")
    private Integer maxRequestPerTime;

    @Value("${spring.mail.mail-verify-expire-time}")
    private Integer mailVerifyExpireTime;

    @Value("${spring.mail.mail-request-expire}")
    private Long mailRequestExpire;

    @Value("${spring.mail.from-email}")
    private String fromEmail;

    private final EmailSendService emailSendService;

    private final MailRequestRepository mailRequestRepository;

    public ResponseMailVerifyDto verify(String email, String code) {
        final boolean[] isVerified = {false};

        mailRequestRepository.findById(email).ifPresentOrElse(
                mailRequestEntity -> {
                    AtomicBoolean isVerifiedAtomic = new AtomicBoolean(false);
                    mailRequestEntity.getRequests().forEach(requestMailDto -> {
                        if (LocalDateTime.now().minus(mailVerifyExpireTime, ChronoUnit.MINUTES).isBefore(requestMailDto.getRequestTime()) && !requestMailDto.isVerified() && requestMailDto.getCode().equals(code)) {
                            requestMailDto.setVerified(true);
                            isVerifiedAtomic.set(true);
                        }
                    });
                    mailRequestEntity.setVerified(isVerifiedAtomic.get());
                    isVerified[0] = isVerifiedAtomic.get();

                    mailRequestRepository.save(mailRequestEntity);
                }
                ,
                () -> {throw new EmailVerifyFailedException();}
        );


        return ResponseMailVerifyDto.builder()
                .success(isVerified[0])
                .email(email)
                .build();

    }

    public ResponseVerifyDto request(String email) {
        Optional<MailRequestEntity> mailRequestEntityOptional = mailRequestRepository.findById(email);

        String code = String.format("%06d", Long.parseLong(RandomStringUtils.randomNumeric(6, 6), 10));

        LocalDateTime now = LocalDateTime.now();

        mailRequestEntityOptional.ifPresentOrElse(
                mailRequestEntity -> {
                    List<RequestMailDto> requestMailDtoList = mailRequestEntity.getRequests();

                    if (requestMailDtoList.size() >= maxRequestCount) {
                        throw new EmailVerifyMaxRequestException();
                    }

                    if (requestMailDtoList.stream()
                            .filter(requestMailDto -> now.minus(maxRequestMinutes, ChronoUnit.MINUTES).isBefore(requestMailDto.getRequestTime()))
                            .count() > maxRequestPerTime) throw new EmailVerifyMaxRequestPerTimeException();

                    mailRequestEntity.getRequests().add(RequestMailDto.builder()
                            .confirm(false)
                            .type(VerifyType.REGISTER)
                            .code(code)
                            .requestTime(now)
                            .build());

                    mailRequestRepository.save(mailRequestEntity);
                }
                , () -> {
                    List<RequestMailDto> requestMailDtoList = new ArrayList<>();

                    requestMailDtoList.add(RequestMailDto.builder()
                            .code(code)
                            .verified(false)
                            .confirm(false)
                            .requestTime(now)
                            .build());

                    mailRequestRepository.save(MailRequestEntity.builder()
                            .email(email)
                            .verified(false)
                            .expire(mailRequestExpire)
                            .requests(requestMailDtoList)
                            .build());
                }
        );

        emailSendService.send(SendEmailObjectDto.builder()
                .from(fromEmail)
                .to(email)
                .code(code)
                .build());

        return ResponseVerifyDto
                .builder()
                .email(email)
                .code(code)
                .build();
    }

}
