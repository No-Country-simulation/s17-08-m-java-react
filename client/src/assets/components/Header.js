import React, { useState } from 'react';
import Logo from '../images/ArregloYa2.png'
import { Link } from 'react-router-dom';
import './Header.css';

function Header() {
  const [isNavOpen, setIsNavOpen] = useState(false);  // Estado para controlar la visibilidad del menú

  return (
    <header id="header-wrap" className="relative p-12">
      <div className="bg-gray-800 navigation fixed top-0 left-0 w-full z-30 shadow-md" style={{ height: '100px' }}>
        <div className="container">
          <nav className="container mx-auto flex items-center justify-between h-24 px-4">
            <Link to="/" className="navbar-brand">
              <img src={Logo} alt="Logo"/>
            </Link>
            <button className="navbar-toggler focus:outline-none block lg:hidden" onClick={() => setIsNavOpen(!isNavOpen)} aria-label="Toggle navigation">
              <span className="toggler-icon block"></span>
              <span className="toggler-icon block"></span>
              <span className="toggler-icon block"></span>
            </button>
            <div className={`${isNavOpen ? 'block' : 'hidden'} lg:block top-100 left-0 mt-full bg-black z-20 px-5 py-3 w-full lg:static lg:bg-transparent lg:shadow-none duration-300`}>
              <ul className='navbar-nav flex flex-col lg:flex-row justify-center items-center lg:space-x-10 space-y-4 lg:space-y-0'>
                <li className='nav-item'>
                  <Link to="/nosotros" className="text-lg text-white hover:text-blue-500 transition duration-300 ease-in-out ">Nosotros</Link>
                </li>
                <li className='nav-item'>
                  <Link to="/servicios" className="text-lg text-white hover:text-blue-500 transition duration-300 ease-in-out">Servicios</Link>
                </li>
                <li className='nav-item'>
                  <Link to="#feature" className="text-lg text-white hover:text-blue-500 transition duration-300 ease-in-out">Promociona tu Servicio</Link>
                </li>
                <li className='nav-item'>
                  <Link to="#search" className="text-lg text-white hover:text-custom-light-btn transition duration-300 ease-in-out ">Búsqueda</Link>
                </li>
              </ul>
            </div>
            <div className="header-btn hidden sm:block sm:absolute sm:right-0 sm:mr-16 lg:static lg:mr-0">
              <Link
                to="/login"
                className="bg-white text-blue-600 border-0 border-blue-600 px-2 py-3 rounded-full text-xs font-medium duration-300 hover:bg-blue-600 hover:text-white whitespace-nowrap min-w-[120px] inline-block text-center"
              >
                Iniciar Sesión
              </Link>
            </div>
          </nav>
        </div>
      </div>
    </header>
  );
}

export default Header;
