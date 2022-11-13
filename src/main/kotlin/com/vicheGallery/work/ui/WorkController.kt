package com.vicheGallery.work.ui

import com.vicheGallery.work.dto.WorkWriteRequest
import com.vicheGallery.work.application.WorkService
import com.vicheGallery.work.dto.WorkReadResponse
import com.vicheGallery.work.dto.WorkWriteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/works")
@RestController
class WorkController(
    val workService: WorkService
) {
    @PostMapping
    fun write(@RequestBody workWriteRequest: WorkWriteRequest): ResponseEntity<WorkWriteResponse> {
        val created = workService.create(workWriteRequest);
        return ResponseEntity.created(URI.create("/work/" + created.id))
            .body(created)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<WorkReadResponse>> {
        val readResponse = workService.findAll()
        return ResponseEntity.ok().body(readResponse)
    }

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<WorkReadResponse> {
        val readResponse = workService.read(id)
        return ResponseEntity.ok().body(readResponse)
    }
}