package dudgns.com.backend.commons.core.util

/**
 * 제너릭 타입(enum 포함) 리스트의 객체에 접근하여 지정한 속성과 키이름으로 Map List 제작 가능 유틸
 */
object GenericToMapUtil {

    /**
     * Definition : 제너릭으로 정의한 enum타입 상수에 접근하여 키 이름과 상수 속성으로
     *              [{"firstKey" : setFirstVal, "secondKey" : setSecondVal }, ...] 형태 맵 리스트 반환
     * Parameter :
     *            firstKey : 맵의 첫번째 키 이름
     *            setFirstVal : 맵의 첫번쨰 값, enum타입 상수를 인자로 받는 익명함수 (EX. { it.property } )
     *            secondKey : 맵의 두번째 키 이름
     *            setSecondVal : 맵의 두번쨰 값, enum타입 객체를 인자로 받는 익명함수
     *
     * Example : enum class DivisionType(val division: String) { AD("경영진"), DEV("개발") }
     *           ListMapMakerUtil.makeFromEnum<DivisionType>("code", { it.name }, "division", { "${it.division} 부서" })
     *
     *           결과 : [{"code" : "AD", "division" : "경영진 부서"}, {"code" : "DEV", "division" : "개발 부서"}]
     */
    inline fun <reified T : Enum<T>> fromEnumConstToListMap(
        firstKey: String,
        setFirstVal: (T) -> String,
        secondKey: String,
        setSecondVal: (T) -> String,
    ): List<Map<String, String>> = enumValues<T>().map { enumValue ->
        mapOf(
            firstKey to setFirstVal(enumValue),
            secondKey to setSecondVal(enumValue),
        )
    }

    /**
     * Definition : 제너릭 타입 리스트의 객체에 접근하여 지정한 키 이름과 객체 속성으로
     *              [{"firstKey" : setFirstVal, "secondKey" : setSecondVal }, ...] 형태 맵 리스트 반환
     *
     * Parameter :
     *            objList : 변환 대상 객체 리스트
     *            firstKey : 맵의 첫번째 키 이름
     *            setFirstVal : 맵의 첫번쨰 값 지정 익명함수, 객체를 인자로 받음 (EX. { it.property } )
     *            secondKey : 맵의 두번째 키 이름
     *            setSecondVal : 맵의 두번쨰 값 지정 익명함수, 객체를 인자로 받음
     *
     * Example : class Person(val name: String, val age: Int)
     *           ListMapMakerUtil.makeFromList(personList, "name", { it.name }, "age") { it.age }
     *
     *           결과 : [{"name" : "김철수", "age" : "20"}, {"name" : "김영희", "age" : "25"}]
     */
    inline fun <T : Any> fromDtoListToListMap(
        dtoList: List<T>,
        firstKey: String,
        setFirstVal: (T) -> String,
        secondKey: String,
        setSecondVal: (T) -> String,
    ): List<Map<String, String>> = dtoList.map { value ->
        mapOf(
            firstKey to setFirstVal(value),
            secondKey to setSecondVal(value),
        )
    }
}