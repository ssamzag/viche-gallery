package com.vicheGallery.images.application

import com.vicheGallery.images.dto.UploadForm
import com.vicheGallery.images.repsitory.ImageFileRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import java.io.FileInputStream

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
class UploadServiceTest(
    val uploadService: UploadService,
    val imageFileRepository: ImageFileRepository,
    val webApplicationContext: WebApplicationContext
) {

    companion object {
        var multiPart1: MockMultipartFile? = null
        var multiPart2: MockMultipartFile? = null
    }

    @BeforeEach
    fun init() {
        multiPart1 = MockMultipartFile("file", "test.jpg", "multipart/form-data", FileInputStream("testFile1"))
        multiPart2 = MockMultipartFile("file", "test.jpg", "multipart/form-data", FileInputStream("testFile2"))
    }

    @Test
    @DisplayName("파일 업로드 기능이 정상 동작한다")
    fun saveTest() {
        val mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()

//        uploadService.save(UploadForm(listOf(multiPart1, multiPart2)))
    }

    @Test
    fun imageListTest() {
    }

    @Test
    fun downloadImageTest() {
    }

    @Test
    fun downloadThumbnailImageTest() {
    }
}