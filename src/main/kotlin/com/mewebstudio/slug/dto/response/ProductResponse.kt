package com.mewebstudio.slug.dto.response

import com.mewebstudio.slug.entity.Product
import java.time.LocalDateTime

data class ProductResponse(
    var id: String,
    var categoryId: String,
    var categoryName: String,
    var title: String,
    var slug: String,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) : AbstractBaseResponse() {

    companion object {
        fun convert(product: Product): ProductResponse = ProductResponse(
            id = product.id,
            categoryId = product.category!!.id,
            categoryName = product.category!!.name!!,
            title = product.title!!,
            slug = product.slug!!,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}
