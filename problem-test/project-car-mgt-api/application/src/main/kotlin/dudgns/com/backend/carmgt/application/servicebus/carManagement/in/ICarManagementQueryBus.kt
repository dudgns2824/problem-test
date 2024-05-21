package dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand

interface ICarManagementQueryBus {
    fun getCarInfo(req: GetCarInfoListQueryCommand): List<*>
    fun registCarInfo(req: RegistCarInfoCommand): Boolean
    fun modfiyCarInfo(req: ModifyCarInfoCommand): Boolean
}