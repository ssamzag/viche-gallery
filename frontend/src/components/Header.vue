<template>

  <div class="maru-font">
    <b-navbar toggleable="md"
              variant="white"
              dark="false"
              fixed="top"
              class="my-0"
              style="margin-left:12px">
      <b-navbar-brand href="/">
        <span style="font-size:25px">V I C H E</span>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="">
          <b-nav-item href="/work">W O R K S</b-nav-item>
          <b-nav-item href="/post">P O S T</b-nav-item>
          <b-nav-item href="/about">I N T R O D U C E</b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav class="ms-auto">
          <b-nav-item-dropdown text="d" right>
            <template #button-content>
              <font-awesome-icon icon="fa-solid fa-user"/>
            </template>
            <b-dropdown-item href="/work/write">글쓰기</b-dropdown-item>
            <b-dropdown-item href="#">LOGIN</b-dropdown-item>
            <b-dropdown-item href="#">WRITE</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script lang="ts" setup>

</script>

<style>
.maru-font {
  font-family: 'MaruBuri-Regular', sans-serif;
}
</style>
