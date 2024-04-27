package com.problemTest.auth.repository.redis;

import com.problemTest.auth.entity.redis.MailRequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface MailRequestRepository extends CrudRepository<MailRequestEntity, String> {
}
