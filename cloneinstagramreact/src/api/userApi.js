import axios from "axios";

export const signUp = (body) => {
    return axios.post('/api/create-user', body);
}

export const login = creds => {
    return axios.post('/api/auth', {}, {auth: creds});
}

export const changeLanguage = language => {
    axios.defaults.headers['accept-language'] = language;
}