package com.mewebstudio.slug.dto.request

import jakarta.validation.constraints.NotBlank

data class CreateProductRequest(
    @field:NotBlank(message = "Category ID cannot be blank")
    val categoryId: String? = null,

    @field:NotBlank(message = "Title cannot be blank")
    val title: String? = null
)
