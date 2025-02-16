import React, { useEffect, useState } from "react";

function haversine(lat1, lon1, lat2, lon2) {
  const R = 6371; // Raio da Terra em km
  const toRadians = (deg) => deg * (Math.PI / 180);
  
  const dLat = toRadians(lat2 - lat1);
  const dLon = toRadians(lon2 - lon1);
  const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
  
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  alert(R * c);
  return R * c; // Distância em km
}

const ListaClinicas = ({ latitude, longitude, distancia, especialidade, horario, avaliacao}) => {
  const [clinicas, setClinicas] = useState([]);
  const [loading, setLoading] = useState(true);

  // alert("d");
  useEffect(() => {
    // alert("e");
    // alert(latitude && longitude);
    alert(latitude);
    alert(longitude);
    alert(distancia);
    alert(especialidade);
    alert(horario);
    alert(avaliacao);
    // if (latitude && longitude) {
      // fetch("http://localhost:5000/clinicas") // Faz a requisição ao JSON Server
      if (latitude !== null && longitude !== null) {
        fetch(`http://localhost:5000/clinicas`)
        // fetch(`http://localhost:5000/clinicas?latitude=${latitude}&longitude=${longitude}`)
        // fetch(`http://localhost:5000/clinicas?latitude=23&longitude=46`)
        .then(response => response.json())
        .then(data => {
          // Filtra as clínicas mais próximas (simulação)
          const clinicasProximas = data.filter(clinica =>
            haversine(latitude, longitude, clinica.latitude, clinica.longitude) <= distancia
            && clinica.especialidades.includes(especialidade.toLowerCase())
            && horario.every(item => clinica.horarios.includes(item))
          );
          setClinicas(clinicasProximas);
        })
        .catch(error => console.error("Erro ao buscar clínicas:", error))
        .finally(() => setLoading(false));
    }
  }, [latitude, longitude, distancia, especialidade, horario, avaliacao]);

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
