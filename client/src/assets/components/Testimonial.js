import React from 'react';
import avatar from '../images/avatar.jpg'; 
/* import avatar2 from '../images/avatar2.jpg';  */

function Testimonial({ name, testimonial }) {
  return (
    <div className="flex flex-col items-center justify-center text-center p-24 bg-custom-blue h-[25rem]">
      <p className="text-xl lg:text-3xl text-white mb-8 max-w-[750px]">{testimonial}</p>

      
      <img 
        src={avatar} 
        alt="Descripción de la imagen" 
        className="w-16 h-16 rounded-full mb-4" 
      />

      <p className="text-4lg lg:text-xl font-bold mt-4 text-white">{name}</p>
    </div>
  );
}

export default Testimonial;