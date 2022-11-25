import axios from "axios";

axios.interceptors.request.use(
    config => config,
    error => Promise.reject(error)
)

axios.interceptors.response.use(
    response => response,
    async error => {
        if (error.response.status === 401) {
            localStorage.setItem("token", "")
            window.location.href="/login"
            return
        }
        return await Promise.reject(error);
    });

export default axios;