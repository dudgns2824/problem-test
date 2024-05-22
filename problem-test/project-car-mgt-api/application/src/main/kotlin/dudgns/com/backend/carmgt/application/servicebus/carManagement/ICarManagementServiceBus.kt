package dudgns.com.backend.carmgt.application.servicebus.carManagement

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel

interface ICarManagementServiceBus {
    fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel>
    fun registCarInfo(req: RegistCarInfoCommand): Boolean
    fun modifyCarInfo(req: ModifyCarInfoCommand): Boolean
}