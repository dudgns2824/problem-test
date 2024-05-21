package dudgns.com.backend.commons.core.annotation

@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.CLASS,
)
@Retention(AnnotationRetention.RUNTIME)
annotation class UseCase(
    val value: String = "", // = alias, qualifier 에서 이용
    val isPrimary: Boolean = false, // primary
)
