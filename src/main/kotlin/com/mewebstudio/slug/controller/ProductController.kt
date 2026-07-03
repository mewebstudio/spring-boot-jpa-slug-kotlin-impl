package com.mewebstudio.slug.controller

import com.mewebstudio.slug.dto.request.CreateProductRequest
import com.mewebstudio.slug.dto.request.UpdateProductRequest
import com.mewebstudio.slug.dto.response.ProductResponse
import com.mewebstudio.slug.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun list(): ResponseEntity<List<ProductResponse>> =
        ResponseEntity.ok(productService.findAll().map { ProductResponse.convert(it) })

    @PostMapping
    fun create(@Valid @RequestBody request: CreateProductRequest): ResponseEntity<ProductResponse> =
        ResponseEntity(ProductResponse.convert(productService.create(request)), HttpStatus.CREATED)

    @GetMapping("/{id}")
    fun show(@PathVariable id: String): ResponseEntity<ProductResponse> =
        ResponseEntity.ok(ProductResponse.convert(productService.findById(id)))

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @Valid @RequestBody request: UpdateProductRequest
    ): ResponseEntity<ProductResponse> =
        ResponseEntity.ok(ProductResponse.convert(productService.update(id, request)))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        productService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
