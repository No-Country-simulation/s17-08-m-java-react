import React from 'react';

function Pricing() {
  return (
    <section id="pricing" className="py-24">
      <div className="container ">
        <div className="flex flex-wrap justify-center  md:justify-start">
          {/* Single pricing table starts */}
          <h2 className="mb-12 section-heading wow fadeInDown animated " data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>Opiniones de Nuestros Clientes sobre ArregloYa</h2>
          <div className="w-3/4 sm:w-2/3 md:w-1/2 lg:w-1/3">
            <div className="pricing-box wow fadeInLeft animated" data-wow-delay="1.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '1.2s', '-moz-animation-delay': '1.2s', animationDelay: '1.2s' }}>
              <div className="mb-3 ">
                <h3 className="text-2xl font-bold text-gray-700">María Sanchez</h3>
              </div>
              <div className="mb-5">
                <p className="text-gray-700">
                  <span className="font-bold text-2xl">⭐⭐⭐⭐⭐ 5/5</span>
                </p>
                <p>
                  <span className="font-medium text-sm">hace 2 días</span>
                </p>
              </div>
              <ul className="mb-16">
                <li className="text-gray-800 leading-9">Juan hizo una excelente reparación de plomería en mi cocina. Puntual y profesional, solucionó el problema rápidamente. Muy recomendable.</li>
              </ul>
            </div>
          </div>
          <div className="w-3/4 sm:w-2/3 md:w-1/2 lg:w-1/3">
            <div className="pricing-box wow fadeInLeft animated" data-wow-delay="1.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '1.2s', '-moz-animation-delay': '1.2s', animationDelay: '1.2s' }}>
              <div className="mb-3">
                <h3 className="text-2xl font-bold text-gray-700">Andrés Martínez</h3>
              </div>
              <div className="mb-5">
                <p className="text-gray-700">
                  <span className="font-bold text-2xl">⭐⭐⭐⭐⭐ 5/5</span>
                </p>
                <p>
                  <span className="font-medium text-sm">hace 10 días</span>
                </p>
              </div>
              <ul className="mb-16">
                <li className="text-gray-800 leading-9">Martín instaló un sistema de riego en mi jardín de manera impecable. Profesional y confiable, el jardín está perfecto. Muy satisfecha.</li>
              </ul>
            </div>
          </div>
          <div className="w-3/4 sm:w-2/3 md:w-1/2 lg:w-1/3">
            <div className="pricing-box wow fadeInLeft animated" data-wow-delay="1.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '1.2s', '-moz-animation-delay': '1.2s', animationDelay: '1.2s' }}>
              <div className="mb-3">
                <h3 className="text-2xl font-bold text-gray-700">Pedro Lopez</h3>
              </div>
              <div className="mb-5">
                <p className="text-gray-700">
                  <span className="font-bold text-2xl">⭐⭐⭐⭐⭐ 5/5</span>
                </p>
                <p>
                  <span className="font-medium text-sm">hace 7 días</span>
                </p>
              </div>
              <ul className="mb-16">
                <li className="text-gray-800 leading-9">Jose transformó mi baño con su trabajo de albañilería y pintura. Detallista y eficiente, el resultado fue increíble. Excelente servicio</li>
              </ul>
            </div>
          </div>
          {/* Single pricing table ends */}
        </div>
      </div>
    </section>
  );
}

export default Pricing;