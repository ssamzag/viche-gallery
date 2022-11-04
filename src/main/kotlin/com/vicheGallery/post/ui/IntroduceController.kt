package com.vicheGallery.post.ui

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IntroduceController {

    @GetMapping("/hello-world-kotlin")
    fun helloWorldKotlin(): String {
        return "Hello world and kotlin!"
    }
}