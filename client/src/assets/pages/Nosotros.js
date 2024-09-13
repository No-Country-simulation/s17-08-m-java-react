import React from "react";
import NosotrosImg from "../images/Ilustraciones/nosotros.png";

function Nosotros() {
  return (
    <div className="container mx-auto py-16">
      <h1 className="text-left text-gray-800 text-3xl font-bold mb-8">
        Quiénes somos
      </h1>

      <div className="flex flex-wrap items-center">
        {/* Contenedor del texto */}
        <div className="w-full lg:w-1/2 lg:pl-8 text-left">
          <p>
            En ArregloYa, nuestro objetivo es conectar a los usuarios con
            profesionales de confianza para el mantenimiento del hogar,
            facilitando la búsqueda y contratación de servicios como plomería,
            electricidad, jardinería y reparaciones generales.
          </p>
          <br />
          <p>
            Además ofrecemos a los expertos un espacio para promocionar sus
            servicios, también para gestionar u organizar la disponibilidad
            horaria para contrataciones de manera rápida y directa, asegurando
            una experiencia eficiente y segura.
          </p>
        </div>

        {/* Contenedor de la imagen */}
        <div className="w-full lg:w-1/2 lg:pr-8">
          <div
            className="mx-3 lg:mx-0 wow fadeInRight animated"
            data-wow-delay="0.3s"
            style={{
              visibility: "visible",
              "-webkit-animation-delay": "0.3s",
              "-moz-animation-delay": "0.3s",
              animationDelay: "0.3s",
            }}
          >
            <img src={NosotrosImg} alt="Nosotros" className="w-full h-auto" />
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-8">
        <div className="p-4">
          <h2 className="text-2xl font-bold mb-4">Objetivo del sitio</h2>
          <p>
            Aquí colocarás una breve descripción del objetivo principal de tu
            sitio web. ¿Cuál es el problema que resuelves para tus usuarios?
          </p>
        </div>
        <div className="p-4">
          <h2 className="text-2xl font-bold mb-4">
            Pasos simples para contratar
          </h2>
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
