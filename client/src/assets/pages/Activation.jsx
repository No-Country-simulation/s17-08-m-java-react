import React, {useState} from "react";
import Logo from "../images/ArregloYa 3.png";
import instance from "../../api/axios";
import { useNavigate } from 'react-router-dom';

function Activation() {
    const [codeactivation, setCodeactivation] = useState();
    const navigate = useNavigate();

    const handleCode = (e) => {
        setCodeactivation(e.target.value);
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

       const response = await instance.post('/auth/validate-account', null, {
            params: {
                token: codeactivation
            }
        });

        if(response.status === 200) {
            navigate('/login');
        }
    }

    return (
        <div className="flex items-center justify-center h-screen">
            <img src={Logo} alt=""  className="size-80 mr-10"/>
            <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 max-w-xl">
                <h1 className="text-2xl font-bold">Activación de Cuenta</h1>
                <p className="mt-2">Para activar su cuenta por favor ingrese el código de activación que fue enviado a su correo</p>
                <form action="" className="mt-5" onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="code" className="block text-gray-700 text-sm font-bold mb-2">Código</label>
                        <input type="text" id="code" className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" onChange={handleCode}/>
                    </div>
                    <div className="flex items-center justify-between mb-5" >
                        <button className="btn w-64 h-10 bg-blue-500 text-white border-2 border-blue-500 text-ms font-medium rounded-md flex items-center justify-center hover:bg-blue-600 transition duration-300 ease-in-out" type="submit">
                           Activar cuenta
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Activation;