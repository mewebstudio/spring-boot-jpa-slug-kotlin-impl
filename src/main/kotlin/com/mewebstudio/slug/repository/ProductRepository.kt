package com.mewebstudio.slug.repository

import com.mewebstudio.slug.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>
