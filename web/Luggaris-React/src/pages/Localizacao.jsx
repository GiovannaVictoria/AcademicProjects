import { useState } from "react";
import './Home.css';
import './FormularioClinica.css'

function Localizacao() {
  const [posicao, setPosicao] = useState(undefined);

  const obterLocalizacao = () => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        setPosicao({
          latitude: position.coords.latitude,
          longitude: position.coords.longitude,
        });
      });
    } else {
      alert("Geolocalização não é suportada neste navegador.");
    }
  };

  return (
    <div>
      <button onClick={obterLocalizacao}>Obter Localização</button>
      {posicao && (
        <p>Latitude: {posicao.latitude}, Longitude: {posicao.longitude}</p>
      )}
    </div>
  );
}

export default Localizacao;
