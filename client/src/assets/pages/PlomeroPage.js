import React from 'react';
import albañil1 from '../images/Personas perfiles/Albañil/Rectangle15.png'
import albañil2 from '../images/Personas perfiles/Albañil/Rectangle16.png'
import albañil3 from '../images/Personas perfiles/Albañil/Rectangle17.png'
import albañil4 from '../images/Personas perfiles/Albañil/Rectangle18.png'
import albañil5 from '../images/Personas perfiles/Albañil/Rectangle19.png'
import albañil6 from '../images/Personas perfiles/Albañil/Rectangle20.png'
import { Link } from 'react-router-dom';

function WorkerCard({ name, reviews, contact, image }) {
  return (
    <div className="max-w-sm rounded overflow-hidden shadow-lg text-center bg-white m-4">
      <img className="w-full h-48 object-cover" src={image} alt={`Foto de ${name}`} />
      <div className="px-6 py-4">
        <div className="font-bold text-xl mb-2">{name}</div>
        <p className="text-gray-700 text-base">
          Reviews: {reviews}
        </p>
        <p className="text-gray-700 text-base">
          Contacto: {contact}
        </p>
      </div>
      <div className="px-6 pt-4 pb-2">
        <Link to="/formulario-albanil" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          Solicitar presupuesto
        </Link>
      </div>
    </div>
  );
}

// Componente WorkersGrid que también incluye el título y la configuración del fondo
function WorkersGrid() {
  const workers = [
    { id: 1, name: 'Juan Pérez', reviews: '★★★★☆', contact: '+54 351 123 123', image: albañil1 },
    { id: 2, name: 'Carlos Mendoza', reviews: '★★★☆☆', contact: '+54 351 123 123', image: albañil2 },
    { id: 3, name: 'Luis Rodríguez', reviews: '★★★★★', contact: '+54 351 123 123', image: albañil3 },
    { id: 4, name: 'Miguel Torres', reviews: '★★☆☆☆', contact: '+54 351 123 123', image: albañil4 },
    { id: 5, name: 'Pedro García', reviews: '★★★☆☆', contact: '+54 351 123 123', image: albañil5 },
    { id: 6, name: 'Alejandro López', reviews: '★★★★★', contact: '+54 351 123 123', image: albañil6 },
    // Añade más trabajadores según sea necesario
  ];

  return (
    <div className="bg-gray-100 min-h-screen pt-10">
      <h1 className="text-center text-4xl font-bold mb-10">Tu Albañil de Confianza, a un Click</h1>
      <div className="flex flex-wrap justify-center">
        {workers.map(worker => (
          <WorkerCard key={worker.id} name={worker.name} reviews={worker.reviews} contact={worker.contact} image={worker.image} />
        ))}
      </div>
    </div>
  );
}

export default WorkersGrid; // Exporta WorkersGrid en lugar de PlomeroPage