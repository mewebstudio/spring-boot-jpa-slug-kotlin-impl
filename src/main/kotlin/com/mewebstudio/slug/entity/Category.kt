package com.mewebstudio.slug.entity

import com.mewebstudio.springboot.jpa.slug.kotlin.ISlugSupport
import com.mewebstudio.springboot.jpa.slug.kotlin.SlugField
import com.mewebstudio.springboot.jpa.slug.kotlin.SlugListener
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Table

@Entity
@Table(name = "categories")
@EntityListeners(SlugListener::class)
class Category : AbstractBaseEntity(), ISlugSupport<String> {
    @SlugField
    var name: String? = null

    @Column(name = "slug", unique = true, nullable = false)
    override var slug: String? = null
}
