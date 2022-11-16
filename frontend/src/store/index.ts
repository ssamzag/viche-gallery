import { createStore } from 'vuex';

const store = createStore ({
    state: { // [변수들의 집합]
        accessToken: null
    },
    getters: { // [state의 변수들을 get 호출]
        accessToken(state) {
            return state.accessToken
        }
    },
    mutations: { // [변수들을 조작하는 함수들]

    },
    actions: { // [비동기 처리를 하는 함수들]
        // async [LOGIN]({ commit, dispatch }, loginInfo) {
        //     return AuthService.login(loginInfo).then((data) => {
        //         commit(SET_ACCESS_TOKEN, data.accessToken)
        //         localStorage.setItem('token', data.accessToken)
        //         dispatch(FETCH_MEMBER)
        //     })
        // }
        login: () => {
            alert("login")
        }
    },
});

export default store;