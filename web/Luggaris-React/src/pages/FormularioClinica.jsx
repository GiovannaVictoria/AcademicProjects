import React, { useState } from 'react';
import './Home.css';
import './FormularioClinica.css';
import ListaClinicas from '../components/ListaClinicas';

const FormularioClinica = () => {
  // const [localizacao, setLocalizacao] = useState('');
  const [latitude, setLatitude] = useState(null);
  const [longitude, setLongitude] = useState(null);
  const [distancia, setDistancia] = useState(null);
  const [especialidade, setEspecialidade] = useState(null);
  const [clinicas, setClinicas] = useState([]);
  const [horario, setHorario] = useState([]);
  const [aberto24h, setAberto24h] = useState(false);
  const [avaliacao, setAvaliacao] = useState(1);

  const horariosOpcoes = ['manha', 'tarde', 'noite', 'madrugada'];

  const handleLatitudeChange = (event) => setLatitude(event.target.value);
  const handleLongitudeChange = (event) => setLongitude(event.target.value);
  const handleDistanciaChange = (event) => setDistancia(event.target.value);
  const handleEspecialidadeChange = (event) => setEspecialidade(event.target.value);
  const handleAvaliacaoChange = (event) => setAvaliacao(Number(event.target.value));
  // const handleHorarioChange = (event) => setHorario(event.target.value);

  const handleHorarioChange = (e) => {
    const { value, checked } = e.target;

    // Se o usuário marcar ou desmarcar um horário
    setHorario((prevHorario) => {
      let newHorario;
      if (checked) {
        newHorario = [...prevHorario, value];
      } else {
        newHorario = prevHorario.filter((item) => item !== value);
      }

      // Verifica se todas as opções de horário estão selecionadas para marcar o "Aberto 24h"
      if (newHorario.length === horariosOpcoes.length) {
        setAberto24h(true);
      } else {
        setAberto24h(false);
      }

      return newHorario;
    });
  };

  const handleAberto24hChange = (e) => {
    const { checked } = e.target;
    setAberto24h(checked);

    if (checked) {
      // Marca todas as opções de horário
      setHorario(['manha', 'tarde', 'noite', 'madrugada']);
    } else {
      // Desmarca todas as opções
      setHorario([]);
    }
  };

  // alert("a");

  const obterLocalizacao = (event) => {
    event.preventDefault();
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        // (position) => {
        //   const coords = `${position.coords.latitude}, ${position.coords.longitude}`;
        //   setLocalizacao(coords);
        // },
        (position) => {
          setLatitude(position.coords.latitude);
          setLongitude(position.coords.longitude);
        },
        (error) => {
          alert('Erro ao obter localização: ' + error.message);
        }
      );
    } else {
      alert('Geolocalização não é suportada neste navegador.');
    }
  };

  const buscarClinicas = async (event) => {
    // alert("b");
    event.preventDefault();

    // Captura os valores do formulário
    const especialidade = event.target.especialidade.value;
    const distancia = event.target.distancia.value;

    // Monta a URL para buscar as clínicas no json-server
    const url = `http://localhost:5000/clinicas`;

    try {
      // alert("c");
      const resposta = await fetch(url);
      if (!resposta.ok) throw new Error('Erro ao buscar clínicas');

      alert(resposta);
      const dados = await resposta.json();
      alert(dados);
      setClinicas(dados); // Atualiza o estado com os dados das clínicas
    } catch (erro) {
      alert('Erro ao buscar clínicas: ' + erro.message);
    }
  };

  return (
    <div>
      <h1>Digite as informações sobre o tipo de clínica que você quer encontrar:</h1>

      <form onSubmit={buscarClinicas}>

        <div className="form-externa">

          <div className="form-interna">
            <label htmlFor="especialidade" className="titulo">Especialidade:</label><br />
            <input
              type="text"
              id="especialidade"
              name="especialidade"
              onChange={handleEspecialidadeChange}
              required />
          </div>

          {/* <div className="form-interna">
            <label htmlFor="enderecoProximo" className="titulo">Próximo à localização:</label><br />
            <input type="text" id="enderecoProximo" name="enderecoProximo" value={localizacao} readOnly />
            <button onClick={obterLocalizacao}>Obter Localização</button>
          </div> */}

          <div className="form-interna">

            <label htmlFor="latitude" className="titulo">Latitude:</label><br />
            <input
              type="number"
              id="latitude"
              name="latitude"
              step="any"
              value={latitude}
              onChange={handleLatitudeChange}
              required />
            <br></br>

            <label htmlFor="longitude" className="titulo">Longitude:</label><br />
            <input
              type="number"
              id="longitude"
              name="longitude"
              step="any"
              value={longitude}
              onChange={handleLongitudeChange}
              required />
            <br></br>

            <button onClick={obterLocalizacao}>Obter Localização</button>
          </div>

          <div className="form-interna">
            <label htmlFor="distancia" className="titulo">Distância máxima (em km):</label><br />
            <input
              type="number"
              id="distancia"
              name="distancia"
              min="1"
              max="100"
              onChange={handleDistanciaChange}
              required />
          </div>

          <div className="form-interna">
            <label className="titulo">Horário de funcionamento:</label><br />

            <input
              type="checkbox"
              id="aberto24h"
              name="horario"
              checked={aberto24h}
              onChange={handleAberto24hChange}
            />
            <label htmlFor="aberto24h">Aberto 24h</label><br />

            <input
              type="checkbox"
              id="manha"
              name="horario"
              value="manha"
              checked={horario.includes('manha')}
              onChange={handleHorarioChange}
            />
            <label htmlFor="manha">De manhã</label><br />

            <input
              type="checkbox"
              id="tarde"
              name="horario"
              value="tarde"
              checked={horario.includes('tarde')}
              onChange={handleHorarioChange}
            />
            <label htmlFor="tarde">De tarde</label><br />

            <input
              type="checkbox"
              id="noite"
              name="horario"
              value="noite"
              checked={horario.includes('noite')}
              onChange={handleHorarioChange}
            />
            <label htmlFor="noite">De noite</label><br />

            <input
              type="checkbox"
              id="madrugada"
              name="horario"
              value="madrugada"
              checked={horario.includes('madrugada')}
              onChange={handleHorarioChange}
            />
            <label htmlFor="madrugada">De madrugada</label><br />
          </div>

          <div className="form-interna">
            <label className="titulo">Avaliação mínima:</label><br />

            <input
              type="radio"
              id="umaEstrela"
              name="avaliacao"
              value={1}
              checked={avaliacao === 1}
              onChange={handleAvaliacaoChange} />
            <label htmlFor="umaEstrela">Uma estrela</label><br />

            <input
              type="radio"
              id="duasEstrelas"
              name="avaliacao"
              value={2}
              checked={avaliacao === 2}
              onChange={handleAvaliacaoChange} />
            <label htmlFor="duasEstrelas">Duas estrelas</label><br />

            <input
              type="radio"
              id="tresEstrelas"
              name="avaliacao"
              value={3}
              checked={avaliacao === 3}
              onChange={handleAvaliacaoChange} />
            <label htmlFor="tresEstrelas">Três estrelas</label><br />

            <input
              type="radio"
              id="quatroEstrelas"
              name="avaliacao"
              value={4}
              checked={avaliacao === 4}
              onChange={handleAvaliacaoChange} />
            <label htmlFor="quatroEstrelas">Quatro estrelas</label><br />

            <input
              type="radio"
              id="cincoEstrelas"
              name="avaliacao"
              value={5}
              checked={avaliacao === 5}
              onChange={handleAvaliacaoChange} />
            <label htmlFor="cincoEstrelas">Cinco estrelas</label><br />

          </div>

        </div>

        <div className="botao">
          <input type="submit" value="Buscar Clínicas" />
        </div>

      </form>

      {/* Exibe os resultados após a busca */}
      {/* {clinicas.length > 0 && <ListaClinicas clinicas={clinicas} />} */}
      {clinicas.length > 0 && <ListaClinicas latitude={latitude} longitude={longitude} distancia={distancia} especialidade={especialidade} clinicas={clinicas} horario={horario} avaliacao={avaliacao} />}

    </div>
  );
};

export default FormularioClinica;





// import React from 'react';
// import './Home.css';
// import './FormularioClinica.css'

// const FormularioClinica = () => {
//   return (
//     <div>
//       {/* <nav className="responsive-navbar">
//         <label id="label-dropdown-navbar-menu" htmlFor="checkbox-dropdown-navbar-menu">
//           <i className="material-icons navbar-menu-icon">
//             <span className="material-symbols-outlined">menu</span>
//           </i>
//         </label>
//         <input type="checkbox" id="checkbox-dropdown-navbar-menu" />
//         <ul>
//           <li><a href="index.html">Home</a></li>
//           <li><a href="formularioClinica.html">Bancos</a></li>
//           <li><a href="formularioClinica.html">Farmácias</a></li>
//           <li><a href="formularioClinica.html">Hospitais</a></li>
//           <li><a href="formularioClinica.html">Hotéis</a></li>
//           <li><a href="formularioClinica.html">Restaurantes</a></li>
//         </ul>
//       </nav> */}

//       <h1>Digite as informações sobre o tipo de clínica que você quer encontrar:</h1>

//       <form action="clinicas.html" method="get">
//         <div className="form-externa">
//           <div className="form-interna">
//             <label htmlFor="especialidade" className="titulo">Especialidade:</label><br />
//             <input type="text" id="especialidade" name="especialidade" required />
//           </div>
//           <div className="form-interna">
//             <label htmlFor="enderecoProximo" className="titulo">Próximo à localização:</label><br />
//             <input type="tel" id="enderecoProximo" name="enderecoProximo" required />
//           </div>
//           <div className="form-interna">
//             <label htmlFor="distancia" className="titulo">Distância máxima (em km):</label><br />
//             <input type="number" id="distancia" name="distancia" min="1" max="100" required />
//           </div>
//           <div className="form-interna">
//             <label className="titulo">Horário de funcionamento:</label><br />
//             <input type="radio" id="24h" name="horario" value="24h" />
//             <label htmlFor="24h">Aberto 24h</label><br />
//             <input type="radio" id="manha" name="horario" value="manha" />
//             <label htmlFor="manha">De manhã</label><br />
//             <input type="radio" id="tarde" name="horario" value="tarde" />
//             <label htmlFor="tarde">De tarde</label><br />
//             <input type="radio" id="noite" name="horario" value="noite" />
//             <label htmlFor="noite">De noite</label><br />
//             <input type="radio" id="madrugada" name="horario" value="madrugada" />
//             <label htmlFor="madrugada">De madrugada</label><br />
//             <input type="radio" id="qualquerHorario" name="horario" value="qualquerHorario" checked />
//             <label htmlFor="qualquerHorario">Qualquer horário</label>
//           </div>
//           <div className="form-interna">
//             <label className="titulo">Avaliação mínima:</label><br />
//             <input type="radio" id="umaEstrela" name="avaliacao" value="umaEstrela" />
//             <label htmlFor="umaEstrela">Uma estrela</label><br />
//             <input type="radio" id="duasEstrelas" name="avaliacao" value="duasEstrelas" />
//             <label htmlFor="duasEstrelas">Duas estrelas</label><br />
//             <input type="radio" id="tresEstrelas" name="avaliacao" value="tresEstrelas" />
//             <label htmlFor="tresEstrelas">Três estrelas</label><br />
//             <input type="radio" id="quatroEstrelas" name="avaliacao" value="quatroEstrelas" />
//             <label htmlFor="quatroEstrelas">Quatro estrelas</label><br />
//             <input type="radio" id="cincoEstrelas" name="avaliacao" value="cincoEstrelas" />
//             <label htmlFor="cincoEstrelas">Cinco estrelas</label><br />
//             <input type="radio" id="qualquerAvaliacao" name="avaliacao" value="qualquerAvaliacao" checked />
//             <label htmlFor="qualquerAvaliacao">Qualquer avaliação</label>
//           </div>
//           <div className="form-interna">
//             <label className="titulo">Convênio:</label><br />
//             <input type="checkbox" id="amil" name="amil" value="amil" />
//             <label htmlFor="amil">Amil</label><br />
//             <input type="checkbox" id="bradesco" name="bradesco" value="bradesco" />
//             <label htmlFor="bradesco">Bradesco</label><br />
//             <input type="checkbox" id="norden" name="norden" value="norden" />
//             <label htmlFor="norden">Norden</label><br />
//             <input type="checkbox" id="portoSeguro" name="portoSeguro" value="portoSeguro" />
//             <label htmlFor="portoSeguro">Porto Seguro</label><br />
//             <input type="checkbox" id="sulAmerica" name="sulAmerica" value="sulAmerica" />
//             <label htmlFor="sulAmerica">Sul América</label><br />
//             <input type="checkbox" id="unimed" name="unimed" value="unimed" />
//             <label htmlFor="unimed">Unimed</label>
//           </div>
//         </div>
//         <div className="botao">
//           <input type="submit" value="Enviar" id="enviar" />
//           <input type="reset" value="Limpar" id="limpar" />
//         </div>
//       </form>

//       <footer>
//         <div className="descricao">
//           Luggaris: escolha o tipo de estabelecimento que você quer encontrar para visualizar as localizações mais próximas de você!
//         </div>
//         <div className="copyright">
//           © 2024. Todos os direitos reservados.
//         </div>
//       </footer>
//     </div>
//   );
// };

// export default FormularioClinica;
