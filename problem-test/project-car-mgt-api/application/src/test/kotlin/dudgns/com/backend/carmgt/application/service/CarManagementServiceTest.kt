package dudgns.com.backend.carmgt.application.service

import dudgns.com.backend.carmgt.application.AnnotCarManagementServiceTest
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementCommandEventBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.out.ICarManagementQueryEventBus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean

@AnnotCarManagementServiceTest
class CarManagementServiceTest(
    @Autowired
    private val carManagementService: CarManagementService,
) {
    @MockBean
    lateinit var carManagementQueryEventBus: ICarManagementQueryEventBus

    @MockBean
    lateinit var carManagementCommandEventBus: ICarManagementCommandEventBus

    @Test
    fun `자동차 목록 조회`() {
        val data =
            carManagementService.getCarInfo(
                GetCarInfoListQueryCommand(null, null, null, null, null),
            )
        assertThat(data)
    }
}
