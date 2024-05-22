package dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`

import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand

interface ICarManagementCommandBus {
    fun registCarInfo(req: RegistCarInfoCommand): Boolean
    fun modifyCarInfo(req: ModifyCarInfoCommand): Boolean
}