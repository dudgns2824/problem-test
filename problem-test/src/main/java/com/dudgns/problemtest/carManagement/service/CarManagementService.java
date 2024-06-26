package com.dudgns.problemtest.carManagement.service;

import com.dudgns.problemtest.carManagement.dto.RequestCarManagementModifyDto;
import com.dudgns.problemtest.carManagement.dto.RequestCarManagementRegistDto;
import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementDto;
import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.entity.carManagement.CarCategoryEntity;
import com.dudgns.problemtest.entity.carManagement.CarCategoryMappingEntity;
import com.dudgns.problemtest.entity.carManagement.CarEntity;
import com.dudgns.problemtest.entity.carManagement.CompanyEntity;
import com.dudgns.problemtest.entity.id.CarCategoryMappingId;
import com.dudgns.problemtest.repository.carManagement.CarCategoryMappingRepository;
import com.dudgns.problemtest.repository.carManagement.CarCategoryRepository;
import com.dudgns.problemtest.repository.carManagement.CarRepository;
import com.dudgns.problemtest.repository.carManagement.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarManagementService {
    private final CarRepository carRepository;
    private final CarCategoryMappingRepository carCategoryMappingRepository;
    private final CarCategoryRepository carCategoryRepository;

    @Transactional(readOnly = true)
    public ResponseCarManagementListDto lookUpCar(Integer companyCode,
                                                  Boolean rentalYn,
                                                  Integer startYear,
                                                  Integer endYear,
                                                  List<Long> categoryCodeList) {
        List<CarEntity> carEntityList =  carRepository.findAllBySearchValue(companyCode, rentalYn, startYear, endYear, categoryCodeList);

        return ResponseCarManagementListDto.builder()
                .carManagementDtoList(carEntityList.stream()
                        .map(e -> ResponseCarManagementDto.builder()
                                .modelName(e.getModelName())
                                .company(e.getCompanyEntity().getCompanyName())
                                .carCategory(
                                        e.getCarCategoryMappingEntityList().stream()
                                                .map(carCategory -> carCategory.getCategoryName())
                                                .toList()
                                )
                                .createdYear(e.getCreatedYear())
                                .rentalYn(e.getRentalYn())
                                .build())
                        .toList())
                .build();
    }

    @Transactional
    public Boolean registCar(RequestCarManagementRegistDto req) {
        List<CarCategoryEntity> categoryEntityList = getCarCategoryListByCategoryType(req.getCategoryTypeList());

        CarEntity carEntity = carRepository.save(
                CarEntity
                        .builder()
                        .companyCode(req.getCompanyCode())
                        .modelName(req.getModelName())
                        .createdYear(req.getCreatedYear())
                        .rentalYn(req.getRentalYn())
                        .build()
        );

        saveCarCategoryMappingByCarCategory(carEntity, categoryEntityList);

        return true;
    }

    @Transactional
    public Boolean modifyCar(RequestCarManagementModifyDto req) {
        carCategoryMappingRepository.deleteAll(carCategoryMappingRepository.findByCarCategoryMappingIdCarIdx(req.getCarIdx()));

        List<CarCategoryEntity> categoryEntityList = getCarCategoryListByCategoryType(req.getCategoryTypeList());

        CarEntity carEntity = carRepository.save(
                CarEntity
                        .builder()
                        .idx(req.getCarIdx())
                        .companyCode(req.getCompanyCode())
                        .modelName(req.getModelName())
                        .createdYear(req.getCreatedYear())
                        .rentalYn(req.getRentalYn())
                        .build()
        );

        saveCarCategoryMappingByCarCategory(carEntity, categoryEntityList);

        return true;
    }

    public List<CarCategoryEntity> getCarCategoryListByCategoryType(List<Integer> categoryType){
        return categoryType.size() > 0 ? carCategoryRepository
                .findAll()
                .stream()
                .filter(carCategory -> categoryType.contains(carCategory.getCategoryType()))
                .toList() : new ArrayList<>();
    }

    public void saveCarCategoryMappingByCarCategory(CarEntity carEntity, List<CarCategoryEntity> categoryEntityList) {
        carCategoryMappingRepository.saveAll(
                categoryEntityList.stream()
                        .map(carCategory -> CarCategoryMappingEntity.builder()
                                .carCategoryMappingId(
                                        CarCategoryMappingId.builder()
                                                .carIdx(carEntity.getIdx())
                                                .categoryType(carCategory.getCategoryType())
                                                .build()
                                )
                                .categoryName(carCategory.getCategoryName())
                                .build())
                        .toList()
        );
    }
}