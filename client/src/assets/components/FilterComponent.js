import React from "react";

function FilterComponent({ onFilterChange }) {
  return (
    <div className="bg-gray-100 p-4 shadow-lg rounded mb-10 max-w-[1200px] mx-auto">
      <div className="flex justify-between items-center">
        <select
          className="text-gray-600 border focus:border-gray-500 p-2 rounded w-64 "
          onChange={(e) => onFilterChange("service", e.target.value)}
        >
          <option>Albañilería</option>
          <option>Plomería</option>
          <option>Electricidad</option>
          <option>Arquitecto</option>
          <option>Mecánico</option>
          <option>Carpintero</option>
          <option>Gasista</option>
          <option>Herrero</option>
          <option>Jardinero</option>
          <option>Limpieza</option>
          <option>Mudanza</option>
          <option>Pintores</option>
          <option>Cerrajero</option>
        </select>
        <input
          type="text"
          placeholder="Ubicación"
          className=" text-gray-600 border focus:border-gray-500 p-2 rounded w-64 " // Agrega la clase text-gray-500 aquí
          onChange={(e) => onFilterChange("location", e.target.value)}
        />
        <label className="flex items-center space-x-2">
          <input
            type="checkbox"
            onChange={(e) => onFilterChange("availability", e.target.checked)}
          />
          <span>Disponibilidad ahora</span>
        </label>
        <button className="btn w-48 h-12 bg-white border-2 rounded-md">
          Aplicar filtros
        </button>
      </div>
    </div>
  );
}

export default FilterComponent;