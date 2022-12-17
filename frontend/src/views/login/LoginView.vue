<script setup type="ts">
import {inject, ref} from "vue";
import {useRouter} from "vue-router";
import {useStore, mapActions, mapGetters, mapMutations} from 'vuex'
import AuthService from "@/api/modules/auth";

const userid = ref("")
const password = ref("")
const router = useRouter();
const store = useStore();

const login = () => {
  AuthService.login({
    userid: userid.value,
    password: password.value
  })
      .then((req) => {
        localStorage.setItem('token', req.data.accessToken)
        store.commit("login")
        router.replace(sessionStorage.getItem("currentUrl"))
      })
      .catch((error) => {
        alert("로그인 실패")
      })
}

</script>

<template>
  <b-col>
    <b-row>
      <div class=" p-4" style="width:300px; margin: 0 auto;">
        <div>
          <b-form-input
              id="input-live"
              v-model="userid"
              placeholder="Enter your id">
          </b-form-input>
        </div>

        <div class="my-1">
          <b-form-input type="password" v-model="password" v-on:keyup.enter="login" placeholder="Enter your password"></b-form-input>
        </div>
        <div class="my-1">
          <b-button @click="login">LOGIN</b-button>
        </div>
      </div>
    </b-row>
  </b-col>

</template>