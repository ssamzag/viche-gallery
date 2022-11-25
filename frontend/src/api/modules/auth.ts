import ApiService from "@/api"

const AuthService = {
    login(userInfo: object) {
        return ApiService.post("/api/auth/login/token", userInfo)
    }
}

export default AuthService
