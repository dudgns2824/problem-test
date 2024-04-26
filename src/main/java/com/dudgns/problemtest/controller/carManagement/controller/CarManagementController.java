package com.dudgns.problemtest.controller.carManagement.controller;

import com.dudgns.problemtest.controller.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.controller.carManagement.service.CarManagementService;
import com.dudgns.problemtest.dto.BaseRepsonseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/api/problemTest/carManagement")
public class CarManagementController {

    private final CarManagementService carManagementService;

    @GetMapping
    @Operation(summary = "자동차 조회 API", description = "자동차 조회 API 입니다.")
    public ResponseEntity<BaseRepsonseDto<ResponseCarManagementListDto>> lookup(
            @RequestParam(value = "categoryType") Integer categoryType
    ) {
        try {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<ResponseCarManagementListDto>builder()
                            .statusCode(200)
                            .status("success")
                            .data(carManagementService.lookUpCar())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<ResponseCarManagementListDto>builder()
                            .statusCode(500)
                            .status(e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }

}
