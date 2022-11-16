package com.vicheGallery.post.ui

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.jayway.jsonpath.JsonPath
import com.vicheGallery.exceptionResponse.dto.Error
import com.vicheGallery.exceptionResponse.dto.ErrorResponse
import com.vicheGallery.post.dto.PostRequest
import io.netty.channel.unix.Errors
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
internal class PostControllerTest(private var mockMvc: MockMvc) {
    @Test
    @DisplayName("포스트 작성시 제목이 비었으면 에러가 발생")
    fun titleEmptyError() {
        mockMvc.perform(
            post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Gson().toJson(PostRequest("", "내용임", null) ))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value(400))
            .andExpect(jsonPath("$.message").value("Valid Error"))
            .andExpect(jsonPath("$.validation[0].field").value("title"))
            .andExpect(jsonPath("$.validation[0].message").value("타이틀을 입력하세요."))
            .andDo(print())
    }

    @Test
    @DisplayName("포스트 작성시 내용이 비었으면 에러가 발생")
    fun contentEmptyError() {
        mockMvc.perform(
            post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Gson().toJson(PostRequest("제목", "", null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value(400))
            .andExpect(jsonPath("$.message").value("Valid Error"))
            .andExpect(jsonPath("$.validation[0].field").value("content"))
            .andExpect(jsonPath("$.validation[0].message").value("내용을 입력하세요."))
            .andDo(print())
    }

    @Test
    @DisplayName("포스트를 작성하면 id 값을 반환한다")
    fun createPost() {
        val content: String = jacksonObjectMapper().writeValueAsString(PostRequest("hi", "why", null))

        mockMvc.perform(
            post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"hi\", \"content\":\"why\"}")
        )
            .andExpect(status().isCreated)
            .andDo(print())
    }

    @Test
    @DisplayName("포스트 글 조회")
    fun getPost() {
        mockMvc.perform(get("/posts/1"))
            .andExpect(status().isOk)
    }
}