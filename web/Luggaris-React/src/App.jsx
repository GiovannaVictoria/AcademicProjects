import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import FormularioClinica from "./components/FormularioClinica";
import Localizacao from "./components/Localizacao";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/formulario-clinica" element={<FormularioClinica />} />
        <Route path="/localizacao" element={<Localizacao />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
