<script setup type="ts">
import {useStore} from "vuex";
import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import api from "@/api";
import axios from "axios";

const router = useRouter()
const props = defineProps({
  com: {
    type: Object,
    require: true
  },
  postId: {
    type: [Number, String],
    require: true
  }
})


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

const showDeleteModal = (commentId) => {
  commentRemoveModal.value = true
  removeCommendId.value = commentId
}

const showModifyComment = (comment) => {
  commentReplyModal.value = false
  teleportModifyModal.value = `#comment_${comment.id}`
  commentModifyId.value = comment.id
  commentModifyModal.value = true
  commentModifyContent.value = comment.content
}

const showReplyModal = (comment) => {
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
    if (res.response.data.validation) {
      alert(res.response.data.validation[0].message)
      return
    }

    alert(res.response.data)
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
    alert("암호를 확인해 주세요")
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

const closeRemoveModal = (event) => {
  if (event.target.className != "comment-item") {
    return
  }
  commentRemoveModal.value = false
}
</script>

<template>
  <li :id="'comment_' + props.com.id"
      class="comment">
    <div class="author-meta" style="font-size:18px">
      <img
          src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"
          class="avatar" alt="">
      <span class="nickname">
                  <a href="javascript:void(0)">{{ props.com.nickname }}</a></span>
      <!--                <span class="date">-->
      <!--                  {{com.createdDate.substring(2, 10) + " " + com.createdDate.substring(11, 16)}}-->
      <!--                </span>-->
    </div>

    <div class="comment-meta">
                <span class="date">
                  {{ props.com.createdDate.substring(0, 10) + " " + props.com.createdDate.substring(11, 16) }}
                </span>
      <span class="date" style="padding-left: 0px">
                  <a href="javascript:void(0)" @click="showReplyModal(props.com)">답글쓰기</a>
                </span>
    </div>
    <p>{{ props.com.content }}</p>
    <div class="control post-meta">
                <span class="post-meta">
                  <a href="javascript:void(0)" @click="showModifyComment(props.com);">수정</a>
                </span>
      <span class="post-meta">
                  <a href="javascript:void(0)" @click="showDeleteModal(props.com.id)">삭제</a>
                </span>
    </div>
  </li>
</template>