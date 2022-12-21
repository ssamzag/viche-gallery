<template>
  <div v-if="modelValue" class="modelPopup">
    <div class="comment-item">
      <div class="post-meta" style="padding-bottom: 10px">
        {{message}}<br>
      </div>
      <div class="comments">
        <div class="comment-form">
          <input type="password"
                 ref="commentPasswordInput"
                 @keyup.enter="deleteComment"
                 v-model="password"
                 name="password"
                 placeholder="암호"
                 style="margin-left:5px">
        </div>
      </div>
      <div class="post-meta">
          <span>
            <a href="#" @click.prevent="confirm">{{confirmButtonName}}</a>
          </span>
        <span>
            <a href="#" @click.prevent="$emit('update:modelValue', false)">취소</a>
          </span>
      </div>
    </div>
  </div>
</template>

<script setup type="ts">
import {ref} from "vue";

const emit = defineEmits(["close", "deleteComment", "update:modalValue"])
defineProps({
  modelValue: Boolean,
  message: {
    type: String,
    required: true
  },
  show: {
    type: Boolean,
    default: false
  },
  confirmButtonName: {
    type: String,
    default: "확인",
    required: false
  }

})

const password = ref("")

const confirm = () => {
  emit("confirm", password.value)
}

</script>

<style scoped>

</style>