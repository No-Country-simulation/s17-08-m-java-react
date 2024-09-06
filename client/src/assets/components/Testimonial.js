import React from 'react';

function Testimonial({ name, testimonial }) {
  return (
    <div className="text-center p-8">
      <p className="text-lg">{testimonial}</p>
      <p className="font-bold mt-4">{name}</p>
    </div>
  );
}

export default Testimonial;