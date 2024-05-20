package dudgns.com.backend.commons.core.util

import java.util.*

class StringUtil {
    companion object {
        /** 첫글자 대문자 */
        fun replaceFirstChar(str: String): String =
            str.lowercase(Locale.getDefault())
                .replaceFirstChar { it -> if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        /** replace
        val keyNm = Regex("(Pg|Bank)").replace(splitFirst[1]) { matchRes -> "" } // Pg|Bank 문자열 제거
         * - ex.  */
        fun replaceRegex(regStr: String, input: String, transform: String = "") =
            Regex(regStr).replace(input) { matchRes -> transform }
    }
}