package dudgns.com.backend.commons.core.util

import java.lang.reflect.Field

class ReflectUtil {
    /**
     * 리플렉션을 이용하여 필드를 가져오는 부분
     * - Java Reflection API는 동적으로 클래스를 불러와서 사용하기 때문에 속도가 느리고 높은 비용이 발생
     * - 많이 사용할 경우, OutOfMemoryError 발생
     * - https://wildeveloperetrain.tistory.com/157
     *
     * @param object
     * @param fieldName
     * @return NoSuchFieldException | IllegalAccessException
     */
    fun getFieldValue(`object`: Any, fieldName: String): String? {
        val clazz: Class<*> = `object`.javaClass

        val dateField: Field = clazz.getDeclaredField(fieldName)
        dateField.isAccessible = true

        val target: String? = dateField.get(`object`) as? String?
            ?: null // throw ClassCastException("casting exception")

        return target
    }
}