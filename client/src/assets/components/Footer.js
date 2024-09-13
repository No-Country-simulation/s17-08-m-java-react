import React from 'react';
import Logo from '../images/ArregloYa2.png'

function Footer() {
  return (
    <footer id="footer" className="bg-gray-800 py-16 mt-32">
      <div className="container ">
        <div className="flex flex-wrap ">
          <div className="w-full sm:w-1/2 md:w-1/2 lg:w-1/4 wow fadeInUp animated" data-wow-delay="0.2s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.2s', '-moz-animation-delay': '0.2s', animationDelay: '0.2s' }}>
            <div className="mx-8">
              <div className="footer-logo ">
                <img src={Logo} alt="" />
              </div>
              <p className="text-gray-300">Descubre la plataforma lider de mantenimiento del hogar. Somos el puente que conecta a profesionales certificados con las necesidades de tu hogar.</p>
            </div>
          </div>
          <div className="w-full sm:w-1/2 md:w-1/2 lg:w-1/4 wow fadeInUp animated" data-wow-delay="0.4s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.4s', '-moz-animation-delay': '0.4s', animationDelay: '0.4s' }}>
            <div className="mx-8 mt-16">
              <h3 className="font-bold text-xl text-white mb-5">Aviso Legal</h3>
              <ul>
                <li><a className="footer-links">Políticas de privacidad</a></li>
                <li><a className="footer-links">Configuración de cookies</a></li>
                <li><a className="footer-links">Términos y condiciones</a></li>
              </ul>
            </div>
          </div>
          <div className="w-full sm:w-1/2 md:w-1/2 lg:w-1/4 wow fadeInUp animated" data-wow-delay="0.6s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.6s', '-moz-animation-delay': '0.6s', animationDelay: '0.6s' }}>
            <div className="mx-8 mt-16">
              <h3 className="font-bold text-xl text-white mb-5">Nosotros</h3>
              <ul>
                <li><a  className="footer-links">Cómo Funciona</a></li>
                <li><a  className="footer-links">Preguntas Frecuentes (FAQs)</a></li>
              </ul>
            </div>
          </div>
          <div className="w-full sm:w-1/2 md:w-1/2 lg:w-1/4 wow fadeInUp animated" data-wow-delay="0.8s" style={{ visibility: 'visible', '-webkit-animation-delay': '0.8s', '-moz-animation-delay': '0.8s', animationDelay: '0.8s' }}>
            <div className="mx-5 mt-16">
              <h3 className="font-bold text-xl text-white mb-5">Encontranos  tambien en</h3>
              <ul className="social-icons flex justify-start">
                <li className="mx-2">
                  <a className="footer-icon hover:bg-indigo-500">
                    <i className="lni lni-facebook-original" aria-hidden="true"></i>
                  </a>
                </li>
                <li className="mx-2">
                  <a href="#" className="footer-icon hover:bg-blue-400">
                    <i className="lni lni-twitter-original" aria-hidden="true"></i>
                  </a>
                </li>
                <li className="mx-2">
                  <a href="#" className="footer-icon hover:bg-red-500">
                    <i className="lni lni-instagram-original" aria-hidden="true"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;