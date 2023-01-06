package com.vicheGallery.post.application

import com.vicheGallery.post.domain.Post
import com.vicheGallery.post.repository.PostRepository
import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.dto.PostResponse
import com.vicheGallery.post.dto.PostsResponse
import com.vicheGallery.post.dto.UpdateRequest
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
    @DisplayName("존재하지 않는 PostId를 입력하면 예외가 발생한다")
    fun readErrorTest() {
        assertThatThrownBy { postService.findByPostIdOrThrow(1L) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("존재하지 않는 글입니다.")
    }

    @Test
    @DisplayName("포스트 목록 기능이 내림차순으로 포스트를 반환한다")
    fun findAllDescTest() {
        // given
        postService.write(PostRequest("title1", "content1", listOf("a.jpg")))
        postService.write(PostRequest("title2", "content2", listOf("b.jpg")))

        // when
        val findAllDesc: PostsResponse = postService.findAllDesc()

        // then
        assertThat(findAllDesc.postResponses).hasSize(2)
        assertPostResponseTest(findAllDesc.postResponses[0], "title2", "content2", "b.jpg")
        assertPostResponseTest(findAllDesc.postResponses[1], "title1", "content1", "a.jpg")
    }

    private fun assertPostResponseTest(postResponse: PostResponse, title: String, content: String, file: String) {
        assertThat(postResponse.title).isEqualTo(title)
        assertThat(postResponse.content).isEqualTo(content)
        assertThat(postResponse.thumbnailFile).isEqualTo(file)
    }

    @Test
    @DisplayName("포스트 삭제 기능이 정상 동작한다")
    fun deletePostTest() {
        // given
        val post = postRepository.save(Post("title", "content"))

        // when
        postService.deletePost(post.id!!)

        // then
        val result = postRepository.findAll()
        assertThat(result[0].deleted).isTrue
    }


    @Test
    @DisplayName("포스트 삭제 기능에 유효하지 않은 포스트 id 를 입력하면 예외가 발생한다")
    fun deletePostExceptionTest() {
        assertThatThrownBy { postService.deletePost(1L) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("삭제된 글입니다.")
    }

    @Test
    @DisplayName("포스트 수정 기능이 정상 동작한다")
    fun updatePostTest() {
        // given
        val post = postRepository.save(Post("title", "content"))

        // when
        postService.updatePost(post.id!!, UpdateRequest("title1", "content2", null))

        // then
        val result = postRepository.findById(post.id!!)
        assertThat(result.get().title).isEqualTo("title1")
        assertThat(result.get().content).isEqualTo("content2")
    }

    @Test
    @DisplayName("포스트 수정 기능 동작시 포스트가 없으면 예외가 발생한다")
    fun updatePostExceptionTest() {
        assertThatThrownBy { postService.updatePost(1L, UpdateRequest("title1", "content2", null)) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("삭제된 글입니다.")

    }
}