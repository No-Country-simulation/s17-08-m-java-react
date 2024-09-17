import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PlomeroPage from './assets/pages/PlomeroPage';
import FormularioAlbañil from './assets/pages/FormularioAlbañil';
import Nosotros from './assets/pages/Nosotros';
import Home from './Home';
import Login from './assets/pages/Login';
import Header from './assets/components/Header';
import Footer from './assets/components/Footer';
import Activation from './assets/pages/Activation';
import './assets/css/animate.css';
import './assets/css/tailwind.css';
import Servicios from './assets/pages/Servicios';
import Register from './assets/pages/Registrate';

function App() {
    return (
        <BrowserRouter>
            <Header />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/plomero" element={<PlomeroPage />} />
                <Route path="/formulario-albanil" element={<FormularioAlbañil />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/nosotros" element={<Nosotros />} />
                <Route path='/activation' element={<Activation/>}/>
                <Route path='/servicios' element={<Servicios/>}/>
            </Routes>
            <Footer />
        </BrowserRouter>
    );
}

export default App;
