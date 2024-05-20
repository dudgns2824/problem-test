package dudgns.com.backend.commons.core.exception

/** application layer 등 biz-logic 오류 발생시 */
class BusinessException(message: String? = null, cause: Throwable? = null) :
    Exception(message, cause)
