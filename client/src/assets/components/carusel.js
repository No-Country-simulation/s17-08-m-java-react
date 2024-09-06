import React from 'react';
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Testimonial from './Testimonial'; // Componente individual del testimonio

const testimonials = [
  {
    name: 'Laura G.',
    testimonial: 'La mejor decisión que tomé fue confiar en esta plataforma para encontrar profesionales. Desde la búsqueda hasta la contratación, todo fue sencillo y transparente. Los resultados fueron excepcionales y el servicio al cliente inmejorable. Altamente recomendada!',
  },
  {
    name: 'Juan Pérez',
    testimonial: 'Estoy muy satisfecho con el servicio. Encontré al profesional que necesitaba rápidamente y el trabajo fue realizado de manera eficiente.',
  },
  // Agrega más testimonios aquí
];

function Carousel() {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <div className="container mx-auto py-16">
      <h2 className="text-3xl font-bold text-center mb-8">Testimonios de Nuestros Clientes</h2>
      <Slider {...settings}>
        {testimonials.map((testimonial, index) => (
          <Testimonial key={index} {...testimonial} />
        ))}
      </Slider>
    </div>
  );
}

export default Carousel;