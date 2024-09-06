import React, { useState } from 'react';
import FilterComponent from '../components/FilterComponent'; // Asegúrate de que la ruta es correcta
import WorkersGrid from '../components/WorkersGrid';
import albañil1 from '../images/Personas perfiles/Albañil/Rectangle15.png';
import albañil2 from '../images/Personas perfiles/Albañil/Rectangle16.png';
import albañil3 from '../images/Personas perfiles/Albañil/Rectangle17.png';
import albañil4 from '../images/Personas perfiles/Albañil/Rectangle18.png';
import albañil5 from '../images/Personas perfiles/Albañil/Rectangle19.png';
import albañil6 from '../images/Personas perfiles/Albañil/Rectangle20.png';

// Datos iniciales de ejemplo
const initialWorkers = [
  { id: 1, name: 'Juan Pérez', reviews: '★★★★☆', contact: '+54 351 123 123', image: albañil1 },
  { id: 2, name: 'Carlos Mendoza', reviews: '★★★☆☆', contact: '+54 351 123 123', image: albañil2 },
  { id: 3, name: 'Luis Rodríguez', reviews: '★★★★★', contact: '+54 351 123 123', image: albañil3 },
  { id: 4, name: 'Miguel Torres', reviews: '★★☆☆☆', contact: '+54 351 123 123', image: albañil4 },
  { id: 5, name: 'Pedro García', reviews: '★★★☆☆', contact: '+54 351 123 123', image: albañil5 },
  { id: 6, name: 'Alejandro López', reviews: '★★★★★', contact: '+54 351 123 123', image: albañil6 },
    // Añade más trabajadores según sea necesario
];

function PlomeroPage() {
  const [workers] = useState(initialWorkers);
  const [setFilters] = useState({ service: '', location: '', availability: false });

  const handleFilterChange = (filterName, value) => {
    setFilters(prev => ({ ...prev, [filterName]: value }));
    // Aquí agregar lógica para filtrar trabajadores basada en `filters`
  };

  return (
    <div className="bg-gray-100 min-h-screen pt-10">
      <FilterComponent onFilterChange={handleFilterChange} />
      <WorkersGrid workers={workers} />
    </div>
  );
}

export default PlomeroPage;