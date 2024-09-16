import React, {useState} from 'react';
import facebook from '../images/facebook2.svg'
import google from '../images/google2.svg'
import Logo from '../images/ArregloYa 3.png'
import instance from '../../api/axios';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const navigate = useNavigate();

    const handleUsername = (e) => {
        setUsername(e.target.value);
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        const { data } = await instance.post('/auth/log-in', {
            username: username,
            password: password
        });
        if (data.token) {
            navigate('/');
        }
    }

    return (    
        
        <div className="flex items-center justify-center">            
            <div className="w-full max-w-xs ">
            <img src={Logo} alt=""  className="  px-24 "/>
                <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="email">
                            E-mail
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="email" type="email" placeholder="Email" onChange={handleUsername}/>
                    </div>
                    <div className="mb-6">
                        <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="password">
                            Contraseña
                        </label>
                        <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline" id="password" type="password" placeholder="********" onChange={handlePassword}/>
                        <p className="text-gray-600 text-xs italic">Mínimo 8 caracteres.</p>
                    </div>
                    <div className="mb-6">
                        <input type="checkbox" id="terms" className="mr-2 leading-tight"/>
                        <label htmlFor="terms" className="text-sm text-gray-700">
                            He leído y acepto los términos y condiciones de uso.
                        </label>
                    </div>
                    <div className="flex items-center justify-between mb-5" >
                        <button className="btn w-64 h-10 bg-blue-500 text-white border-2 border-blue-500 text-ms font-medium rounded-md flex items-center justify-center hover:bg-blue-600 transition duration-300 ease-in-out" type="submit">
                            Iniciar sesión
                        </button>
                    </div>
                    <div>
                        <p className="inline-block align-baseline  text-sm text-gray-700 " href="/register">
                            ¿Aún no tienes cuenta? 
                        </p>
                        <a className="inline-block align-baseline  font-bold text-sm text-blue-700 hover:text-blue-500" href="/register">
                             Regístrate
                        </a>
                    </div>
                    <div className="mt-4 flex justify-center gap-4">
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full inline-flex items-center">
                            <img src={google} alt="Google" className="fill-current w-4 h-4 mr-0"/>
                        </button>
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full inline-flex items-center w-12 h-12">
    <img src={facebook} alt="Facebook" className="w-6 h-6"/>
</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Login;
