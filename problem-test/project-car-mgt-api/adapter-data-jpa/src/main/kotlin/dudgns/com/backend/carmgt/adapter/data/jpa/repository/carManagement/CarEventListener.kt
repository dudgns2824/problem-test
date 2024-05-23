package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.JPAExpressions
import dudgns.com.backend.carmgt.adapter.data.jpa.repository.BaseRepository
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementCommandEventBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel
import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryEntity
import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryMappingEntity
import dudgns.com.backend.commons.data.entity.problemTest.CarEntity
import dudgns.com.backend.commons.data.entity.problemTest.QCarEntity.carEntity
import dudgns.com.backend.commons.data.entity.problemTest.id.CarCategoryMappingId
import org.springframework.stereotype.Repository

@Repository
class CarEventListener(
    private val carRepository: CarRepository,
    private val carCategoryMappingRepository: CarCategoryMappingRepository,
    private val carCategoryRepository: CarCategoryRepository
) : BaseRepository(), ICarManagementQueryEventBus, ICarManagementCommandEventBus {
    override fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel> {
        /*
        * Projections.constructor 사용 하려 했으나 그 부분에서
        * 1:다 연관관계 매핑 entity를 n+1방지 위해 fetchJoin후 select하고 해당 entity에 있는
        * 카테고리 List<String>을 가져오는 방법을 잘 모르겠음.
        * */
        return queryFactory
            .selectFrom(carEntity)
            .innerJoin(carEntity.carCategoryMappingEntityList).fetchJoin()
            .leftJoin(carEntity.companyEntity).fetchJoin()
            .where(
                eqCompanyCode(req.companyCode),
                eqRentalYn(req.rentalYn),
                goeCreatedYear(req.startYear),
                loeCreatedYear(req.endYear),
                inCategoryType(req.categoryTypeList)
            ).fetch()!!.map { carEntity ->
                CarInfoModel(
                    modelName = carEntity?.modelName,
                    carCategory = carEntity?.carCategoryMappingEntityList?.map { category -> category.categoryName },
                    company = carEntity?.companyEntity?.companyName,
                    createdYear = carEntity?.createdYear,
                    rentalYn = carEntity?.rentalYn
                )
            }
    }

    override fun registCarInfo(req: RegistCarInfoCommand): Boolean {
        val carEntity = carRepository.save(
            CarEntity(
                idx = null,
                companyCode = req.companyCode,
                modelName = req.modelName,
                createdYear = req.createdYear,
                rentalYn = req.rentalYn
            )
        )

        val categoryEntityList = getCarCategoryListByCategoryType(req.categoryTypeList)

        saveCarCategoryMappingByCarCategory(carEntity, categoryEntityList)

        return true
    }

    override fun modifyCarInfo(req: ModifyCarInfoCommand): Boolean {
        carCategoryMappingRepository.deleteAll(carCategoryMappingRepository.findByCarCategoryMappingIdCarIdx(req.carIdx))

        val categoryEntityList = getCarCategoryListByCategoryType(req.categoryTypeList)

        val carEntity = carRepository.save(
            CarEntity(
                idx = req.carIdx,
                companyCode = req.companyCode,
                modelName = req.modelName,
                createdYear = req.createdYear,
                rentalYn = req.rentalYn
            )
        )

        saveCarCategoryMappingByCarCategory(carEntity, categoryEntityList)

        return true
    }

    fun getCarCategoryListByCategoryType(categoryType: List<Int?>): List<CarCategoryEntity> {
        return if (categoryType.isNotEmpty()) carCategoryRepository
            .findAll()
            .stream()
            .filter { carCategory -> categoryType.contains(carCategory.categoryType) }
            .toList() else ArrayList<CarCategoryEntity>()
    }

    fun saveCarCategoryMappingByCarCategory(carEntity: CarEntity, categoryEntityList: List<CarCategoryEntity>) {
        carCategoryMappingRepository.saveAll(
            categoryEntityList.map { carCategoryEntity ->
                val carCategoryMappingId = CarCategoryMappingId()
                carCategoryMappingId.carIdx = carEntity.idx
                carCategoryMappingId.categoryType = carCategoryEntity.categoryType

                CarCategoryMappingEntity(
                    carCategoryMappingId = carCategoryMappingId,
                    categoryName = carCategoryEntity.categoryName
                )
            }
        )
    }

    fun eqCompanyCode(companyCode: Long?): BooleanExpression? {
        return if (companyCode != null) {
            carEntity.companyCode.eq(companyCode)
        } else null
    }

    fun eqRentalYn(rentalYn: Boolean?): BooleanExpression? {
        return if (rentalYn != null) {
            carEntity.rentalYn.eq(rentalYn)
        } else null
    }

    fun goeCreatedYear(year: Int?): BooleanExpression? {
        return if (year != null) {
            carEntity.createdYear.goe(year)
        } else null
    }

    fun loeCreatedYear(year: Int?): BooleanExpression? {
        return if (year != null) {
            carEntity.createdYear.loe(year)
        } else null
    }

    fun inCategoryType(categoryTypeList: List<Int?>?): BooleanExpression? {
        return if (categoryTypeList != null && categoryTypeList.size > 0) {
            carEntity.carCategoryMappingEntityList.any().carCategoryMappingId
                .categoryType.`in`(categoryTypeList)
        } else null
    }
}