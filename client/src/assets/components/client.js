import React from 'react';
import marca1 from '../images/Imagens Marcas/Png/imagen1.png'
import marca2 from '../images/Imagens Marcas/Png/imagen2.png'
import marca3 from '../images/Imagens Marcas/Png/imagen3.png'
import marca4 from '../images/Imagens Marcas/Png/imagen4.png'
function Clients() {
  return (
    <div id="clients" className="py-16 bg-blue-100">
      <div className="container">
        <div className="text-center">
          <h2 className="mb-12 section-heading wow fadeInDown animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>Nuestras Marcas Afiliadas</h2>
        </div>
        <div className="flex flex-wrap justify-center">
          <div className="w-1/2 md:w-1/4 lg:w-1/4">
            <div className="m-3 wow fadeInUp animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img className="client-logo" src={marca1} alt="" />
            </div>
          </div>
          <div className="w-1/2 md:w-1/4 lg:w-1/4">
            <div className="m-3 wow fadeInUp animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img className="client-logo" src={marca2} alt="" />
            </div>
          </div>
          <div className="w-1/2 md:w-1/4 lg:w-1/4">
            <div className="m-3 wow fadeInUp animated" data-wow-delay="0.9s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.9s', '-moz-animation-delay': '0.9s', animationDelay: '0.9s' }}>
              <img className="client-logo" src={marca3} alt="" />
            </div>
          </div>
          <div className="w-1/2 md:w-1/4 lg:w-1/4">
            <div className="m-3 wow fadeInUp animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img className="client-logo" src={marca4} alt="" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Clients;