package com.dudgns.problemtest.carManagement.service;

import com.dudgns.problemtest.carManagement.dto.RequestCarManagementRegistDto;
import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.repository.carManagement.CarCategoryMappingRepository;
import com.dudgns.problemtest.repository.carManagement.CarManagementRepository;
import com.dudgns.problemtest.repository.carManagement.support.CarManagementRepositorySupport;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarManagementService {

    private final CarManagementRepositorySupport carManagementRepositorySupport;
    private final CarManagementRepository carManagementRepository;
    private final CarCategoryMappingRepository carCategoryMappingRepository;


    public ResponseCarManagementListDto lookUpCar(Integer companyCode,
                                                  String startDt,
                                                  String endDt) {

        return carManagementRepositorySupport.findAllSearchValue(companyCode, startDt, endDt);
    }

    @Transactional
    public Boolean registCar(RequestCarManagementRegistDto req) {


        return true;
    }
}
