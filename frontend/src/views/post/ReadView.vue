<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {useRoute, useRouter} from "vue-router";
import {useStore} from "vuex";
import api from "@/api";
import {useAlert} from '@/composables/alert'
import BaseTitle from "@/components/BaseTitle.vue";
import {useUserStore} from "@/stores/user";
import {useAlertStore} from "@/stores/alert";

const router = useRouter()
const {vSuccess, vAlert} = useAlertStore()

const commentRemoveModal = ref(false)

const commentModifyModal = ref(false)
const commentModifyId = ref(0)
const commentModifyTeleportTo = ref("body")

const commentCount = ref(0)
const root = ref<HTMLElement | null>(null);
const comment = ref("")
const removeCommendId = ref(0)

const commentReplyTeleportTo = ref("body")
const commentReplyToNick = ref("")
const commentReplyRefCommentId = ref(0)
const commentReplyModal = ref(false)

const {loginStatus} = useUserStore()
const postId = useRoute().params.postId

const replyForm = ref({
  content: "",
  password: "",
  nickname: ""
})

const commentForm = ref({
  content: "",
  password: "",
  nickname: ""
})

const post = ref({
  title: "",
  content: "",
  createdDate: ""

})

const comments = ref([])

const updatePost = () => {
  router.replace(`/post/modify/${postId}`)
}

const deletePost = () => {
  if (!confirm("삭제 하실라우?")) {
    return
  }

  api.delete(`/api/posts/${postId}`)
      .then(() => {
        vSuccess("삭제완료")
        router.replace("/post")
      })
      .catch(() => {
        vAlert("삭제 실패");
      })
}

const setPost = () => {
  api.get(`/api/posts/${postId}`).then(response => {
    post.value.title = response.data.title
    // const clean = sanitizeHtml(response.data.content, {
    //   allowedTags: ['p', 'b', 'i', 'em', 'strong', 'a', 'br', 'li', 'blockquote', 'h1', 'ol',
    //   'spellcheck', 'pre', 'span'],
    //   allowedAttributes: {
    //     'a': ['href']
    //   },
    //   allowedIframeHostnames: ['www.youtube.com']
    // });
    // post.value.content = clean
    post.value.content = response.data.content
    post.value.createdDate = response.data.createdDate.substring(0, 10).replaceAll("-", ". ")
  })
}

const bindComments = async () => {
  const commentResponse = await getComments()

  comments.value = commentResponse.data.comments
  commentCount.value = getCommentCount(commentResponse.data.comments)
}

const getComments = async () => {
  return await api.get(`/api/comment/${postId}`)
}

function getCommentCount(comments: any) {
  return comments.length + getSubCommentCount(comments);
}

function getSubCommentCount(comments: any) {
  return comments.map((m: any) => m.child.length)
      .reduce((a: number, b: number) => a + b, 0);
}

const showDeleteModal = (commentId: number) => {
  commentRemoveModal.value = true
  removeCommendId.value = commentId
}

const showModifyComment = (comment: any) => {
  commentReplyModal.value = false
  commentModifyTeleportTo.value = `#comment_${comment.id}`
  commentModifyId.value = comment.id
  commentModifyModal.value = true
  replyForm.value.content = comment.content
}

const showReplyModal = (comment: any) => {
  commentModifyModal.value = false
  commentReplyTeleportTo.value = `#comment_${comment.id}`
  commentReplyRefCommentId.value = comment.refComment == null ? comment.id : comment.refComment.id
  commentReplyToNick.value = comment.nickname
  commentReplyModal.value = true
}

onMounted(() => {
  setPost()
  bindComments()
})

const insertComment = () => {
  axios.post(`/api/comment/${postId}`, {
    content: commentForm.value.content,
    nickname: commentForm.value.nickname,
    password: commentForm.value.password
  }, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(res => {
    bindComments()
    commentForm.value.password = ""
    commentForm.value.content = ""
  }).catch((err) => {
    alert(err.response.data.validation[0].message)
  })
}

const updateComment = () => {
  axios.put(`/api/comment/${commentModifyId.value}`, {
    content: replyForm.value.content,
    password: replyForm.value.password,
  }).then(() => {
    commentModifyModal.value = false
    bindComments()
    replyForm.value.content = ""
    replyForm.value.password = ""
  }).catch((res) => {
    if (res.response.data.validation) {
      alert(res.response.data.validation[0].message)
      return
    }

    alert(res.response.data)
  })
}

const deleteComment = (password: string) => {
  axios.delete(`/api/comment/${removeCommendId.value}?password=${password}`, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(() => {
    bindComments()
    commentRemoveModal.value = false
    removeCommendId.value = 0
  }).catch(() => {
    vAlert("암호를 확인해 주세요")
  })
}

const replyComment = () => {
  axios.post(`/api/comment/reply/${postId}`, {
    content: replyForm.value.content,
    nickname: replyForm.value.nickname,
    password: replyForm.value.password,
    refCommentId: commentReplyRefCommentId.value,
    replyToNick: commentReplyToNick.value,
  }, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(response => {
    commentReplyModal.value = false
    replyForm.value.content = ""
    replyForm.value.password = ""
    bindComments()
  }).catch(() => alert("에러"))
}

const goPostList = () => {
  router.push("/post")
}

const hideReplyModal = () => commentReplyModal.value = false
const hideModifyModal = () => commentModifyModal.value = false
</script>

<template>
  <title-component :title="post.title"></title-component>
  <base-title title="Post"></base-title>
  <b-col style="max-width: 1000px;">
    <b-row>
      <b-col>
        <div>
          <b-card-text class="category">
            잡담
          </b-card-text>
        </div>
        <h2 class="title">{{ post.title }}</h2>
        <div class="sub">
          <b-card-text class="post-meta">
            <span>비체</span>
            <span>{{ post.createdDate }}</span>
            <span v-if="loginStatus">
                <a href="#" @click.prevent="updatePost">수정</a>
              </span>
            <span v-if="loginStatus">
                <a href="#" @click.prevent="deletePost">삭제</a>
              </span>
          </b-card-text>
        </div>
      </b-col>
    </b-row>

    <b-row class="my-3">
      <div class="content " v-html="post.content" style="max-width:1000px;">
      </div>
    </b-row>

    <b-row>
      <div class="comments" ref="root">
        <h2>댓글<span class="count">{{ commentCount }}</span></h2>
        <base-comment-write-form @send="insertComment"
                                 showNicknameInput="true"
                                 v-model:password="commentForm.password"
                                 v-model:nickname="commentForm.nickname"
                                 v-model:content="commentForm.content"
                                 class="py-2"
        />
        <div class="comment-list">
          <ul v-for="comment in comments">
            <base-comment-detail-form :comment="comment"
                         @insertComment="insertComment"
                         @showReplyModal="showReplyModal"
                         @showModifyComment="showModifyComment"
                         @showDeleteModal="showDeleteModal"
            />
            <ul v-for="commentChild in comment.child">
              <base-comment-detail-form :comment="commentChild"
                                        @replyComment="replyComment"
                                        @showReplyModal="showReplyModal"
                                        @showModifyComment="showModifyComment"
                                        @showDeleteModal="showDeleteModal"
                                        is-reply=true
              />
            </ul>
          </ul>
        </div>

        <div style="border-top: 1px solid #e6e6e6; position: relative; min-height: 20px;"></div>
        <b-button squared variant="outline-secondary"
                  @click="goPostList"
                  style="font-size:12px">
          목록
        </b-button>
      </div>
    </b-row>
  </b-col>

  <teleport :to="commentReplyTeleportTo">
    <base-comment-write-form @send="replyComment"
                             @hideCommentWrite="hideReplyModal"
                             button-name="댓글답변"
                             showCancelButton="true"
                             showNicknameInput="true"
                             v-model:nickname="replyForm.nickname"
                             v-model:content="replyForm.content"
                             v-model:password="replyForm.password"
                             v-if="commentReplyModal"
    />
  </teleport>

  <teleport :to="commentModifyTeleportTo">
    <base-comment-write-form @send="updateComment"
                             @hideCommentWrite="hideModifyModal"
                             button-name="댓글수정"
                             showCancelButton="true"
                             v-model:content="replyForm.content"
                             v-model:password="replyForm.password"
                             v-if="commentModifyModal"
    />
  </teleport>

  <teleport to="#app">
    <base-modal v-model="commentRemoveModal"
                message="삭제 하시겠습니까?"
                @confirm="deleteComment"
                confirmButtonName="삭제"
    />
  </teleport>
</template>

<style>
@import "@/assets/comment.css";

.title {
  font-size: 1.6rem;
  font-weight: 600;
  color: #383838;
  margin-top: 10px;
}

.sub {
  margin-top: 10px;
  font-size: 0.78rem;
}

.regDate {
  margin-left: 10px;
  color: #6b6b6b;
}

.content img {
  width: 100%;
  height: auto;
  object-fit: contain;
  display: block;
}

.content {
  font-size: 0.95rem;
  margin-top: 12px;
  color: #616161;
  white-space: break-spaces;
  line-height: 1.5;
}

.modelPopup {
  background: rgba(0, 0, 0, .8);
  bottom: 0;
  left: 0;
  margin: 0;
  position: fixed;
  right: 0;
  top: 0;
  z-index: 9998;
  text-align: center;
  display: table;
  table-layout: fixed;
  width: 100%;
  height: 100%;
}

.comment-item {
  display: table-cell;
  vertical-align: middle;
}

.reply-to {
  font-weight: 700;
  padding-right: 4px;
  color: #2761c2
}

.content p {
  margin-bottom: 0;
}

.category {
  margin-bottom: 8px;
  font-weight: 700;
  font-size: 0.875em;
  color: #999;
}

.title {
  font-size: 1.5em;
  font-weight: 400;
  line-height: 1.0666;
}

</style>