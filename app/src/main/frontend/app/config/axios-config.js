import axios from 'axios';

export default function configureAxios() {
  axios.defaults.baseURL = 'http://localhost:8080';
  console.log(axios.defaults.baseURL);
}