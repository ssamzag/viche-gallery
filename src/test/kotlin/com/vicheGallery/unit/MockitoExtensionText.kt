package com.vicheGallery.unit

import com.vicheGallery.post.ui.PostController
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@ExtendWith(MockitoExtension::class)
//@ActiveProfiles("test")
class MockitoExtensionTest {

    private var mockMvc: MockMvc? = null

    @InjectMocks
    lateinit var postController: PostController

    @Test
    fun test() {
        //mockMvc = MockMvcBuilders.standaloneSetup(postController).build()
    }

}