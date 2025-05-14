package com.mewebstudio.slug.generator

import com.github.slugify.Slugify
import com.mewebstudio.springboot.jpa.slug.kotlin.ISlugGenerator
import com.mewebstudio.springboot.jpa.slug.kotlin.SlugOperationException

class SlugifySlugGenerator : ISlugGenerator {
    private val slugify: Slugify = Slugify.builder().lowerCase(true).build()

    override fun generate(input: String?): String {
        try {
            if (input.isNullOrBlank()) {
                throw SlugOperationException("Input cannot be null or blank: $input")
            }

            var slug = slugify.slugify(input)
            if (slug.length > 255) {
                slug = slug.substring(0, 255)
            }
            return slug
        } catch (e: Exception) {
            throw SlugOperationException("Slug generation failed: ${e.message}", e)
        }
    }
}
