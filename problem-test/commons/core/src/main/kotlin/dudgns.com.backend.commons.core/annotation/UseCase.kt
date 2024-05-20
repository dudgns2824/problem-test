package kr.co.hmcnetworks.backoffice.commons.core.annotation

/** application layer 의 core service 부착용 */
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.CLASS,
)
@Retention(AnnotationRetention.RUNTIME)
annotation class UseCase(
    val value: String = "", // = alias, qualifier 에서 이용
    val isPrimary: Boolean = false, // primary
)
