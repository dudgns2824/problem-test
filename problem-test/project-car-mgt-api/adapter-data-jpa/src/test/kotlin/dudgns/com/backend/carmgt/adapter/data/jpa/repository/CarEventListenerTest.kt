package dudgns.com.backend.carmgt.adapter.data.jpa.repository

import dudgns.com.backend.carmgt.adapter.data.jpa.AnnotCarManagementRepositoryTest
import dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement.CarEventListener
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertTrue

@AnnotCarManagementRepositoryTest
class CarEventListenerTest(
    @Autowired
    private val carEventListener: CarEventListener,
    @Autowired
    private val entityManager: EntityManager,
) {
    @Test
    @Transactional(readOnly = false)
    fun `자동차 목록 조회`() {
        val dto =
            RegistCarInfoCommand(
                categoryTypeList = listOf(1, 2),
                companyCode = 1L,
                modelName = "테스트 모델",
                createdYear = 12345,
                rentalYn = false,
            )

        carEventListener.registCarInfo(dto)

        val data =
            carEventListener.getCarInfo(
                GetCarInfoListQueryCommand(1, false, 12345, 12345, listOf(1, 2)),
            )

        assertTrue { data.isNotEmpty() }
    }

    @Test
    @Transactional(readOnly = false)
    fun `자동차 수정`() {
        val dto =
            ModifyCarInfoCommand(
                carIdx = 1,
                categoryTypeList = listOf(1, 2),
                companyCode = 1L,
                modelName = "테스트 모델",
                createdYear = 2024,
                rentalYn = false,
            )

        val isSuccess = carEventListener.modifyCarInfo(dto)

        assertTrue { isSuccess }
    }

    @Test
    @Transactional(readOnly = false)
    fun `자동차 저장`() {
        val dto =
            RegistCarInfoCommand(
                categoryTypeList = listOf(1, 2),
                companyCode = 1L,
                modelName = "테스트 모델",
                createdYear = 2024,
                rentalYn = false,
            )

        val isSuccess = carEventListener.registCarInfo(dto)

        assertTrue { isSuccess }
    }
}
