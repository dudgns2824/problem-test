package com.dudgns.problemtest.controller.carManagement.service;

import com.dudgns.problemtest.controller.carManagement.dto.ResponseCarManagementListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarManagementService {

    public ResponseCarManagementListDto lookUpCar(Integer categoryType,
                                                  Integer companyCode,
                                                  String startDt,
                                                  String endDt) {


        return null;
    }
}
