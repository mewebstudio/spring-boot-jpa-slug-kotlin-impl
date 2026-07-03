package com.mewebstudio.slug.entity

import com.mewebstudio.springboot.jpa.slug.kotlin.ISlugSupport
import com.mewebstudio.springboot.jpa.slug.kotlin.SlugField
import com.mewebstudio.springboot.jpa.slug.kotlin.SlugListener
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "products")
@EntityListeners(SlugListener::class)
@SlugField("category.name", "title")
class Product : AbstractBaseEntity(), ISlugSupport<String> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    var category: Category? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(name = "slug", unique = true, nullable = false)
    override var slug: String? = null
}
