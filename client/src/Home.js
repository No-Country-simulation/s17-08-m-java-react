import React from "react";
import Home1 from './assets/components/Home';
import Feature from './assets/components/Feature';
import Services from './assets/components/Service';
import Clients from "./assets/components/client";
import Pricing from "./assets/components/pricing";
import Carousel from "./assets/components/carusel";
import Subscribe from "./assets/components/suscribirse";
import Registrarse from "./assets/components/Registrarse";
import './Home.css'
function Home () {
    return(
        <div>
            <Home1 />
            <Feature />
            <Services />
            <Subscribe />
            <Clients />
            <Pricing />
            <Carousel />
            <Registrarse />
        </div>
    )
}


export default Home;