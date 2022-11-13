package com.vicheGallery.work.dto.mapper

import com.vicheGallery.work.domain.Work
import com.vicheGallery.work.domain.WorkAttachments
import com.vicheGallery.work.dto.WorkWriteRequest
import com.vicheGallery.work.dto.WorkWriteResponse
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface WorkMapper {
    companion object {
        //val converter:WorkMapper = Mappers.getMapper(WorkMapper::class.java)
    }


//    @Mapping(source="attachments", target="attachments.workAttachments")
//     fun toModel(request: WorkWriteRequest) : Work
}