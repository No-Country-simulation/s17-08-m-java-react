import React from 'react';

function Subscribe() {
  return (
    <section id="Subscribes" className="text-center py-20 bg-blue-100">
      <div className="container">
        <div className="flex justify-center mx-3">
          <div className="w-full sm:w-3/4 md:w-2/3 lg:w-1/2">
            <h4 className="mb-3 section-heading wow fadeInUp animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>¿No Encuentras el Servicio que Necesitas?</h4>
            <p className="mb-4 text-gray-600 leading-loose text-sm wow fadeInUp animated" data-wow-delay="0.6s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.6s', '-moz-animation-delay': '0.6s', animationDelay: '0.6s' }}>Si no encuentras exactamente lo que buscas, no te preocupes. Escríbenos y te ayudaremos a conectar con el profesional adecuado para tu necesidad.<br className="hidden lg:block" />¡Estamos aquí para ayudarte a encontrar la solución perfecta para tu hogar!</p>
            <form>
              <div className="wow fadeInDown animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
                <button className="border-0 bg-blue-600 text-white rounded-full w-40 h-12 duration-300 hover:opacity-75" type="submit"><i className="lni lni-arrow-right">Contáctanos</i></button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Subscribe;