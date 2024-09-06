import React, { useState } from 'react';
import Slider from 'react-slick';

function Carousel() {
  const [ setSliderRef] = useState(null);

  const settings = {
    arrows: true,
    dots: true,
    infinite: true,
    slidesToShow: 3,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
        },
      },
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
        },
      },
    ],
  };

  return (
    <section className="carousel-area bg-gray-800 py-32">
      <div className="container">
        <div className="flex">
          <div className="w-full relative">
            <Slider ref={setSliderRef} {...settings}>
              <div>
                <img className="w-full" src="assets/img/slide/img1.jpg" alt="" />
              </div>
              <div>
                <img className="w-full" src="assets/img/slide/img2.jpg" alt="" />
              </div>
              <div>
                <img className="w-full" src="assets/img/slide/img3.jpg" alt="" />
              </div>
              {/* Add more slides here */}
            </Slider>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Carousel;