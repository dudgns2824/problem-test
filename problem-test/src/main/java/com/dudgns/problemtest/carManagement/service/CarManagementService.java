package com.dudgns.problemtest.carManagement.service;

import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.repository.carManagement.support.CarManagementRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarManagementService {

    private final CarManagementRepositorySupport carManagementRepositorySupport;

    public ResponseCarManagementListDto lookUpCar(Integer companyCode,
                                                  String startDt,
                                                  String endDt) {

        return carManagementRepositorySupport.findAllSearchValue(companyCode, startDt, endDt);
    }
}
