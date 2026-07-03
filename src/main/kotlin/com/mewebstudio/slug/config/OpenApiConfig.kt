package com.mewebstudio.slug.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Slug Generator API")
                .description("Spring Boot JPA Slug Generator — Kotlin Implementation")
                .version("0.1.6")
                .license(License().name("MIT").url("https://opensource.org/licenses/MIT"))
        )
}
