package dudgns.com.backend.commons.core.util

import java.util.*

class UuidUtil {
    companion object {
        /** uuid */
        fun generate(strClas: String = "-"): String {
            val uuid = UUID.randomUUID()
            return uuid.toString().replace("-", strClas)
        }

        /** 요구 길이만큼 randomStr 부착 */
        fun generateApiKey(length: Int = 40, strClas: String = ""): String {
            val uuidString = generate("")
            val lengthRequired = length - uuidString.length

            val characters = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            val randomStr = (1..lengthRequired)
                .map { characters.random() }
                .joinToString("")

            return "${uuidString}$randomStr"
        }
    }
}
