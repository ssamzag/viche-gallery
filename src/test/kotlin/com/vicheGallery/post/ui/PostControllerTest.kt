package com.vicheGallery.post.ui

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.vicheGallery.member.domain.Member
import com.vicheGallery.member.domain.MemberRepository
import com.vicheGallery.member.domain.SsoType
import com.vicheGallery.post.application.PostService
import com.vicheGallery.post.dto.PostRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
internal class PostControllerTest(

    @Autowired
    private var objectMapper: ObjectMapper? = null,

    @Autowired
    private var mockMvc: MockMvc,

    @Mock
    private val memberRepository: MemberRepository,

    @InjectMocks
    private val postService: PostService

) {
    @BeforeEach
    fun setup(context: WebApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
        val member = Member(null, "email", "pw", "test", SsoType.KAKAO)

        given(memberRepository.save(member)).willReturn(member)
//        val perform = mockMvc.perform(post("/auth/login/token")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content("{\"id\":  \"email\", \"password\":  \"pw\"}"));
//        println(perform.andReturn())

    }

    @Test
    @DisplayName("포스트 작성시 제목이 비었으면 에러가 발생")
    fun titleEmptyError() {
        mockMvc.perform(
            post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Gson().toJson(PostRequest("", "내용임", null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value(400))
            //.andExpect(jsonPath("$.message").value("Valid Error"))
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
//                .content("{\"title\":\"hi\", \"content\":\"why\"}")
                .content(content)
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