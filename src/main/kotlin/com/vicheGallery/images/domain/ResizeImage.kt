package com.vicheGallery.images.domain

import org.springframework.stereotype.Component
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileInputStream
import javax.imageio.ImageIO
import javax.swing.ImageIcon

@Component
class ResizeImage {
    fun imageResize(originalFilePath: String, formatName: String, newFileFullPath: String) {
        val file = File(originalFilePath)
        val inputStream = FileInputStream(file)
        val img = ImageIcon(file.toString()).image
        val resizeWidth = img.getWidth(null) / 3
        val resizeHeight = img.getHeight(null) / 3
        val resizedImage = resize(inputStream, resizeWidth, resizeHeight)

        ImageIO.write(resizedImage, formatName, File(newFileFullPath))
    }

    private fun resize(inputStream: FileInputStream, width: Int, height: Int): BufferedImage {
        val inputImage = ImageIO.read(inputStream)
        val outputImage = BufferedImage(width, height, inputImage.type)

        val createGraphics = outputImage.createGraphics()
        createGraphics.drawImage(inputImage, 0, 0, width, height, null)
        createGraphics.dispose()

        return outputImage
    }

}