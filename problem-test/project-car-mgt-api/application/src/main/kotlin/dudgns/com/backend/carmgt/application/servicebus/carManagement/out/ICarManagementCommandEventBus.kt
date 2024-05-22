package dudgns.com.backend.carmgt.application.servicebus.carManagement.out

import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand

interface ICarManagementCommandEventBus {
    fun registCarInfo(req: RegistCarInfoCommand): Boolean
    fun modifyCarInfo(req: ModifyCarInfoCommand): Boolean
}