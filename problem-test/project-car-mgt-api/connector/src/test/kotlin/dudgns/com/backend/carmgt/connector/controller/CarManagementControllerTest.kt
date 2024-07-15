package dudgns.com.backend.carmgt.connector.controller

import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementCommandBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@WebMvcTest(CarManagementController::class)
class CarManagementControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var carManagementQueryBus: ICarManagementQueryBus

    @MockBean
    lateinit var carManagementCommandBus: ICarManagementCommandBus

    @Test
    fun `차 검색 조건으로 검색`() {
        mockMvc.perform(get("/api/problemTest/carManagement"))
            .andExpect(status().isOk)
            .andDo { it ->
                {
                    it.response
                }
            }
    }
}
