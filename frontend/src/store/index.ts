import { createStore } from 'vuex';

const store = createStore ({
    state: {
        accessToken: null,
        login: !!localStorage.getItem('token')
    },
    getters: {
        accessToken(state) {
            return state.accessToken
        }
    },
    mutations: {
        login(state) {
            state.login = true
        },
        logout(state) {
            state.login = false
        }
    },
    actions: { // [비동기 처리를 하는 함수들]
        // async [LOGIN]({ commit, dispatch }, loginInfo) {
        //     return AuthService.login(loginInfo).then((data) => {
        //         commit(SET_ACCESS_TOKEN, data.accessToken)
        //         localStorage.setItem('token', data.accessToken)
        //         dispatch(FETCH_MEMBER)
        //     })
        // }

    },
});

export default store;