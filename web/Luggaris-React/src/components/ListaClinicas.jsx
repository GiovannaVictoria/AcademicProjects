import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import "leaflet/dist/leaflet.css";

// Ícone para corrigir erro de ícone padrão do Leaflet
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: "https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon-2x.png",
  iconUrl: "https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon.png",
  shadowUrl: "https://unpkg.com/leaflet@1.7.1/dist/images/marker-shadow.png"
});

function haversine(latitude1, longitude1, latitude2, longitude2) {
  const raioTerra = 6371;
  const toRadians = (deg) => deg * (Math.PI / 180);

  const dLat = toRadians(latitude2 - latitude1);
  const dLon = toRadians(longitude2 - longitude1);
  const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(toRadians(latitude1)) * Math.cos(toRadians(latitude2)) *
    Math.sin(dLon / 2) * Math.sin(dLon / 2);

  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  return raioTerra * c;
}

const ListaClinicas = ({ latitude, longitude, distancia, especialidade, horario, avaliacao, convenio }) => {
  const [clinicas, setClinicas] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (latitude !== null && longitude !== null) {
      fetch(`http://localhost:5000/clinicas`)
        .then(response => response.json())
        .then(data => {
          const clinicasProximas = data.filter(clinica =>
            haversine(latitude, longitude, clinica.latitude, clinica.longitude) <= distancia
            && clinica.especialidades.includes(especialidade.toLowerCase())
            && horario.every(item => clinica.horarios.includes(item))
            && clinica.avaliacao >= avaliacao
            && convenio.every(item => clinica.convenios.includes(item))
          );
          setClinicas(clinicasProximas);
        })
        .catch(error => console.error("Erro ao buscar clínicas:", error))
        .finally(() => setLoading(false));
    }
  }, [latitude, longitude, distancia, especialidade, horario, avaliacao, convenio]);

  return (
    <div>
      <h2>Clínicas próximas</h2>
      {loading ? <p>Carregando...</p> : (
        <MapContainer center={[latitude, longitude]} zoom={13} style={{ height: "50dvh", width: "80%", margin: "auto", border: "solid 0.4dvh #16001e" }}>
          <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />

          {/* Marcador para sua localização */}
          <Marker position={[latitude, longitude]}>
            <Popup>Sua localização</Popup>
          </Marker>

          {/* Marcadores das clínicas */}
          {clinicas.map(clinica => (
            <Marker key={clinica.id} position={[clinica.latitude, clinica.longitude]}>
              <Popup>
                <strong>{clinica.nome}</strong><br />
                Avaliação: {clinica.avaliacao}
              </Popup>
            </Marker>
          ))}
        </MapContainer>
      )}
    </div>
  );
};

export default ListaClinicas;
