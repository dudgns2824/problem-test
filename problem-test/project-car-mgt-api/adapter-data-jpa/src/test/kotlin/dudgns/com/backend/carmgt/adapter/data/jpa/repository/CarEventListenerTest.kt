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

@AnnotCarManagementRepositoryTest
class CarEventListenerTest(
    @Autowired
    private val carEventListener: CarEventListener,
    @Autowired
    private val entityManager: EntityManager,
) {
    @Test
    fun `자동차 목록 조회`() {
        val data =
            carEventListener.getCarInfo(
                GetCarInfoListQueryCommand(null, null, null, null, null),
            )
    }

    @Test
    @Transactional(readOnly = false)
    fun `자동차 수정`() {
        val data =
            carEventListener.modifyCarInfo(
                ModifyCarInfoCommand(
                    carIdx = 1,
                    categoryTypeList = listOf(1, 2),
                    companyCode = 1L,
                    modelName = "테스트 모델",
                    createdYear = 2024,
                    rentalYn = false,
                ),
            )

        if (!data) throw RuntimeException("데이터 저장에 실패")
    }

    @Test
    @Transactional(readOnly = false)
    fun `자동차 저장`() {
        val data =
            carEventListener.registCarInfo(
                RegistCarInfoCommand(
                    categoryTypeList = listOf(1, 2),
                    companyCode = 1L,
                    modelName = "테스트 모델",
                    createdYear = 2024,
                    rentalYn = false,
                ),
            )

        if (!data) throw RuntimeException("데이터 저장에 실패")
    }
}
