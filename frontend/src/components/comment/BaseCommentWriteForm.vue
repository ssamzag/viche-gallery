<script setup type="ts">
import {defineEmits} from "vue";
import {ref} from "vue";

const emit = defineEmits(["toggle-drawer", "update:content", "update:password", "update:nickname"]);

const props = defineProps({
  content: String,
  password: String,
  nickname: String,
  com: {
    type: Object,
    require: true
  },
  send: {
    type: Function,
    require: false
  },
  isShow: {
    type: Boolean,
    required: false,
    default() {
      return true
    }
  },
  buttonName: {
    type: [String],
    required: false,
    default() {
      return "댓글달기"
    }
  },
  showCancelButton: {
    type: [Boolean, String],
    required: false,
    default() {
      return false
    }
  },
  showNicknameInput: {
    type: [Boolean, String],
    required: false,
    default() {
      return false
    }
  }
})

const isShow = ref(props.isShow)

const send = () => {
  emit("send")
}
const hideCommentWrite = () => {
  emit("hideCommentWrite")
}
</script>

<template>
  <form method="post" style="margin: 0" v-if="isShow">
    <div class="comment-form">
      <div class="field">
        <input v-if="showNicknameInput"
               type="text"
               :value="nickname"
               @input="$emit('update:nickname', $event.target.value)"
               name="name"
               placeholder="이름">
        <input class="mx-1"
               type="password"
               :value="password"
               @input="$emit('update:password', $event.target.value)"
               name="password"
               autocomplete="on"
               placeholder="암호">

        <!--        <div class="secret">-->
        <!--          <input type="checkbox" name="secret" id="secret">-->
        <!--          <label for="secret" tabindex="0">비밀댓글</label>-->
        <!--        </div>-->
      </div>
      <label for="comment" class="screen_out">댓글</label>
      <textarea id="comment"
                :value="content"
                @input="$emit('update:content', $event.target.value)"
                name="comment" cols="" rows="4"
                placeholder="소중한 댓글을 입력해주세요."></textarea>
      <div class="d-flex justify-content-end" style="position: relative; float:left; margin-left:0">
        <!--              <b-button squared variant="outline-secondary" @click="moveToList()" style="font-size:12px">목록</b-button>-->
      </div>
      <div class="submit">
        <b-button v-if="showCancelButton"
                  squared variant="outline-secondary"
                  @click="hideCommentWrite"
                  style="font-size:12px;"
        >
          취소
        </b-button>
        <b-button squared variant="outline-secondary"
                  @click="send"
                  style="font-size:12px"
        >
          {{ buttonName }}
        </b-button>
        <!--        <b-button squared variant="outline-secondary" @click="props.send" style="font-size:12px">댓글달기</b-button>-->
      </div>
    </div>
  </form>
</template>

<style>
::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
  color: gray;
  opacity: 0.4; /* Firefox */
}
</style>