package com.mewebstudio.slug.service

import com.mewebstudio.slug.dto.request.CreateProductRequest
import com.mewebstudio.slug.dto.request.UpdateProductRequest
import com.mewebstudio.slug.entity.Product
import com.mewebstudio.slug.exception.NotFoundException
import com.mewebstudio.slug.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryService: CategoryService
) {
    fun findAll(): List<Product> = productRepository.findAll()

    fun findById(id: String): Product =
        productRepository.findById(id).orElseThrow {
            NotFoundException("Product not found with id: $id")
        }

    fun create(request: CreateProductRequest): Product = productRepository.save(Product().apply {
        category = categoryService.findById(request.categoryId!!)
        title = request.title
    })

    fun update(id: String, request: UpdateProductRequest): Product = run {
        val product = findById(id)
        request.categoryId?.let { product.category = categoryService.findById(it) }
        request.title?.let { product.title = it }
        productRepository.save(product)
    }

    fun delete(id: String) = productRepository.delete(findById(id))
}
