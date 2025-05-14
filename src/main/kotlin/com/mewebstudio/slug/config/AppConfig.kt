package com.mewebstudio.slug.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        objectMapper.registerModule(JavaTimeModule())
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.propertyNamingStrategy = PropertyNamingStrategies.LOWER_CAMEL_CASE

        JsonMapper.builder()
            .disable(MapperFeature.USE_GETTERS_AS_SETTERS)
            .configure(MapperFeature.USE_STD_BEAN_NAMING, true)

        return objectMapper
    }
}