package com.vicheGallery.post.application

import com.vicheGallery.post.domain.PostRepository
import com.vicheGallery.post.dto.PostRequest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@Transactional
internal class PostServiceTest(
    private var postService: PostService,
    private var postRepository: PostRepository
) {

    @BeforeEach
    fun setup() {
        postRepository.deleteAll()
    }

    @Test
    @DisplayName("글 작성")
    fun writeTest() {
        val write = postService.write(PostRequest("제목", "내용", null))
        val post = postRepository.findById(write!!).get()

        assertThat(post.title).isEqualTo("제목")
        assertThat(post.content).isEqualTo("내용")
    }

    @Test
    @DisplayName("포스트 글을 조회한다")
    fun readTest() {
        val write = postService.write(PostRequest("title", "content", null))

        val findByPostId = postService.findByPostIdOrThrow(write!!)

        assertThat(findByPostId).isNotNull
        assertThat(findByPostId.title).isEqualTo("title")
        assertThat(findByPostId.content).isEqualTo("content")
    }

    @Test
    @DisplayName("없는 글 조회시 예외 발생")
    fun readErrorTest() {
        assertThatThrownBy { postService.findByPostIdOrThrow(1L) }.hasMessage("존재하지 않는 글입니다.")
    }

}