package com.mewebstudio.slug.dto.request

import jakarta.validation.constraints.NotBlank

data class CreateCategoryRequest(
    @field:NotBlank(message = "Name cannot be blank")
    var name: String = ""
)
