import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/api/v1', // Reemplaza con tu URL base
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json'
  }
});

export default instance;