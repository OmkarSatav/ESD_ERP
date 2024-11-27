import axios from "axios";

// Create Axios instance
const axiosInstance = axios.create({
    baseURL: process.env.REACT_APP_API_BASE_URL || "http://localhost:9090",
    headers: {
        "Content-Type": "application/json",
    },
});


axiosInstance.interceptors.request.use(
    (config) => {
      if (config.requiresAuth) {
        const token = localStorage.getItem("token"); 
        if (token) {
          config.headers["Authorization"] = `Bearer ${token}`;
        } else {
          console.warn("No token found for authenticated request.");
        }
      }
      return config;
    },
    (error) => {
      if (error.response && error.response.status === 401) {
        window.location.href = "/";
      }
      return Promise.reject(error);
    }
);

export default axiosInstance;

