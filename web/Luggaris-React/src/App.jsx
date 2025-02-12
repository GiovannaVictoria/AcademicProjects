import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import FormularioClinica from "./pages/FormularioClinica";
import Localizacao from "./pages/Localizacao";

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
