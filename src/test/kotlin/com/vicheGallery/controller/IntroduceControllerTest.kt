package com.vicheGallery.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class IntroduceControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloWorldKotlin() {
        mockMvc.perform(get("/hello-world-kotlin"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello world and kotlin!"))
            .andDo(MockMvcResultHandlers.print())
    }
}