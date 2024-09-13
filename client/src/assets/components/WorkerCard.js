import React from 'react';
import { Link } from 'react-router-dom';

function WorkerCard({ worker }) {
  return (
     <div className="max-w-sm w-full lg:w-1/4 rounded overflow-hidden shadow-lg bg-white m-4 ">
      <img className="w-full h-48 object-cover " src={worker.image} alt={`Foto de ${worker.name}`} />
      <div className="px-6 py-6">
        <div className="text-gray-800 font-bold text-xl mb-2">{worker.name}</div>
        <p className="text-gray-700 text-base">
          Reviews: {worker.reviews}
        </p>
        {/* <p className="text-gray-700 text-base">
          Matriculaciones: {worker.matriculaciones}
        </p> */}
        <p className="text-gray-700 text-base">
          Contacto: {worker.contacto}
        </p>
      </div>
      <div className="px-6 pt-4 pb-6  text-center">
        <Link to="/formulario-albanil" className="bg-blue-500 hover:bg-blue-700 text-white  py-2 px-4 rounded-2xl  ">
          Solicitar presupuesto
        </Link>
      </div>
    </div>
  );
}

export default WorkerCard;
