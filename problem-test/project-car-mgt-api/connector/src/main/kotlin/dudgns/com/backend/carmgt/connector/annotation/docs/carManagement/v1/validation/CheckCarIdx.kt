package dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1.validation

import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
)
@Constraint(validatedBy = [CheckCarIdValidator::class])
annotation class CheckCarIdx (
    val message: String = "해당 자동차 id 번호가 존재하지 않습니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

@Component
class CheckCarIdValidator(
    private val carManagementQueryBus: ICarManagementQueryBus,
) : ConstraintValidator<CheckCarIdx, Long> {
    override fun isValid(value: Long, context: ConstraintValidatorContext?): Boolean {
        val res = carManagementQueryBus.checkByCarId(carId = value)

        return if (res.isSuccess) {
            true
        } else {
            context?.apply {
                disableDefaultConstraintViolation()
                buildConstraintViolationWithTemplate(res.message).addConstraintViolation()
            }
            false
        }
    }
}