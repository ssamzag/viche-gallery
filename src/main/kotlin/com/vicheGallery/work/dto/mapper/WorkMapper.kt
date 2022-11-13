package com.vicheGallery.work.dto.mapper

interface WorkWriterEntity<W, R> {
    fun toResponse(work: W) : R
}