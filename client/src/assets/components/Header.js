import React, { useState } from 'react';
import Logo from '../images/favicon_io/favicon2.png';
import { Link } from 'react-router-dom';
import './Header.css';

function Header() {
    const [isNavOpen, setIsNavOpen] = useState(false);  // Estado para controlar la visibilidad del menú

    return (
        <header id="header-wrap" className="relative">
            <div className="navigation fixed top-0 left-0 w-full z-30 bg-white shadow-md">
                <div className="container">
                    <nav className="navbar py-2 navbar-expand-lg flex justify-between items-center">
                        <Link to="/" className="navbar-brand">
                            <img src={Logo} alt="Logo"/>
                        </Link>
                        <button className="navbar-toggler focus:outline-none block lg:hidden" onClick={() => setIsNavOpen(!isNavOpen)} aria-label="Toggle navigation">
                            <span className="toggler-icon block"></span>
                            <span className="toggler-icon block"></span>
                            <span className="toggler-icon block"></span>
                        </button>
                        <div className={`${isNavOpen ? 'block' : 'hidden'} lg:block top-100 left-0 mt-full bg-black z-20 px-5 py-3 w-full lg:static lg:bg-transparent lg:shadow-none duration-300`}>
                            <ul className='navbar-nav mr-auto justify-center items-center lg:flex'>
                                <li className='nav-item'>
                                    <Link to="#hero-area" className="page-scroll active">Nosotros</Link>
                                </li>
                                <li className='nav-item'>
                                    <Link to="#services" className="page-scroll">Servicios</Link>
                                </li>
                                <li className='nav-item'>
                                    <Link to="#feature" className="page-scroll">Promociona tu Servicio</Link>
                                </li>
                                <li className='nav-item'>
                                    <Link to="#search" className="page-scroll">Búsqueda</Link>
                                </li>
                            </ul>
                        </div>
                        <div className="header-btn hidden sm:block sm:absolute sm:right-0 sm:mr-16 lg:static lg:mr-0">
                        <Link to="/login" className="text-blue-600 border border-blue-600 px-20 py-3 rounded-full duration-300 hover:bg-blue-600 hover:text-white">
                          Iniciar_Sesión
                        </Link>
                        </div>
                    </nav>
                </div>
            </div>
        </header>
    );
}

export default Header;
