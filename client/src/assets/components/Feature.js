import React from 'react';
import nabfeb from '../images/Ilustraciones/na_feb_.png'
function Feature() {
  return (
    <div id="feature" className="bg-blue-100 py-24">
      <div className="container">
        <div className="flex flex-wrap items-center">
          <div className="w-full lg:w-1/2">
            <div className="mb-5 lg:mb-0">
              <h2 className="mb-12 section-heading wow fadeInDown animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>Nuestro Compromiso Contigo</h2>

              <div className="flex flex-wrap">
                <div className="w-full sm:w-1/2 lg:w-1/2">
                  <div className="m-3">
                    <div className="icon text-4xl">
                      <i className="lni lni-layers"></i>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title">Encuentra al Profesional Ideal</h4>
                      <p>Explora perfiles verificados de expertos en mantenimiento del hogar y elige al profesional que mejor se adapte a tus necesidades.</p>
                    </div>
                  </div>
                </div>
                <div className="w-full sm:w-1/2 lg:w-1/2">
                  <div className="m-3">
                    <div className="icon text-4xl">
                      <i className="lni lni-gift"></i>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title">Registro Seguro</h4>
                      <p>Todos los proveedores pasan por un proceso de verificación para garantizar seguridad y calidad en cada servicio.</p>
                    </div>
                  </div>
                </div>
                <div className="w-full sm:w-1/2 lg:w-1/2">
                  <div className="m-3">
                    <div className="icon text-4xl">
                      <i className="lni lni-laptop-phone"></i>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title">Proceso Rápido y Transparente</h4>
                      <p>Contacta directamente con los profesionales, sin intermediarios ni costos ocultos, para obtener el servicio que necesitas.</p>
                    </div>
                  </div>
                </div>
                <div className="w-full sm:w-1/2 lg:w-1/2">
                  <div className="m-3">
                    <div className="icon text-4xl">
                      <i className="lni lni-leaf"></i>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title">Opiniones de la Comunidad</h4>
                      <p>Tu reseña es clave para mejorar la experiencia y ayudar a otros a tomar decisiones informadas.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="w-full lg:w-1/2">
            <div className="mx-3 lg:mr-0 lg:ml-3 wow fadeInRight animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img src={nabfeb} alt="" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Feature;