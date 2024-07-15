package dudgns.com.backend.carmgt.adapter.data.jpa.util.carManagement

import com.querydsl.core.types.dsl.BooleanExpression
import dudgns.com.backend.commons.data.entity.problemTest.QCarEntity.carEntity
import org.springframework.stereotype.Component

@Component
class CarManagementRepositoryUtil {
    fun eqCompanyCode(companyCode: Long?): BooleanExpression? {
        return if (companyCode != null) {
            carEntity.companyCode.eq(companyCode)
        } else {
            null
        }
    }

    fun eqRentalYn(rentalYn: Boolean?): BooleanExpression? {
        return if (rentalYn != null) {
            carEntity.rentalYn.eq(rentalYn)
        } else {
            null
        }
    }

    fun goeCreatedYear(year: Int?): BooleanExpression? {
        return if (year != null) {
            carEntity.createdYear.goe(year)
        } else {
            null
        }
    }

    fun loeCreatedYear(year: Int?): BooleanExpression? {
        return if (year != null) {
            carEntity.createdYear.loe(year)
        } else {
            null
        }
    }

    fun inCategoryType(categoryTypeList: List<Int?>?): BooleanExpression? {
        return if (!categoryTypeList.isNullOrEmpty()) {
            carEntity.carCategoryMappingEntityList.any().carCategoryMappingId.categoryType.`in`(categoryTypeList)
        } else {
            null
        }
    }
}
