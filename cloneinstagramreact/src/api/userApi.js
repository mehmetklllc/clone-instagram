import axios from "axios";

export const signUp = (body) => {
    return axios.post('/api/create-user', body);
}

export const changeLanguage = language => {
    axios.defaults.headers['accept-language'] = language;
}