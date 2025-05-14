package com.mewebstudio.slug.controller

import com.mewebstudio.slug.dto.request.CreateCategoryRequest
import com.mewebstudio.slug.dto.request.UpdateCategoryRequest
import com.mewebstudio.slug.dto.response.CategoryResponse
import com.mewebstudio.slug.service.CategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping
    fun list(): ResponseEntity<List<CategoryResponse>> =
        ResponseEntity.ok(categoryService.findAll().map { CategoryResponse.convert(it) })

    @PostMapping
    fun create(@Valid @RequestBody request: CreateCategoryRequest): ResponseEntity<CategoryResponse> =
        ResponseEntity(CategoryResponse.convert(categoryService.create(request)), HttpStatus.CREATED)

    @GetMapping("/{id}")
    fun show(@PathVariable id: String): ResponseEntity<CategoryResponse> =
        ResponseEntity.ok(CategoryResponse.convert(categoryService.findById(id)))

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @Valid @RequestBody request: UpdateCategoryRequest
    ): ResponseEntity<CategoryResponse> =
        ResponseEntity.ok(CategoryResponse.convert(categoryService.update(id, request)))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        categoryService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
