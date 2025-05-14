package com.mewebstudio.slug.repository

import com.mewebstudio.slug.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, String>
