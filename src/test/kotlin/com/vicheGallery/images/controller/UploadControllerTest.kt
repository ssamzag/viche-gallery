package com.vicheGallery.images.controller

import org.junit.jupiter.api.Test

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
internal class UploadControllerTest(private var mockMvc: MockMvc) {

    @Test
    fun upload() {
        val mockMultipartFile = MockMultipartFile("multipartFiles", "image.jpg", "image/jpg", "<<image data>>".byteInputStream())
        mockMvc.perform(MockMvcRequestBuilders.multipart("/images/upload")
            .file(mockMultipartFile))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}