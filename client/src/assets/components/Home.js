import React from 'react';
import Imagenhero from '../images/Imagen Hero/imagen-Hero.png';

function Home() {
  return (
    <div id="feature" className="">
      <div className="container mx-auto px-4 ">
        <div className="flex flex-col lg:flex-row justify-between items-center">
          <div className="w-full lg:w-1/2 text-center lg:text-left">
            <h2 className="text-left text-4xl font-bold leading-snug text-gray-700 mb-5 wow fadeInUp animated" data-wow-delay="1s" style={{ visibility: 'visible', animationDelay: '1s', fontSize: '75px' }}>
              Soluciones<br className="hidden lg:block" /> Para tu Hogar
            </h2>
            <h3 className=" text-left  text-xl leading-snug text-gray-700 mb-8 pr-5 wow fadeInUp animated" data-wow-delay="1s" style={{ visibility: 'visible', animationDelay: '1s', lineHeight: '2.5' }}>
              Servicio de calidad garantizada para cada rincón de tu hogar
            </h3>

            <div className="flex flex-col items-center">
  <div className="mb-10 wow fadeInUp animated" data-wow-delay="1.2s" style={{ visibility: 'visible', animationDelay: '1.2s' }}>
    <a href="#" rel="nofollow" className="btn w-96 h-14 bg-blue-500 text-white border-2 border-blue-500 text-lg font-medium rounded-md flex items-center justify-center hover:bg-blue-600 transition duration-300 ease-in-out">
      Conecta con tu Experto
    </a>
  </div>
  <div className="mb-10 wow fadeInUp animated" data-wow-delay="1.2s" style={{ visibility: 'visible', animationDelay: '1.2s' }}>
  <a
    href="#"
    rel="nofollow"
    className="w-96 h-14 bg-white text-blue-500 border-2 border-blue-600  rounded-full flex items-center text-lg  justify-center font-medium hover:bg-blue-600 hover:text-white transition duration-300 ease-in-out"
  >
    Regístrate como Profesional
  </a>
</div>
</div>

          </div>

          <div className="w-full lg:w-1/2 text-center">
            <div className="mx-3 lg:mr-0 lg:ml-3 wow fadeInRight animated" data-wow-delay="0.3s" style={{ visibility: 'visible', animationDelay: '0.3s' }}>
              <img src={Imagenhero} alt="Imagen Hero" className="w-full h-full" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;