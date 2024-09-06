import React, { useState } from 'react';

function FormularioAlbañil() {
    const [reservationDate, setReservationDate] = useState('');
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Reservando para:', reservationDate);
        // Aquí agregarías la lógica para guardar o enviar la información
    }

    return (
        <div className="container mx-auto px-4">
            <div className="flex flex-col md:flex-row">
                <div className="md:w-1/2 p-4">
                    <h2 className="text-xl font-bold mb-4">Conoce a tu Albañil y Solicita tu Servicio</h2>
                    <div className="bg-white shadow-md rounded-lg p-4">
                        <h3 className="text-lg font-semibold">Alejandro Lopez</h3>
                        <p>Reviews</p>
                        <p>Matriculaciones</p>
                        <p>Contacto: +54 351 123 123</p>
                    </div>
                    <div className="mt-4 bg-white shadow-md rounded-lg p-4">
                        <h4 className="text-md font-bold">Días disponibles</h4>
                        <p>Martes 5 sep, Miércoles 6 sep, ...</p>
                        <p>Horarios disponibles: 8:00 am - 9:00am, 12:00 pm, 17:00 pm</p>
                    </div>
                </div>
                <div className="md:w-1/2 p-4">
                    <form className="bg-white shadow-md rounded-lg p-4" onSubmit={handleSubmit}>
                        <label className="block">
                            <span className="text-gray-700">Categoría</span>
                            <input type="text" className="mt-1 block w-full" placeholder="Ingresa la categoría"/>
                        </label>
                        <label className="block mt-3">
                            <span className="text-gray-700">Título</span>
                            <input type="text" className="mt-1 block w-full" placeholder="Título del servicio"/>
                        </label>
                        <label className="block mt-3">
                            <span className="text-gray-700">Descripción del servicio</span>
                            <textarea className="mt-1 block w-full" rows="3" placeholder="Descripción detallada del servicio"></textarea>
                        </label>
                        <label className="block mt-3">
                            <span className="text-gray-700">Ubicación</span>
                            <input type="text" className="mt-1 block w-full" placeholder="Ubicación del servicio"/>
                        </label>
                        <div className="mt-4">
                            <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                                Reserva una visita para el día 5 de sep
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default FormularioAlbañil;
