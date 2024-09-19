import React from "react";
import Services from "../components/Service";

function Servicios() {
    return (
        <div className="container mx-auto py-16 space-y-10">
            <h1 className="text-center text-gray-800 text-3xl font-bold mb-2">
                ¿Qué servicios se ofrecen?
            </h1>

            <div className="flex flex-wrap items-center justify-center">
                {/* Contenedor del texto */}
                <div className="w-full lg:w-1/2 lg:pl-2 text-left">
                    <p>
                        En ArregloYa, puedes encontrar una amplia gama de profesionales en
                        diferentes campos y especialidades.
                    </p>
                    <br />
                    <p>
                        Podés encontrar profesionales para soluciones de albañileria,
                        plomería, carpintería 
                    </p>
                    <br />
                    <p className="font-bold text-center">¡Y muchos más!</p>
                </div>


            </div>
            <Services />
        </div>
    );
}

export default Servicios;