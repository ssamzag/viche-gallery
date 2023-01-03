package com.vicheGallery.images.repsitory

import com.vicheGallery.images.domain.ImageFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageFileRepository : JpaRepository<ImageFile,Long>