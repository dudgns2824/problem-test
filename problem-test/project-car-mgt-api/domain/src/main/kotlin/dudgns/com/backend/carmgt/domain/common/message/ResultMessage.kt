package dudgns.com.backend.carmgt.domain.common.message

data class ResultMessage(
    val isSuccess: Boolean,
    val message: String?
)