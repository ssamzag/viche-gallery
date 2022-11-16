<script setup type="ts">
import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";
import { useStore, mapActions, mapGetters, mapMutations } from 'vuex'

const userid = ref("")
const password = ref("")
const router = useRouter();
const store = useStore();

const login = () => {
  axios.post("/api/auth/login/token",
      {userid: userid.value, password: password.value})
      .then((req) => {
        if (req.status === 200) {
          const token =  req.data.accessToken
          localStorage.setItem('token', token)
          store.state.accessToken = token
          router.replace("/")
        }
      })
      .catch(error => alert("아이디 암호 확인"))
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
          <b-form-input type="password" v-model="password" placeholder="Enter your password"></b-form-input>
        </div>
        <div class="my-1">
          <b-button @click="login">LOGIN</b-button>
        </div>
      </div>
    </b-row>
  </b-col>

</template>