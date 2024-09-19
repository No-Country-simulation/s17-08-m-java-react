import React, { useState } from 'react';
import albañil from '../images/Personas perfiles/Albañil/Rectangle16.png';
import resena from '../images/Personas perfiles/Albañil/resena.jpg';

function FormularioAlbañil() {
    const [reservationDate, setReservationDate] = useState('');
    const [showThankYou, setShowThankYou] = useState(false); 

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Reservando para:', reservationDate);
        setShowThankYou(true); 

        
        window.scrollTo(0, 0);  
    }

    const closeThankYouMessage = () => {
        setShowThankYou(false); 
    }

    return (
        <div className="container mx-auto px-4">
            <h2 className="text-3xl font-bold mt-10 text-left text-gray-800">Conoce a tu Albañil y Solicita tu Servicio</h2>
            <div className="flex flex-col md:flex-row justify-center items-start md:items-center">
                <div className="md:w-1/3 p-4 bg-white shadow-lg rounded-lg">
                    <h3 className="text-2xl font-semibold text-gray-800">Alejandro Lopez</h3>
                    <p className="my-1">Reviews</p>
                    <p className="my-1">Contacto: +54 351 123 123</p>
                    <img src={albañil} alt="Albañil" className="w-full h-auto object-cover my-4 rounded-lg" />
                </div>
                <div className="md:w-2/3 p-4">
                    <form className="bg-white shadow-md rounded-lg p-4" onSubmit={handleSubmit}>
                        <div className="mb-4">
                            <label className="block text-gray-900">Categoría</label>
                            <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Ingresa la categoría" />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-900">Título</label>
                            <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Título del servicio" />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-900">Descripción del servicio</label>
                            <textarea className="mt-1 block w-full border rounded py-2 px-3" rows="3" placeholder="Descripción detallada del servicio"></textarea>
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-900">Ubicación</label>
                            <input type="text" className="mt-1 block w-full border rounded py-2 px-3" placeholder="Ubicación del servicio" />
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
            <img src={resena} alt="resena" className="mx-auto mt-24" />

            {showThankYou && (
                <div className="fixed inset-0 bg-gray-800 bg-opacity-50 flex justify-center items-center">
                    <div className="bg-white rounded-lg p-8 shadow-lg text-center">
                        <h2 className="text-2xl font-bold text-gray-800 mb-4">¡Gracias por realizar la reserva!</h2>
                        <p className="text-gray-600">El profesional se pondrá en contacto contigo para confirmar los detalles.</p>
                        <button 
                            className="mt-6 bg-blue-600 text-white rounded-full px-6 py-2 hover:opacity-75"
                            onClick={closeThankYouMessage}>
                            Cerrar
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
}

export default FormularioAlbañil;
