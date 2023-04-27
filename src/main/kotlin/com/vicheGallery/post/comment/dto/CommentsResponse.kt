package com.vicheGallery.comment.dto

import com.vicheGallery.comment.domain.Comment

data class CommentsResponse(
    val comments: List<CommentResponse>
) {
    companion object {
        fun of(comments: List<Comment>): CommentsResponse {
            val result = ArrayList<CommentResponse>()
            val map = HashMap<Long, CommentResponse>()

            comments.forEach {
                val commentResponse = CommentResponse(
                    id = it.id!!,
                    content = it.content,
                    isMember = it.userId != null,
                    replyToNick = it.replyToNick,
                    nickname = it.nickname,
                    createdDate = it.createdDate,
                    modifiedDate = it.modifiedDate,
                    refComment = it.refComment
                )
                map[commentResponse.id!!] = commentResponse

                if (it.refComment != null) {
                    map[it.refComment.id]?.child?.add(commentResponse)
                    return@forEach
                }
                result.add(commentResponse)
            }

            return CommentsResponse(result)
        }
    }


}
