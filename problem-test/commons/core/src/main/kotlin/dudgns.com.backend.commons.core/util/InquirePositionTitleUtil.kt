package kr.co.hmcnetworks.backoffice.commons.core.util

import kr.co.hmcnetworks.backoffice.commons.core.enumeration.UserType
import kr.co.hmcnetworks.backoffice.commons.core.enumeration.etcinquire.EtcInquireCgsPositionType
import kr.co.hmcnetworks.backoffice.commons.core.enumeration.etcinquire.EtcInquirePtrPositionType

/**
 * 의견접수 응답 반환을 위하여
 * inquirePosition(0,1,2..)을 ~xxxPositionType enum의 title 값(공고 등록, ...)으로 변환
 */
object InquirePositionTitleUtil {
    /**
     * 주어진 inquirePosition에 해당하는 EtcInquirePtrPositionType의 title을 반환
     */
    fun getPtrInquirePositionTitle(inquirePosition: Int): String {
        return enumValues<EtcInquirePtrPositionType>().find { it.id == inquirePosition }?.title
            ?: ""
    }

    /**
     * 주어진 inquirePosition에 해당하는 EtcInquireCgsPositionType의 title을 반환
     */
    fun getCgsInquirePositionTitle(inquirePosition: Int): String {
        return enumValues<EtcInquireCgsPositionType>().find { it.id == inquirePosition }?.title
            ?: ""
    }

    /**
     *  주어진 userType과 inquirePosition에 따라 해당하는 title을 반환
     */
    fun getInquirePositionTitleByUserType(
        userType: UserType,
        inquirePosition: Int,
    ): String {
        return when (userType) {
            UserType.Caregiver -> getCgsInquirePositionTitle(
                inquirePosition
            )

            UserType.Protector -> getPtrInquirePositionTitle(
                inquirePosition
            )
        }
    }
}
