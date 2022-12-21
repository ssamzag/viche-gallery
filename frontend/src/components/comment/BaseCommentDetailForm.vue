<script setup type="ts">
import {useRouter} from "vue-router";
import {defineEmits, onMounted, ref} from "vue";

const router = useRouter()
const emit = defineEmits(["showReplyModal"]);

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
const comment = ref("")

const showDeleteModal = (commentId) => {
  emit("showDeleteModal", commentId)
}

const showModifyComment = (comment) => {
  emit("showModifyComment", comment)
}

const showReplyModal = (comment) => {
  emit("showReplyModal", comment)
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
                  <a href="#" @click.prevent="showReplyModal(props.com)">답글쓰기</a>
                </span>
    </div>
    <p><span v-if="props.com.replyToNick" class="reply-to">{{ props.com.replyToNick }}</span> {{ props.com.content }}
    </p>
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

<style>
.reply-to {
  font-weight: 700;
  padding-right: 4px;
  color: #2761c2
}
</style>