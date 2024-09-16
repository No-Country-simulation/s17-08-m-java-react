import React from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
/* import imagenPlomero from '../images/IconosOficios/albañil.jpg';
import albañil from '../images/albañil.jpg';  */



import {
faPaintRoller,faHammer,faTrowel ,faHelmetSafety,faTruckPickup,faBucket,faFire,faTree,faFaucetDrip,faCar,faKey,faVideo,faBolt,faGavel,faTemperatureLow,
} from "@fortawesome/free-solid-svg-icons";

const Services = () => {
  const servicesData = [
    {
      icon: faTrowel ,
      title: "Albañil",
      link: "/plomero",
    },
    {
      icon: faFaucetDrip,
      title: "Plomero",
      link: "/plomero",
    },
    {
      icon: faTemperatureLow,
      title: "A/A",
      link: "/plomero",
    },
    {
      icon: faHelmetSafety,
      title: "Arquitecto",
      link: "/plomero",
    },
    {
      icon: faCar,
      title: "Mecánico",
      link: "/plomero",
    },
    {
      icon: faHammer,
      title: "Carpintero",
      link: "/plomero",
    },
    {
      icon: faBolt,
      title: "Electricista",
      link: "/plomero",
    },
    {
      icon: faFire,
      title: "Gasista",
      link: "/plomero",
    },
    {
      icon: faGavel,
      title: "Herrero",
      link: "/plomero",
    },
    {
      icon: faTree,
      title: "Jardinero",
      link: "/plomero",
    },
    {
      icon: faBucket,
      title: "Limpieza",
      link: "/plomero",
    },
    {
      icon: faTruckPickup,
      title: "Mudanza",
      link: "/plomero",
    },
    {
      icon: faPaintRoller,
      title: "Pintores",
      link: "/plomero",
    },
    {
      icon: faVideo,
      title: "Seguridad",
      link: "/plomero",
    },
    {
      icon: faKey,
      title: "Cerrajero",
      link: "/plomero",
    },
  ];

  return (
    <section
      id="services"
      className="bg-custom-blue text-white py-24 max-w-[1300px] mx-auto  "
    >
      <div className="container text-center">
        <h2 className="text-5xl font-bold text-center mb-32 ">
          Nuestros Servicios
        </h2>
        <div className="grid grid-cols-6 gap-12 text-center">
          {servicesData.map((service, index) => (
            <Link
              to={service.link}
              key={index}
              className="flex flex-col items-center"
            >
              <div className="text-center bg-custom-light-blue justify-center  rounded-lg shadow-md p-6 hover:bg-blue-50 w-24 h-24 hover:text-white transform transition-transform duration-300 hover:scale-105 ">
                <FontAwesomeIcon
                  icon={service.icon}
                  className="text-blue-500 text-4xl mb-2"
                />
              </div>
              <h3 className="text-xl font-medium text-white ">
                {service.title}
              </h3>
            </Link>
          ))}
        </div>
      </div>
    </section>
  );
};

export default Services;
