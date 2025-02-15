import React, { useEffect, useState } from "react";

const ListaClinicas = ({ latitude, longitude }) => {
  const [clinicas, setClinicas] = useState([]);
  const [loading, setLoading] = useState(true);

  alert("d");
  useEffect(() => {
    alert("e");
    alert(latitude && longitude);
    alert(latitude);
    alert(longitude);
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
            Math.abs(clinica.latitude) != 0 &&
            Math.abs(clinica.longitude) != 0
          );
          setClinicas(clinicasProximas);
        })
        .catch(error => console.error("Erro ao buscar clínicas:", error))
        .finally(() => setLoading(false));
    }
  }, [latitude, longitude]);

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
