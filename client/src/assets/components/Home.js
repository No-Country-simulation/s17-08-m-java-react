import React from 'react';
import Imagenhero from '../images/Imagen Hero/imagen-Hero.png'
function Home() {
  return (
    <div id="feature" className="bg-blue-100 py-24">
      <div className="container">
        <div className="flex justify-between">
          <div className="w-full text-center">
          <h2 className="text-4xl font-bold leading-snug text-gray-700 mb-10 wow fadeInUp animated" data-wow-delay="1s" style={{ visibility: 'visible', '-webkit-animation-delay': '1s', '-moz-animation-delay': '1s', animationDelay:   
              '1s' }}>Soluciones<br className="hidden lg:block" />Para tu Hogar</h2>
            <div className="text-center mb-10 wow fadeInUp animated" data-wow-delay="1.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '1.2s', '-moz-animation-delay': '1.2s', animationDelay: '1.2s' }}>
              <a href="#" rel="nofollow" className="btn">Conecta con tu Experto</a>
            </div>
            <div className="text-center mb-10 wow fadeInUp animated" data-wow-delay="1.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '1.2s', '-moz-animation-delay': '1.2s', animationDelay: '1.2s' }}>
              <a href="#" rel="nofollow" className="btn">Registrate como Profesional</a>
            </div>
          </div>
          <div className="w-full lg:w-1/2">
            <div className="mx-3 lg:mr-0 lg:ml-3 wow fadeInRight animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img src={Imagenhero} alt="" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;