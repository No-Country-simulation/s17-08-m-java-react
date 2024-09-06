import React from 'react';

function FilterComponent({ onFilterChange }) {
  return (
    <div className="bg-white p-4 shadow rounded mb-6">
      <div className="flex justify-between items-center">
        <select className="border p-2 rounded" onChange={(e) => onFilterChange('service', e.target.value)}>
          <option>Albañilería</option>
          <option>Plomería</option>
          <option>Electricidad</option>
        </select>
        <input type="text" placeholder="Ubicación" className="border p-2 rounded" onChange={(e) => onFilterChange('location', e.target.value)} />
        <label className="flex items-center space-x-2">
          <input type="checkbox" onChange={(e) => onFilterChange('availability', e.target.checked)} />
          <span>Disponibilidad ahora</span>
        </label>
        <button className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
          Aplicar filtros
        </button>
      </div>
    </div>
  );
}

export default FilterComponent;