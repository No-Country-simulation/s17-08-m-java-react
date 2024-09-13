import React from 'react';
import Ilustracion from '../images/Ilustraciones/Ilustracion2.png'
function Feature() {
  return (
    <div id="feature" className=" py-24">
      <div className="container">
        <div className="flex flex-wrap items-center">
          <div className="w-full lg:w-1/2">
            <div className="mb-5 lg:mb-0">
              <h2 className=" mb-12 section-heading wow fadeInDown animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>¿Eres un Profesional? Regístrate y Ofrece tus Servicios</h2>

              <div className="flex flex-wrap">
                <div className="w-full sm:w-1 lg:w-1">
                  <div className="m-3">
                    <div className="icon text-4xl">
                      <i className="lni lni-layers"></i>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title"></h4>
                      <p>Si tienes experiencia en servicios relacionado con el mantenimiento del hogar, únete a nuestra plataforma y llega a más clientes.</p>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title"></h4>
                      <p>Regístrate fácilmente, crea tu perfil y comienza a ofrecer tus servicios. </p>
                    </div>
                    <div className="features-content">
                      <h4 className="feature-title"></h4>
                      <p>¡Amplía tus oportunidades de trabajo y conecta con quienes necesitan tu experiencia!</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="wow fadeInDown animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
  <div className="flex justify-center mt-8"> 
    <button className="border-0 bg-blue-600 text-white rounded-full w-72 h-12 duration-300 hover:opacity-75" type="submit">
      <i className="lni lni-arrow-right not-italic">Regístrate ahora</i>
    </button>
  </div>
</div>
          </div>
          <div className="w-full lg:w-1/2">
            <div className="mx-3 lg:mr-0 lg:ml-3 wow fadeInRight animated" data-wow-delay="0.3s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.3s', '-moz-animation-delay': '0.3s', animationDelay: '0.3s' }}>
              <img src={Ilustracion} alt="" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Feature;