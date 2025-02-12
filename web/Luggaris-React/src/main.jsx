import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import FormularioClinica from "./pages/FormularioClinica";
import "./index.css";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/formulario-clinica" element={<FormularioClinica />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
