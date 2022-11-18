<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
import {useStore} from "vuex";

const router = useRouter()

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

const comments = ref([])


const setPost = () => {
  axios.get(`/api/posts/${props.postId}`).then(response => {
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
  axios.get(`/api/comment/${props.postId}`)
      .then(response => {
        console.log(response.data)
        comments.value = []
        response.data.comments.forEach(r => {

          comments.value.push(r)
        })
      })
}

onMounted(() => {
  setPost()
  setComments()
})

const comment = ref("")
const nickname = ref("")
const password = ref("")

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
  }).catch(res => alert("에러"))
}

const moveToList = function () {
  router.push("/post")
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
            <span class="post-meta">비체</span>
            <span class="post-meta">2022-02</span>
            <span class="post-meta" v-if="store.state.login">
              <a href="post/modify">수정</a>
            </span>
            <span class="post-meta" v-if="store.state.login">
              <a href="post/delete">삭제</a>
            </span>
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
      <div class="comments">
        <h2>댓글<span class="count"><span id="commentCount58_0">0</span></span></h2>
        <div class="comment-list">
          <ul v-for="com in comments">
            <li id="comment14349589">
              <div class="author-meta" style="font-size:16px">
                <img
                    src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"
                    class="avatar" alt="">
                <span class="nickname">
                  <a href="#">{{ com.nickname }}</a></span>
                <span class="date">{{
                    com.createdDate.substring(0, 10) + " " + com.createdDate.substring(11, 16)
                  }}</span>
              </div>
              <p>{{ com.content }}</p>
              <div class="control post-meta">
                <span class="post-meta">
                  <a href="#" @click="updateComment();">수정</a>
                </span>
                <span class="post-meta">
                  <a href="#" @click="deleteComment();">삭제</a>
                </span>
              </div>
            </li>
          </ul>
        </div>

        <form method="post" style="margin: 0">

          <div class="comment-form">
            <div class="field">

              <input type="text" v-model="nickname" name="name" placeholder="이름">
              <input type="password" v-model="password" name="password" placeholder="암호" style="margin-left:5px">

              <!--              <div class="secret">-->
              <!--                <input type="checkbox" name="secret" id="secret">-->
              <!--                <label for="secret" tabindex="0">비밀댓글</label>-->
              <!--              </div>-->
            </div>
            <label for="comment" class="screen_out">댓글</label>
            <textarea id="comment" v-model="comment" name="comment" cols="" rows="4"
                      placeholder="작고 소중한 댓글을 입력해주세요."></textarea>
            <div class="d-flex justify-content-end" style="position: relative; float:left; margin-left:0">
              <b-button squared variant="outline-secondary" @click="moveToList()" style="font-size:12px">목록</b-button>
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

</style>