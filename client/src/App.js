import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PlomeroPage from './assets/pages/PlomeroPage'
import FormularioAlbañil from './assets/pages/FormularioAlbañil';
import './assets/css/animate.css';
import './assets/css/tailwind.css';
import Home from './Home';
import Login from './assets/pages/Login'
import Header from './assets/components/Header'
import Footer from './assets/components/Footer';
function App() {
  return (
    <BrowserRouter>
        <Header />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/plomero" element={<PlomeroPage />} />
            <Route path="/formulario-albanil" component={<FormularioAlbañil />} />
          </Routes>
          <Routes>
            <Route path="/login" element={<Login />} />
          </Routes>
        <Footer />
    </BrowserRouter>
  );
}

export default App;