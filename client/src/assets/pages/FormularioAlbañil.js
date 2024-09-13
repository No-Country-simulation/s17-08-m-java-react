import React, { useState } from 'react';
import albañil from '../images/Personas perfiles/Albañil/Rectangle16.png'


function FormularioAlbañil() {
    const [reservationDate, setReservationDate] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Reservando para:', reservationDate);
        // Aquí agregarías la lógica para guardar o enviar la información
    }

    return (
        <div className="container mx-auto px-4">
            <h2 className="text-3xl font-bold mb-4 text-left text-gray-800">Conoce a tu Albañil y Solicita tu Servicio</h2>
            <div className="flex flex-col md:flex-row justify-center items-start md:items-center">
            <div className="md:w-1/3 p-4 bg-white shadow-lg rounded-lg">
  <h3 className="text-2xl font-semibold text-gray-800">Alejandro Lopez</h3>
  <p className="my-1">Reviews</p>
  <p className="my-1">Contacto: +54 351 123 123</p>
  <img src={albañil} alt="Albañil" className="w-full h-auto object-cover my-4 rounded-lg"/>
</div>
                <div className="md:w-2/3 p-4">
                <form className="bg-white shadow-md rounded-lg p-4" onSubmit={handleSubmit}>
    <div className="mb-4">
        <label className="block text-gray-900">Categoría</label>
        <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Ingresa la categoría"/>
    </div>
    <div className="mb-4">
        <label className="block text-gray-900">Título</label>
        <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Título del servicio"/>
    </div>
    <div className="mb-4">
        <label className="block text-gray-900">Descripción del servicio</label>
        <textarea className="mt-1 block w-full border rounded py-2 px-3" rows="3" placeholder="Descripción detallada del servicio"></textarea>
    </div>
    <div className="mb-4">
        <label className="block text-gray-900">Ubicación</label>
        <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Ubicación del servicio"/>
    </div>
    <div className="mb-4">
        <label className="block text-gray-700">Día y hora deseada</label>
        <input type="datetime-local" className="mt-1 block w-full border rounded py-2 px-3" onChange={(e) => setReservationDate(e.target.value)} />
    </div>
    <div className="flex justify-center">
        <button type="submit" className="border-0 bg-blue-600 text-white rounded-full w-72 h-12 duration-300 hover:opacity-75">
            Reserva una visita
        </button>
    </div>
</form>
                </div>
            </div>
        </div>
    );
}

export default FormularioAlbañil;
