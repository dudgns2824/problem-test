package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection
import com.querydsl.core.group.GroupBy
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.group.GroupBy.*
import com.querydsl.jpa.JPAExpressions
import dudgns.com.backend.carmgt.adapter.data.jpa.repository.BaseRepository
import dudgns.com.backend.carmgt.adapter.data.jpa.util.carManagement.CarManagementRepositoryUtil
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementCommandEventBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import dudgns.com.backend.carmgt.domain.common.message.ResultMessage
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
    private val carCategoryRepository: CarCategoryRepository,
    private val carManagementRepositoryUtil: CarManagementRepositoryUtil,
) : BaseRepository(), ICarManagementQueryEventBus, ICarManagementCommandEventBus {
    fun getCarCategoryListByCategoryType(categoryType: List<Int?>): List<CarCategoryEntity> {
        return if (categoryType.isNotEmpty()) carCategoryRepository
            .findAll()
            .stream()
            .filter { carCategory -> categoryType.contains(carCategory.categoryType) }
            .toList() else ArrayList()
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


    override fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel> {
        return queryFactory
            .from(carEntity)
            .where(
                carManagementRepositoryUtil.eqCompanyCode(req.companyCode),
                carManagementRepositoryUtil.eqRentalYn(req.rentalYn),
                carManagementRepositoryUtil.goeCreatedYear(req.startYear),
                carManagementRepositoryUtil.loeCreatedYear(req.endYear),
                carManagementRepositoryUtil.inCategoryType(req.categoryTypeList)
            ).transform(
                groupBy(carEntity.idx).list(
                    Projections.constructor(
                        CarInfoModel::class.java,
                        carEntity.modelName,
                        list(carEntity.carCategoryMappingEntityList.any().categoryName),
                        carEntity.companyEntity.companyName,
                        carEntity.createdYear,
                        carEntity.rentalYn
                    )
                )
            )
    }

    override fun checkByCarId(carIdx: Long): ResultMessage {
        val isCarExist = carRepository.findById(carIdx).isPresent

        val message = if (!isCarExist) "존재 하지 않는 자동차 id 입니다." else ""

        return ResultMessage(isSuccess = isCarExist, message = message)
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

}