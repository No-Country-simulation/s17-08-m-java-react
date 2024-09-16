import axios from 'axios';

const instance = axios.create({
  baseURL: 'https://api.example.com', // Reemplaza con tu URL base
  timeout: 5000,
  headers: {'X-Custom-Header': 'foobar'}
});

export default instance;