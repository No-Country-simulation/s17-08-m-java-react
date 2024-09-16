import React from "react";
import Logo from "../images/ArregloYa 3.png";

function Activation() {
    return (
        <div className="flex items-center justify-center h-screen">
            <img src={Logo} alt=""  className="size-80 mr-10"/>
            <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 max-w-xl">
                <h1 className="text-2xl font-bold">Activación de Cuenta</h1>
                <p className="mt-2">Para activar su cuenta por favor ingrese el código de activación que fue enviado a su correo</p>
                <form action="" className="mt-5">
                    <div>
                        <label htmlFor="code" className="block text-gray-700 text-sm font-bold mb-2">Código</label>
                        <input type="text" id="code" className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"/>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Activation;