package com.vicheGallery.post.dto

import com.vicheGallery.post.domain.Post

data class PostRequest(
    var title: String,
    var contents: String
) {
    fun toPost(): Post {
        return Post(title = title, contents = contents)
    }
}