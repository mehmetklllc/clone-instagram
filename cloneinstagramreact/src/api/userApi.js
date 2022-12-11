import axios from "axios";

export const signUp = (body) => {
    return axios.post('/api/create-user', body);
}