import React from 'react';

function Nosotros() {
  return (
    <div className="container mx-auto py-16">
      <h1 className="text-3xl font-bold text-center mb-8">Quiénes somos</h1>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div className="p-4">
          <h2 className="text-2xl font-bold mb-4">Objetivo del sitio</h2>
          <p>Aquí colocarás una breve descripción del objetivo principal de tu sitio web. ¿Cuál es el problema que resuelves para tus usuarios?</p>
        </div>
        <div className="p-4">
          <h2 className="text-2xl font-bold mb-4">Pasos simples para contratar</h2>
          <ol className="list-decimal">
            <li>Paso 1: Busca al profesional que necesitas.</li>
            <li>Paso 2: Contacta al profesional directamente.</li>
            <li>Paso 3: ¡Listo! Tu problema está resuelto.</li>
          </ol>
        </div>
      </div>

      {/* ... (resto de las secciones) */}
    </div>
  );
}

export default Nosotros;