import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import "leaflet/dist/leaflet.css";
import "./ListaClinicas.css";

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

  const localizacaoPessoal = new L.Icon({
    iconUrl: "/images/bolinhaAzul.png",
    iconSize: [40, 40],
    iconAnchor: [20, 40],
    popupAnchor: [0, -40],
  });

  const localizacaoClinica = new L.Icon({
    iconUrl: "/images/localizacaoClinica.png",
    iconSize: [40, 40],
    iconAnchor: [20, 40],
    popupAnchor: [0, -40],
  });

  return (
    <div className="map">
      <br /><br />
      <hr className="divisor" />
      <br /><br />

      <h1 className="map-titulo">Clínicas próximas</h1>
      <br />
      {loading ? <p>Carregando...</p> : (
        <MapContainer className="map-container" center={[latitude, longitude]} zoom={13}>
          <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />

          <Marker position={[latitude, longitude]} icon={localizacaoPessoal}>
            <Popup className="popup">Sua localização</Popup>
          </Marker>

          {clinicas.map(clinica => (
            <Marker key={clinica.id} position={[clinica.latitude, clinica.longitude]} icon={localizacaoClinica}>
              <Popup className="popup">
                <strong>{clinica.nome}</strong><br />
                Especialidades: {clinica.especialidades.join(", ")}<br />
                Horários: {clinica.horarios.join(", ")}<br />
                Convênios: {clinica.convenios.join(", ")}<br />
                Avaliação: {clinica.avaliacao} {clinica.avaliacao === 1 ? "estrela" : "estrelas"}<br />
                Endereço: {clinica.endereco}
              </Popup>
            </Marker>
          ))}
        </MapContainer>
      )}
    </div>
  );
};

export default ListaClinicas;
