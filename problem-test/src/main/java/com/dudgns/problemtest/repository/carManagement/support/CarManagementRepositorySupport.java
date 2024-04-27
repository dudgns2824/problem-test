package com.dudgns.problemtest.repository.carManagement.support;

import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementDto;
import com.dudgns.problemtest.carManagement.dto.ResponseCarManagementListDto;
import com.dudgns.problemtest.entity.carManagement.QCarCategoryEntity;
import com.dudgns.problemtest.entity.carManagement.QCarEntity;
import com.dudgns.problemtest.entity.carManagement.QCompanyEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CarManagementRepositorySupport {

    private final JPAQueryFactory carManagementQueryFactory;

    @Autowired
    CarManagementRepositorySupport(@Qualifier(value = "carManagementQueryFactory") JPAQueryFactory carManagementQueryFactory) {
        this.carManagementQueryFactory = carManagementQueryFactory;
    }

    private final QCarEntity qCar = QCarEntity.carEntity;
    private final QCarCategoryEntity qCarCategoryEntity = QCarCategoryEntity.carCategoryEntity;
    private final QCompanyEntity qCompanyEntity = QCompanyEntity.companyEntity;

    public ResponseCarManagementListDto findAllSearchValue(Integer companyCode,
                                                           String startDt,
                                                           String endDt) {

        return ResponseCarManagementListDto.builder()
                .carManagementDtoList(
                        carManagementQueryFactory
                                .selectFrom(qCar)
                                .leftJoin(qCompanyEntity).on(qCompanyEntity.companyCode.eq(qCar.companyEntity.companyCode))
                                .where(
                                        companyCodeBooleanExpression(companyCode)
                                )
                                .fetch()
                                .stream()
                                .map(e -> ResponseCarManagementDto.builder()
                                        .modelName(e.getModelName())
                                        .company(e.getCompanyEntity().getCompanyName())
                                        .carCategory(
                                                e.getCarCategoryEntityList().stream()
                                                        .map(carCategory -> carCategory.getCategoryName())
                                                        .toList()
                                        )
                                        .createdYear(e.getCreatedYear())
                                        .build())
                                .toList()
                )
                .build();
    }

    private BooleanExpression companyCodeBooleanExpression(Integer companyCode) {
        return companyCode == null || companyCode.equals(0) ?
                null : qCompanyEntity.companyCode.eq(companyCode);
    }

}
