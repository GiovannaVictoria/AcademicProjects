import React, { useEffect, useState } from "react";

function haversine(latitude1, longitude1, latitude2, longitude2) {
  const raioTerra = 6371;
  const toRadians = (deg) => deg * (Math.PI / 180);
  
  const dLat = toRadians(latitude2 - latitude1);
  const dLon = toRadians(longitude2 - longitude1);
  const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
  
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  return raioTerra * c; 
}

const ListaClinicas = ({ latitude, longitude, distancia, especialidade, horario, avaliacao, convenio}) => {
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
        <ul>
          {clinicas.length > 0 ? (
            clinicas.map(clinica => <li key={clinica.id}>{clinica.nome}</li>)
          ) : (
            <p>Nenhuma clínica encontrada.</p>
          )}
        </ul>
      )}
    </div>
  );
};

export default ListaClinicas;
