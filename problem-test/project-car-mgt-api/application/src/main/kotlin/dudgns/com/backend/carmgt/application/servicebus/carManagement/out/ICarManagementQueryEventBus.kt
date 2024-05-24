package dudgns.com.backend.carmgt.application.servicebus.carManagement.out

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.domain.common.message.ResultMessage
import dudgns.com.backend.carmgt.domain.model.carManagement.CarInfoModel

interface ICarManagementQueryEventBus {
    fun getCarInfo(req: GetCarInfoListQueryCommand): List<CarInfoModel>
    fun checkByCarId(carIdx: Long): ResultMessage
}