<script setup>
import {useRouter} from "vue-router";
import {useStore} from "vuex";

document.addEventListener("click", () => {
  document.getElementById("nav-collapse").classList.remove("show")
})
let router = useRouter();
const store = useStore();

const logout = () => {
  localStorage.setItem("token", "");
  store.commit("logout")
}
</script>

<template>
  <b-navbar toggleable="md"
            variant="white"
            dark="false"
            fixed="top"
            class="maru-font my-0"
            style="margin-left:12px">
    <b-navbar-brand to="/">
      <span style="font-size:25px; letter-spacing: 6px">VICHE</span>
    </b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="" style="letter-spacing: 5px">
        <b-nav-item to="/work">WORKS</b-nav-item>
        <b-nav-item to="/post">POST</b-nav-item>
        <b-nav-item to="/about">INTRODUCE</b-nav-item>
      </b-navbar-nav>

      <b-navbar-nav class="ms-auto">
        <div v-if="!store.state.login">
          <b-nav-item to="/login">
            <font-awesome-icon icon="fa-solid fa-user"/>
          </b-nav-item>
        </div>
        <div v-else>
          <b-nav-item @click="logout">
            Logout
          </b-nav-item>
        </div>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  <b-container :toast="{root: true}" fluid="sm" position="position-fixed"></b-container>

</template>

<style>
.maru-font {
  font-family: 'MaruBuri-Regular', sans-serif;
}
</style>
