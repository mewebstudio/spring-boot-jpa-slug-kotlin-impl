package com.mewebstudio.slug

import com.mewebstudio.slug.generator.SlugifySlugGenerator
import com.mewebstudio.springboot.jpa.slug.kotlin.EnableSlug
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableSlug(generator = SlugifySlugGenerator::class)
class SlugApplication

fun main(args: Array<String>) {
    runApplication<SlugApplication>(*args)
}
