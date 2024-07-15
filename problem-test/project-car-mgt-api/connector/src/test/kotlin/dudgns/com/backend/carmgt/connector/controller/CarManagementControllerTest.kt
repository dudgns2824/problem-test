package dudgns.com.backend.carmgt.connector.controller

import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementCommandBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import kotlin.test.Test

@RunWith(SpringRunner::class)
@WebMvcTest(CarManagementController::class)
class CarManagementControllerTest(
    @Autowired
    private val carManagementController: CarManagementController,
) {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var carManagementQueryBus: ICarManagementQueryBus

    @MockBean
    lateinit var carManagementCommandBus: ICarManagementCommandBus

    @Before
    fun setUp() {
        this.mockMvc =
            MockMvcBuilders
                .standaloneSetup(carManagementController)
                .build()
    }

    @Test
    fun `차 검색 조건으로 검색`() {
        mockMvc.perform(get("http://localhost:8080/api/problemTest/carManagement"))
            .andExpect(status().isOk)
    }
}
