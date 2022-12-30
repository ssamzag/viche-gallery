import BaseCommentDetail from "@/components/comment/BaseCommentForm.vue"
import BaseCommentWrite from "@/components/comment/BaseCommentWriteForm.vue"
import BaseTitle from "@/components/TitleComponent.vue"
import BaseModal from "@/components/BaseModal.vue"

export default {
    install(app: any) {
        app.component('BaseCommentDetail', BaseCommentDetail)
        app.component('BaseCommentWrite', BaseCommentWrite)
        app.component('BaseTitle', BaseTitle)
        app.component('BaseModal', BaseModal)
    },
}