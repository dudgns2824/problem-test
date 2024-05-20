package dudgns.com.backend.commons.infrastructure.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class ObjactMapperConfig {
    @Bean
    @Qualifier("4Generic")
    fun objectMapper4Generic(): ObjectMapper {
        val objectMapper = getObjectMapper()

        // DTO - 자동 변환용 object 의 class type 자동 추가
        val ptv: PolymorphicTypeValidator = BasicPolymorphicTypeValidator
            .builder()
            .allowIfBaseType(Any::class.java)
            .build()
        objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.EVERYTHING)

        return objectMapper
    }

    @Bean
    @Primary
    @Qualifier("4Normal")
    fun objectMapper4Normal(): ObjectMapper {
        return getObjectMapper()
    }

    private fun getObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.registerModules(JavaTimeModule())
        objectMapper.registerKotlinModule()

        // LocalDateTime
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        // Null Property, Empty Constructor
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        // Empty Constructor (registerModules(KotlinModule()) // deprecated)
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

        return objectMapper
    }
}
