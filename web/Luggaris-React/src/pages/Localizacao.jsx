function Localizacao({ setLatitude, setLongitude, setEndereco }) {
  const obterEndereco = async (latitude, longitude, setEndereco) => {
    const url = `https://nominatim.openstreetmap.org/reverse?lat=${latitude}&lon=${longitude}&format=json`;

    try {
      const response = await fetch(url);
      const data = await response.json();
      
      if (data.address) {
        const enderecoFormatado = `${data.address.road || "Rua desconhecida"}, ${data.address.city || "Cidade desconhecida"} - ${data.address.state || "Estado desconhecido"}, ${data.address.country || "País desconhecido"}`;
        setEndereco(enderecoFormatado);
      } else {
        setEndereco("Endereço não encontrado");
      }

    } catch (error) {
      console.error("Erro ao obter endereço:", error);
      setEndereco("Erro ao buscar endereço");
    }
  };

  const obterLocalizacao = (event) => {
    event.preventDefault();
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(async (position) => {
        const latitude = position.coords.latitude;
        const longitude = position.coords.longitude;

        setLatitude(latitude);
        setLongitude(longitude);
        setEndereco("Buscando endereço...");

        await obterEndereco(latitude, longitude, setEndereco);
      });
    } else {
      alert("Geolocalização não é suportada neste navegador.");
    }
  };

  return <button onClick={obterLocalizacao}>Obter Localização</button>;
}

export default Localizacao;
