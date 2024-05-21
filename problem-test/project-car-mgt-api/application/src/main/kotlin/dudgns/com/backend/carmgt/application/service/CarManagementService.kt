package dudgns.com.backend.carmgt.application.service

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel
import dudgns.com.backend.commons.core.annotation.UseCase

@UseCase
class CarManagementService(
    private val carManagementQueryEventBus: ICarManagementQueryEventBus
) : ICarManagementQueryBus {
    override fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel> {
        return carManagementQueryEventBus.getCarInfo(req)
    }

    override fun registCarInfo(req: RegistCarInfoCommand): Boolean {
        return carManagementQueryEventBus.registCarInfo(req)
    }

    override fun modfiyCarInfo(req: ModifyCarInfoCommand): Boolean {
        return carManagementQueryEventBus.modifyCarInfo(req)
    }
}