package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import dudgns.com.backend.carmgt.adapter.data.jpa.repository.BaseRepository
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel
import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryEntity
import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryMappingEntity
import dudgns.com.backend.commons.data.entity.problemTest.CarEntity
import dudgns.com.backend.commons.data.entity.problemTest.id.CarCategoryMappingId
import org.springframework.stereotype.Repository

@Repository
class CarEventListener(
    private val carRepository: CarRepository,
    private val carCategoryMappingRepository: CarCategoryMappingRepository,
    private val carCategoryRepository: CarCategoryRepository
) : BaseRepository(), ICarManagementQueryEventBus {
    override fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel> {
        return carRepository.findAllBySearchValue(
            companyCode = req.companyCode,
            rentalYn = req.rentalYn,
            startYear = req.startYear,
            endYear = req.endYear,
            categoryTypeList = req.categoryTypeList
        )!!.map { carEntity -> CarInfoModel(
            modelName = carEntity?.modelName,
            carCategory = carEntity?.carCategoryMappingEntityList?.map { category -> category.categoryName },
            company = carEntity?.companyEntity?.companyName,
            createdYear = carEntity?.createdYear,
            rentalYn = carEntity?.rentalYn
        )}
    }

    override fun registCarInfo(req: RegistCarInfoCommand): Boolean {
        val carEntity = carRepository.save(CarEntity(
            idx = null,
            companyCode = req.companyCode,
            modelName = req.modelName,
            createdYear = req.createdYear,
            rentalYn = req.rentalYn
        ))

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
}