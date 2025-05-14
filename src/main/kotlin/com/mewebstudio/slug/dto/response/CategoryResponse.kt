package com.mewebstudio.slug.dto.response

import com.mewebstudio.slug.entity.Category
import java.time.LocalDateTime

data class CategoryResponse(
    var id: String,
    var name: String,
    var slug: String,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) : AbstractBaseResponse() {

    companion object {
        fun convert(category: Category): CategoryResponse {
            return CategoryResponse(
                id = category.id,
                name = category.name!!,
                slug = category.slug!!,
                createdAt = category.createdAt,
                updatedAt = category.updatedAt
            )
        }
    }
}
