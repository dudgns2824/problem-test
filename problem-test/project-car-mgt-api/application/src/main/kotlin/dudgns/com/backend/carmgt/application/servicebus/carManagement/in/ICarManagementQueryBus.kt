package dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.domain.common.message.ResultMessage

interface ICarManagementQueryBus {
    fun getCarInfo(req: GetCarInfoListQueryCommand): List<*>
    fun checkByCarId(carId: Long): ResultMessage
}