package com.dudgns.problemtest.config.database;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QuerydslConfig {


    @PersistenceContext(unitName = "authEntityManager")
    private EntityManager authEntityManager;

    @PersistenceContext(unitName = "carManagementEntityManager")
    private EntityManager carManagementEntityManager;


    @Primary
    @Bean(name = "authQueryFactory")
    public JPAQueryFactory authQueryFactory() {
        return new JPAQueryFactory(authEntityManager);
    }

    @Bean(name = "carManagementQueryFactory")
    public JPAQueryFactory carManagementQueryFacotry() {
        return new JPAQueryFactory(carManagementEntityManager);
    }

}
