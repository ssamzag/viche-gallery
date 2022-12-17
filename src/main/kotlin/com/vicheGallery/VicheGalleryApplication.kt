package com.vicheGallery

import com.vicheGallery.config.QueryDslConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
class VicheGalleryApplication

fun main(args: Array<String>) {
    runApplication<VicheGalleryApplication>(*args)
}
