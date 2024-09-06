import React from 'react';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faWrench /* ...otros iconos */ } from '@fortawesome/free-solid-svg-icons';

const Services = () => {
  const servicesData = [
    {
      icon: faWrench,
      title: 'Plomero',
      link: '/plomero'
    },
  ];

  return (
    <section id="services" className="bg-blue-100 py-24">
      <div className="container">
        <h2 className="text-3xl font-bold text-center mb-10">Nuestros Servicios</h2>
        <div className="grid grid-cols-3 gap-4">
          {servicesData.map((service, index) => (
            <Link to={service.link} key={index}>
              <div className="text-center bg-white rounded-lg shadow-md p-6 hover:bg-blue-50 hover:text-white">
                <FontAwesomeIcon icon={service.icon} className="text-blue-500 text-4xl mb-2" />
                <h3 className="text-xl font-medium">{service.title}</h3>
              </div>
            </Link>
          ))}
        </div>
      </div>
    </section>
  );
};

export default Services;