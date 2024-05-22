package dudgns.com.backend.carmgt.application.service

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.ICarManagementServiceBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementCommandBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementCommandEventBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel
import dudgns.com.backend.commons.core.annotation.UseCase

@UseCase
class CarManagementService(
    private val carManagementQueryEventBus: ICarManagementQueryEventBus,
    private val carManagementCommandEventBus: ICarManagementCommandEventBus
) : ICarManagementQueryBus,
    ICarManagementCommandBus,
    ICarManagementServiceBus {
    override fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel> {
        return carManagementQueryEventBus.getCarInfo(req)
    }

    override fun registCarInfo(req: RegistCarInfoCommand): Boolean {
        return carManagementCommandEventBus.registCarInfo(req)
    }

    override fun modifyCarInfo(req: ModifyCarInfoCommand): Boolean {
        return carManagementCommandEventBus.modifyCarInfo(req)
    }
}