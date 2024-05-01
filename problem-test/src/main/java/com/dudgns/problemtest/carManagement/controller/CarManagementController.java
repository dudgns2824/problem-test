package com.dudgns.problemtest.carManagement.controller;

import com.dudgns.problemtest.carManagement.dto.RequestCarManagementModifyDto;
import com.dudgns.problemtest.carManagement.dto.RequestCarManagementRegistDto;
import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.carManagement.service.CarManagementService;
import com.dudgns.problemtest.dto.BaseRepsonseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Tag(description = "자동차 조회 API 입니다.", name = "자동차 조회 API")
@RequestMapping("/api/problemTest/carManagement")
public class CarManagementController {

    private final CarManagementService carManagementService;

    @GetMapping
    @Operation(summary = "자동차 조회 API", description = "자동차 조회 API 입니다.")
    public ResponseEntity<BaseRepsonseDto<ResponseCarManagementListDto>> lookup(
            @RequestParam(value = "company_code", required = false) Integer companyCode,
            @RequestParam(value = "rental_yn", required = false) Boolean rentalYn,
            @RequestParam(value = "category_code_list", required = false) List<Long> categoryCodeList,
            @RequestParam(value = "start_year", required = false) Integer startYear,
            @RequestParam(value = "end_year", required = false) Integer endYear
    ) {
        try {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<ResponseCarManagementListDto>builder()
                            .statusCode(200)
                            .status("success")
                            .data(carManagementService.lookUpCar(companyCode, rentalYn, startYear, endYear, categoryCodeList))
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

    @PostMapping
    @Operation(summary = "자동차 등록 API", description = "자동차 등록 API 입니다.")
    public ResponseEntity<BaseRepsonseDto<Boolean>> carRegist(@RequestBody RequestCarManagementRegistDto req) {
        try {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<Boolean>builder()
                            .statusCode(200)
                            .status("success")
                            .data(carManagementService.registCar(req))
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<Boolean>builder()
                            .statusCode(500)
                            .status(e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }

    @PutMapping("/{car_idx}")
    @Operation(summary = "자동차 수정 API", description = "자동차 수정 API 입니다.")
    public ResponseEntity<BaseRepsonseDto<Boolean>> carModify(@PathVariable("car_idx") Long carIdx, @RequestBody RequestCarManagementModifyDto req) {
        try {
            req.setCarIdx(carIdx);
            return ResponseEntity.ok(
                    BaseRepsonseDto.<Boolean>builder()
                            .statusCode(200)
                            .status("success")
                            .data(carManagementService.modifyCar(req))
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    BaseRepsonseDto.<Boolean>builder()
                            .statusCode(500)
                            .status(e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }
}
