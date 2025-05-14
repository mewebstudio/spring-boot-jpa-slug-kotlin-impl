package com.mewebstudio.slug.service

import com.mewebstudio.slug.dto.request.CreateCategoryRequest
import com.mewebstudio.slug.dto.request.UpdateCategoryRequest
import com.mewebstudio.slug.entity.Category
import com.mewebstudio.slug.exception.NotFoundException
import com.mewebstudio.slug.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun findAll(): List<Category> =
        categoryRepository.findAll()

    fun findById(id: String): Category =
        categoryRepository.findById(id).orElseThrow {
            NotFoundException("Category not found with id: $id")
        }

    fun create(request: CreateCategoryRequest): Category = categoryRepository.save(Category().apply {
        name = request.name
    })

    fun update(id: String, request: UpdateCategoryRequest): Category = run {
        val category = findById(id)
        request.name?.let {
            category.name = it
        }

        categoryRepository.save(category)
    }

    fun delete(id: String) = categoryRepository.delete(findById(id))
}
