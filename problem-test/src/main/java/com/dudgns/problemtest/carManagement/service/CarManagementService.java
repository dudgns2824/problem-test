package com.dudgns.problemtest.carManagement.service;

import com.dudgns.problemtest.carManagement.dto.RequestCarManagementRegistDto;
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
import com.dudgns.problemtest.repository.carManagement.support.CarManagementRepositorySupport;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarManagementService {

    private final CarManagementRepositorySupport carManagementRepositorySupport;
    private final CarRepository carRepository;
    private final CarCategoryMappingRepository carCategoryMappingRepository;
    private final CarCategoryRepository carCategoryRepository;
    private final CompanyRepository companyRepository;


    public ResponseCarManagementListDto lookUpCar(Integer companyCode,
                                                  String startDt,
                                                  String endDt) {

        return carManagementRepositorySupport.findAllSearchValue(companyCode, startDt, endDt);
    }

    @Transactional
    public Boolean registCar(RequestCarManagementRegistDto req) {
        List<CarCategoryEntity> categoryEntityList = req.getCategoryTypeList().size() > 0 ? carCategoryRepository
                .findAll()
                .stream()
                .filter(carCategory -> req.getCategoryTypeList().contains(carCategory.getCategoryType()))
                .toList() : new ArrayList<>();

        Optional<CompanyEntity> companyEntityOptional = companyRepository.findById(req.getCompanyCode());

        CarEntity carEntity = carRepository.save(
                CarEntity
                        .builder()
                        .companyEntity(
                                companyEntityOptional.isPresent() ?
                                        CompanyEntity.builder()
                                                .companyCode(companyEntityOptional.get().getCompanyCode())
                                                .companyName(companyEntityOptional.get().getCompanyName())
                                                .build() : null
                        )
                        .modelName(req.getModelName())
                        .createdYear(req.getCreatedYear())
                        .rentalYn(req.getRentalYn())
                        .build()
        );

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

        return true;
    }
}