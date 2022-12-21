
<template>
  <div class="comments" ref="root">
    <h2>댓글<span class="count"><span>{{ commentCount }}</span></span></h2>
    <div class="comment-list">
      <ul v-for="com in comments">
        <Comment :com="com" @send="insertComment"></Comment>
        <!--            <li :id="'comment_' + com.id"-->
        <!--                class="comment">-->
        <!--              <div class="author-meta" style="font-size:18px">-->
        <!--                <img-->
        <!--                    src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"-->
        <!--                    class="avatar" alt="">-->
        <!--                <span class="nickname">-->
        <!--                  <a href="javascript:void(0)">{{ com.nickname }}</a></span>-->
        <!--                &lt;!&ndash;                <span class="date">&ndash;&gt;-->
        <!--                &lt;!&ndash;                  {{com.createdDate.substring(2, 10) + " " + com.createdDate.substring(11, 16)}}&ndash;&gt;-->
        <!--                &lt;!&ndash;                </span>&ndash;&gt;-->
        <!--              </div>-->

        <!--              <div class="comment-meta">-->
        <!--                <span class="date">-->
        <!--                  {{ com.createdDate }}-->
        <!--                </span>-->
        <!--                <span class="date" style="padding-left: 0px">-->
        <!--                  <a href="javascript:void(0)" @click="showReplyModal(com)">답글쓰기</a>-->
        <!--                </span>-->
        <!--              </div>-->
        <!--              <p>{{ com.content }}</p>-->
        <!--              <div class="control post-meta">-->
        <!--                <span class="post-meta">-->
        <!--                  <a href="javascript:void(0)" @click="showModifyComment(com);">수정</a>-->
        <!--                </span>-->
        <!--                <span class="post-meta">-->
        <!--                  <a href="javascript:void(0)" @click="showDeleteModal(com.id)">삭제</a>-->
        <!--                </span>-->
        <!--              </div>-->
        <!--            </li>-->
        <ul v-for="cc in com.child">
          <CommentRead :com="cc" @send="replyComment"></CommentRead>
          <!--              <li :id="'comment_' + cc.id"-->
          <!--                  v-for="cc in com.child"-->
          <!--                  style="padding-left:20px"-->
          <!--                  class="comment">-->
          <!--                <div class="author-meta" style="font-size:18px">-->
          <!--                  <img-->
          <!--                      src="https://img1.daumcdn.net/thumb/C100x100/?scode=mtistory2&amp;fname=https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fmanage%2Fimages%2Fr3%2Fdefault_S.png"-->
          <!--                      class="avatar" alt=""-->
          <!--                  >-->
          <!--                  <span class="nickname" style="padding-left:18px; padding-top:0px">-->
          <!--                  <a href="javascript:void(0)">{{ cc.nickname }}</a></span>-->
          <!--                  &lt;!&ndash;                <span class="date">&ndash;&gt;-->
          <!--                  &lt;!&ndash;                  {{com.createdDate.substring(2, 10) + " " + com.createdDate.substring(11, 16)}}&ndash;&gt;-->
          <!--                  &lt;!&ndash;                </span>&ndash;&gt;-->
          <!--                </div>-->
          <!--                <div class="comment-meta">-->
          <!--                  <span class="date">-->
          <!--                    {{ cc.createdDate.substring(0, 10) + " " + cc.createdDate.substring(11, 16) }}-->
          <!--                  </span>-->
          <!--                  <span class="date" style="padding-left: 0px">-->
          <!--                    <a href="javascript:void(0)" @click="showReplyModal(cc)">답글쓰기</a>-->
          <!--                  </span>-->
          <!--                </div>-->
          <!--                <p><span class="reply-to">{{ cc.replyToNick }}</span>{{ cc.content }}</p>-->

          <!--                <div class="control post-meta">-->
          <!--                <span class="post-meta">-->
          <!--                  <a href="javascript:void(0)" @click="showModifyComment(cc);">수정</a>-->
          <!--                </span>-->
          <!--                  <span class="post-meta">-->
          <!--                  <a href="javascript:void(0)" @click="showDeleteModal(cc.id)">삭제</a>-->
          <!--                </span>-->
          <!--                </div>-->
          <!--              </li>-->
        </ul>

      </ul>
    </div>
    <CommentWrite @send="insertComment"></CommentWrite>
    <!--        <form method="post" style="margin: 0">-->
    <!--          <div class="comment-form">-->
    <!--            <div class="field">-->
    <!--              <input type="text" v-model="nickname" name="name" placeholder="이름">-->
    <!--              <input type="password" v-model="password" name="password" placeholder="암호">-->

    <!--              &lt;!&ndash;              <div class="secret">&ndash;&gt;-->
    <!--              &lt;!&ndash;                <input type="checkbox" name="secret" id="secret">&ndash;&gt;-->
    <!--              &lt;!&ndash;                <label for="secret" tabindex="0">비밀댓글</label>&ndash;&gt;-->
    <!--              &lt;!&ndash;              </div>&ndash;&gt;-->
    <!--            </div>-->
    <!--            <label for="comment" class="screen_out">댓글</label>-->
    <!--            <textarea id="comment" v-model="comment" name="comment" cols="" rows="4"-->
    <!--                      placeholder="소중한 댓글을 입력해 주세요."></textarea>-->
    <!--            <div class="d-flex justify-content-end" style="position: relative; float:left; margin-left:0">-->
    <!--&lt;!&ndash;              <b-button squared variant="outline-secondary" @click="moveToList()" style="font-size:12px">목록</b-button>&ndash;&gt;-->
    <!--            </div>-->
    <!--            <div class="submit">-->
    <!--              <b-button squared variant="outline-secondary" @click="insertComment()" style="font-size:12px">댓글달기-->
    <!--              </b-button>-->
    <!--            </div>-->
    <!--          </div>-->
    <!--        </form>-->
  </div>
</template>
<script>
export default {
  name: "CommentComponent"
}
</script>

<style scoped>

</style>