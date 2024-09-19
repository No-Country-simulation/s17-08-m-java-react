import axios from 'axios';

const instance = axios.create({
  baseURL: 'https://s17-08-m-java-react.onrender.com/api/v1', // Reemplaza con tu URL base
  // timeout: 5000,
  headers: {
    'Content-Type': 'application/json'
  }
});

export default instance;