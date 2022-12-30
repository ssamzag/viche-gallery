<script setup type="ts">
import {inject, ref} from "vue";
import {useRouter} from "vue-router";
import {useStore, mapActions, mapGetters, mapMutations} from 'vuex'
import AuthService from "@/api/modules/auth";
import {useUserStore} from "@/stores/user";
import {useAlertStore} from "@/stores/alert";

const userid = ref("")
const password = ref("")
const router = useRouter();
const store = useStore();
const userStore = useUserStore()
const {vAlert, vSuccess} = useAlertStore()

const login = async () => {
  try {
    await userStore.login(
        {
          userid: userid.value,
          password: password.value
        }
    )
    vSuccess("로그인 성공")
    await router.replace(sessionStorage.getItem("currentUrl"))

  } catch (e) {
    vAlert("로그인 실패")
  }
  //
  // AuthService.login({
  //   userid: userid.value,
  //   password: password.value
  // })
  //     .then((req) => {
  //       localStorage.setItem('token', req.data.accessToken)
  //       store.commit("login")
  //
  //     })
  //     .catch((error) => {
  //
  //     })
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
          <b-form-input type="password" v-model="password" v-on:keyup.enter="login"
                        placeholder="Enter your password"></b-form-input>
        </div>
        <div class="my-1">
          <b-button @click="login">LOGIN</b-button>
        </div>
      </div>
    </b-row>
  </b-col>

</template>