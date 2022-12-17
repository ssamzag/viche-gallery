<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
import {useStore} from "vuex";
import api from "@/api";

const router = useRouter()
const commentRemoveModal = ref(false)

const commentModifyModal = ref(false)
const commentModifyContent = ref("")
const commentModifyId = ref(0)
const teleportModifyModal = ref("body")
const commentModifyPassword = ref("")

const commentPasswordInput = ref("")
const commentCount = ref(0)
const root = ref<HTMLElement | null>(null);
const comment = ref("")
const nickname = ref("")
const password = ref("")
const replayPassword = ref("")
const removeCommendId = ref(0)

const commentReplyTeleportTo = ref("body")
const commentReplyNickname = ref("")
const commentReplyPassword = ref("")
const commentReplyContent = ref("")
const commentReplyToNick = ref("")
const commentReplyRefCommentId = ref(0)
const commentReplyModal = ref(false)
const commentReply = ref({})

const props = defineProps({
  postId: {
    type: [Number, String],
    require: true
  }
})

const store = useStore()

const post = ref({
  title: "",
  content: ""
})

const comments = ref([
  {
    id: 0,
    content: "",
    replyToNick: "",
    createdDate: "",
    nickname: "",
    child: [{
      id: 0,
      content: "",
      refComment: {
        id: 0,
        content: ""
      },
      replyToNick: "",
      createdDate: "",
      nickname: "",
    }]
  }
])

const updatePost = () => {
  router.replace(`/post/modify/${props.postId}`)
}
const deletePost = () => {
  const isDeleted = confirm("삭제 하실라우?")
  if (!isDeleted) {
    return
  }
  api.delete(`/api/posts/${props.postId}`)
      .then(() => router.replace("/post"))
      .catch(() => {
        alert("삭제 실패");
      })
}

const setPost = () => {
  api.get(`/api/posts/${props.postId}`).then(response => {
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
  })
}

const setComments = () => {
  api.get(`/api/comment/${props.postId}`)
      .then(response => {
        comments.value = response.data.comments
        commentCount.value = comments.value.length
      })
}

const showDeleteModal = (commentId: number) => {
  commentRemoveModal.value = true
  removeCommendId.value = commentId
}

const showModifyComment = (comment: any) => {
  commentReplyModal.value = false
  teleportModifyModal.value = `#comment_${comment.id}`
  commentModifyId.value = comment.id
  commentModifyModal.value = true
  commentModifyContent.value = comment.content
}

const showReplyModal = (comment: any) => {
  commentModifyModal.value = false
  commentReplyTeleportTo.value = `#comment_${comment.id}`
  commentReplyRefCommentId.value = comment.refComment == null ? comment.id : comment.refComment.id
  commentReplyToNick.value = comment.nickname
  commentReplyModal.value = true
  commentReply.value = comment
}

onMounted(() => {
  setPost()
  setComments()
})

const insertComment = () => {
  axios.post(`/api/comment/${props.postId}`, {
    content: comment.value,
    nickname: nickname.value,
    password: password.value
  }, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(response => {
    comment.value = "";
    nickname.value = "";
    password.value = "";
    setComments()
  }).catch((response) => {
    console.log(response)
    alert(response.response.data.validation[0].message)
  })
}

const updateComment = () => {
  axios.put(`/api/comment/${commentModifyId.value}`, {
    content: commentModifyContent.value,
    password: commentModifyPassword.value
  }).then(() => {
    commentModifyModal.value = false
    setComments()
  }).catch((res) => {
    alert(res.response.data.validation[0].message)
  })
}

const deleteComment = () => {
  axios.delete(`/api/comment/${removeCommendId.value}?password=${replayPassword.value}`, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(() => {
    setComments()
    commentRemoveModal.value = false
    removeCommendId.value = 0
  }).catch((res) => {
    console.log(res)
    alert(res.response.data)
  })
}

const replyComment = () => {
  axios.post(`/api/comment/reply/${props.postId}`, {
    content: commentReplyContent.value,
    nickname: commentReplyNickname.value,
    password: commentReplyPassword.value,
    refCommentId: commentReplyRefCommentId.value,
    replyToNick: commentReplyToNick.value,
  }, {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("token")
    }
  }).then(response => {
    commentReplyModal.value = false
    setComments()
  }).catch(() => alert("에러"))
}

const moveToList = () => {
  router.push("/post")
}

const closeRemoveModal = (event: any) => {
  if (event.target.className != "comment-item") {
    return
  }
  commentRemoveModal.value = false
}
</script>

<template>
  <b-col style="max-width: 1000px;">
    <b-row>
      <b-col>
        <div>
          <b-card-text class="text-muted">
            잡담
          </b-card-text>
        </div>
        <h2 class="title">{{ post.title }}</h2>
        <div class="sub">
          <b-card-text class="text-muted post-meta">
            <span>비체</span>
            <span>2022-02</span>
            <div class="post-meta" v-if="store.state.login" style="float:right">
              <span>
                <a href="javascript:void(0)" @click="updatePost">수정</a>
              </span>
              <span>
                <a href="javascript:void(0)" @click="deletePost">삭제</a>
              </span>
            </div>
          </b-card-text>
        </div>
      </b-col>
    </b-row>

    <b-row class="my-3">
      <div class="content " v-html="post.content" style="max-width:1000px;">
      </div>
    </b-row>
    <b-row class="my-3" style="max-width:1000px;">
      <b-col>

      </b-col>
    </b-row>
    <b-row>
      <div class="comments" ref="root">
        <h2>댓글<span class="count"><span>{{ commentCount }}</span></span></h2>
        <div class="comment-list">
          <ul v-for="com in comments">
            <li :id="'comment_' + com.id"
                class="comment">
              <div class="author-meta" style="font-size:18px">
                <img
                    src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"
                    class="avatar" alt="">
                <span class="nickname">
                  <a href="javascript:void(0)">{{ com.nickname }}</a></span>
                <!--                <span class="date">-->
                <!--                  {{com.createdDate.substring(2, 10) + " " + com.createdDate.substring(11, 16)}}-->
                <!--                </span>-->
              </div>

              <div class="comment-meta">
                <span class="date">
                  {{ com.createdDate.substring(0, 10) + " " + com.createdDate.substring(11, 16) }}
                </span>
                <span class="date" style="padding-left: 0px">
                  <a href="javascript:void(0)" @click="showReplyModal(com)">답글쓰기</a>
                </span>
              </div>
              <p>{{ com.content }}</p>
              <div class="control post-meta">
                <span class="post-meta">
                  <a href="javascript:void(0)" @click="showModifyComment(com);">수정</a>
                </span>
                <span class="post-meta">
                  <a href="javascript:void(0)" @click="showDeleteModal(com.id)">삭제</a>
                </span>
              </div>
            </li>
            <ul>
              <li :id="'comment_' + cc.id"
                  v-for="cc in com.child"
                  style="padding-left:20px"
                  class="comment">
                <div class="author-meta" style="font-size:18px">
                  <img
                      src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"
                      class="avatar" alt=""
                  >
                  <span class="nickname" style="padding-left:18px; padding-top:0px">
                  <a href="javascript:void(0)">{{ cc.nickname }}</a></span>
                  <!--                <span class="date">-->
                  <!--                  {{com.createdDate.substring(2, 10) + " " + com.createdDate.substring(11, 16)}}-->
                  <!--                </span>-->
                </div>
                <div class="comment-meta">
                  <span class="date">
                    {{ cc.createdDate.substring(0, 10) + " " + cc.createdDate.substring(11, 16) }}
                  </span>
                  <span class="date" style="padding-left: 0px">
                    <a href="javascript:void(0)" @click="showReplyModal(cc)">답글쓰기</a>
                  </span>
                </div>
                <p><span class="reply-to">{{ cc.replyToNick }}</span>{{ cc.content }}</p>

                <div class="control post-meta">
                <span class="post-meta">
                  <a href="javascript:void(0)" @click="showModifyComment(cc);">수정</a>
                </span>
                  <span class="post-meta">
                  <a href="javascript:void(0)" @click="showDeleteModal(cc.id)">삭제</a>
                </span>
                </div>
              </li>
            </ul>

          </ul>
        </div>

        <form method="post" style="margin: 0">
          <div class="comment-form">
            <div class="field">
              <input type="text" v-model="nickname" name="name" placeholder="이름">
              <input type="password" v-model="password" name="password" placeholder="암호">

              <!--              <div class="secret">-->
              <!--                <input type="checkbox" name="secret" id="secret">-->
              <!--                <label for="secret" tabindex="0">비밀댓글</label>-->
              <!--              </div>-->
            </div>
            <label for="comment" class="screen_out">댓글</label>
            <textarea id="comment" v-model="comment" name="comment" cols="" rows="4"
                      placeholder="소중한 댓글을 입력해 주세요."></textarea>
            <div class="d-flex justify-content-end" style="position: relative; float:left; margin-left:0">
<!--              <b-button squared variant="outline-secondary" @click="moveToList()" style="font-size:12px">목록</b-button>-->
            </div>
            <div class="submit">
              <b-button squared variant="outline-secondary" @click="insertComment()" style="font-size:12px">댓글달기
              </b-button>
            </div>
          </div>
        </form>
      </div>
    </b-row>
  </b-col>

  <teleport :to="commentReplyTeleportTo">
    <form method="post" style="margin: 0" v-if="commentReplyModal">
      <div class="comment-form" style="padding-top: 10px; ">
        <div class="field">
          <input type="text" v-model="commentReplyNickname" name="name" placeholder="이름">
          <input type="password" v-model="commentReplyPassword" name="password" placeholder="암호">

          <!--              <div class="secret">-->
          <!--                <input type="checkbox" name="secret" id="secret">-->
          <!--                <label for="secret" tabindex="0">비밀댓글</label>-->
          <!--              </div>-->
        </div>
        <label for="comment" class="screen_out">댓글</label>
        <textarea id="comment" v-model="commentReplyContent" name="comment" cols="" rows="4"
                  placeholder="답변할 댓글을 입력해 주세요."></textarea>
        <div class="submit">
          <b-button squared variant="outline-secondary" @click="commentReplyModal = false" style="font-size:12px">
            취소
          </b-button>
          <b-button squared variant="outline-secondary" @click="replyComment" style="font-size:12px">
            답변하기
          </b-button>
        </div>
      </div>
    </form>
  </teleport>

  <teleport :to="teleportModifyModal">
    <form method="post" style="margin: 0" v-if="commentModifyModal">
      <div class="comment-form" style="padding-top: 10px;">
        <div class="field">
          <input type="password" v-model="commentModifyPassword" name="password" placeholder="암호">

          <!--              <div class="secret">-->
          <!--                <input type="checkbox" name="secret" id="secret">-->
          <!--                <label for="secret" tabindex="0">비밀댓글</label>-->
          <!--              </div>-->
        </div>
        <label for="comment" class="screen_out">댓글</label>
        <textarea id="comment" v-model="commentModifyContent" name="comment" cols="" rows="4"
                  placeholder="수정할 댓글을 입력해 주세요."></textarea>
        <div class="submit">
          <b-button squared variant="outline-secondary" @click="commentModifyModal = false" style="font-size:12px">취소
          </b-button>
          <b-button squared variant="outline-secondary" @click="updateComment" style="font-size:12px">댓글수정
          </b-button>
        </div>
      </div>
    </form>
  </teleport>

  <teleport to="body">
    <div v-if="commentRemoveModal" class="modelPopup" @click="closeRemoveModal">
      <div class="comment-item">
        <div class="post-meta" style="padding-bottom: 10px">
          삭제하시겠습니까?<br>
        </div>
        <div class="comments">

          <div class="comment-form">

            <input type="password"
                   ref="commentPasswordInput"
                   @keyup.enter="deleteComment"
                   v-model="replayPassword"
                   name="password"
                   placeholder="암호"
                   style="margin-left:5px">
          </div>
        </div>
        <div class="post-meta">
          <span>
            <a href="javascript:void(0)" @click="deleteComment">삭제하기</a>
          </span>
          <span>
            <a href="javascript:void(0)" @click="commentRemoveModal = false">취소</a>
          </span>
        </div>
      </div>
    </div>
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

</style>