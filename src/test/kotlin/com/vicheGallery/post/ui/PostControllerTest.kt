package com.vicheGallery.post.ui

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.vicheGallery.post.dto.PostRequest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
internal class PostControllerTest(private var mockMvc: MockMvc) {

    @Test
    @DisplayName("포스트를 작성하면 id 값을 반환한다")
    fun createPost() {
        val content: String = jacksonObjectMapper().writeValueAsString(PostRequest("hi", "why"))

        print(content)
        mockMvc.perform(
            post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"dd\", \"contents\":\"컨텐츠임\"}")
        )
            .andExpect(status().isCreated)
            .andDo(print())
    }
}