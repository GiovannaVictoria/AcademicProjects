import React, { useState } from 'react';
import './FormularioClinica.css';
import ListaClinicas from '../components/ListaClinicas';
import Localizacao from "./Localizacao";

const FormularioClinica = () => {
  const [latitude, setLatitude] = useState(undefined);
  const [longitude, setLongitude] = useState(undefined);
  const [distancia, setDistancia] = useState(undefined);
  const [especialidade, setEspecialidade] = useState(undefined);
  const [clinicas, setClinicas] = useState([]);
  const [horario, setHorario] = useState([]);
  const [aberto24h, setAberto24h] = useState(false);
  const [avaliacao, setAvaliacao] = useState(1);
  const [convenio, setConvenio] = useState([]);
  const [endereco, setEndereco] = useState("");
  const horariosOpcoes = ['manha', 'tarde', 'noite', 'madrugada'];

  const handleLatitudeChange = (event) => setLatitude(event.target.value);
  const handleLongitudeChange = (event) => setLongitude(event.target.value);
  const handleDistanciaChange = (event) => setDistancia(event.target.value);
  const handleEspecialidadeChange = (event) => setEspecialidade(event.target.value);
  const handleAvaliacaoChange = (event) => setAvaliacao(Number(event.target.value));
  const handleEnderecoChange = (event) => setEndereco(event.target.value);

  const handleConvenioChange = (e) => {
    const { value, checked } = e.target;
    setConvenio(prevConvenio => {
      if (checked) {
        return [...prevConvenio, value];
      } else {
        return prevConvenio.filter(item => item !== value);
      }
    });
  };

  const handleHorarioChange = (e) => {
    const { value, checked } = e.target;
    setHorario((prevHorario) => {
      let newHorario;
      if (checked) {
        newHorario = [...prevHorario, value];
      } else {
        newHorario = prevHorario.filter((item) => item !== value);
      }
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
      setHorario(['manha', 'tarde', 'noite', 'madrugada']);
    } else {
      setHorario([]);
    }
  };

  const buscarClinicas = async (event) => {
    event.preventDefault();
    const url = `http://localhost:5000/clinicas`;

    try {
      const resposta = await fetch(url);
      if (!resposta.ok) throw new Error('Erro ao buscar clínicas');
      const dados = await resposta.json();
      setClinicas(dados);
    } catch (erro) {
      alert('Erro ao buscar clínicas: ' + erro.message);
    }
  };

  return (
    <div>
      {/* <nav className="responsive-navbar">
        <label id="label-dropdown-navbar-menu" htmlFor="checkbox-dropdown-navbar-menu">
          <i className="material-icons navbar-menu-icon">
            <span className="material-symbols-outlined">menu</span>
          </i>
        </label>
        <input type="checkbox" id="checkbox-dropdown-navbar-menu" />
        <ul>
          <li><a href="index.html">Home</a></li>
          <li><a href="formularioClinica.html">Bancos</a></li>
          <li><a href="formularioClinica.html">Farmácias</a></li>
          <li><a href="formularioClinica.html">Hospitais</a></li>
          <li><a href="formularioClinica.html">Hotéis</a></li>
          <li><a href="formularioClinica.html">Restaurantes</a></li>
        </ul>
      </nav> */}

      <div>
        <h1 className="descricao-formulario">Digite as informações sobre o tipo de clínica que você quer encontrar:</h1>
      </div>

      <form onSubmit={buscarClinicas}>

        <div className="form-externa">

          <div className="textos-inputs">
            <label htmlFor="especialidade" className="titulo">Especialidade:</label>
            <input
              type="text"
              id="especialidade"
              name="especialidade"
              onChange={handleEspecialidadeChange}
              required />
          </div>

          <div className="textos-inputs">

            <label htmlFor="latitude" className="titulo">Latitude:</label>
            <input
              type="number"
              id="latitude"
              name="latitude"
              step="any"
              value={latitude}
              onChange={handleLatitudeChange}
              required />
            

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

            <label htmlFor="endereco" className="titulo">Endereço:</label><br />
            <input
              type="text"
              id="endereco"
              name="endereco"
              value={endereco || "Nenhum endereço encontrado"}
              onChange={handleEnderecoChange}
              required />
            <br></br>

            <Localizacao setLatitude={setLatitude} setLongitude={setLongitude} setEndereco={setEndereco} />
          </div>

          <div className="textos-inputs">
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

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="aberto24h"
                name="horario"
                checked={aberto24h}
                onChange={handleAberto24hChange}
              />
              <label className="opcao" htmlFor="aberto24h">Aberto 24h</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="manha"
                name="horario"
                value="manha"
                checked={horario.includes('manhã')}
                onChange={handleHorarioChange}
              />
              <label className="opcao" htmlFor="manha">Manhã</label>
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="tarde"
                name="horario"
                value="tarde"
                checked={horario.includes('tarde')}
                onChange={handleHorarioChange}
              />
              <label className="opcao" htmlFor="tarde">Tarde</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="noite"
                name="horario"
                value="noite"
                checked={horario.includes('noite')}
                onChange={handleHorarioChange}
              />
              <label className="opcao" htmlFor="noite">Noite</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="madrugada"
                name="horario"
                value="madrugada"
                checked={horario.includes('madrugada')}
                onChange={handleHorarioChange}
              />
              <label className="opcao" htmlFor="madrugada">Madrugada</label><br />
            </div>
          </div>

          <div className="form-interna">
            <label className="titulo">Avaliação mínima:</label><br />

            <div className="opcoes-inputs">
              <input
                type="radio"
                id="umaEstrela"
                name="avaliacao"
                value={1}
                checked={avaliacao === 1}
                onChange={handleAvaliacaoChange} />
              <label className="opcao" htmlFor="umaEstrela">Uma estrela</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="radio"
                id="duasEstrelas"
                name="avaliacao"
                value={2}
                checked={avaliacao === 2}
                onChange={handleAvaliacaoChange} />
              <label className="opcao" htmlFor="duasEstrelas">Duas estrelas</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="radio"
                id="tresEstrelas"
                name="avaliacao"
                value={3}
                checked={avaliacao === 3}
                onChange={handleAvaliacaoChange} />
              <label className="opcao" htmlFor="tresEstrelas">Três estrelas</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="radio"
                id="quatroEstrelas"
                name="avaliacao"
                value={4}
                checked={avaliacao === 4}
                onChange={handleAvaliacaoChange} />
              <label className="opcao" htmlFor="quatroEstrelas">Quatro estrelas</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="radio"
                id="cincoEstrelas"
                name="avaliacao"
                value={5}
                checked={avaliacao === 5}
                onChange={handleAvaliacaoChange} />
              <label className="opcao" htmlFor="cincoEstrelas">Cinco estrelas</label><br />
            </div>

          </div>

          <div className="form-interna">
            <label className="titulo">Convênio:</label><br />

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="amil"
                name="convenio"
                value="amil"
                checked={convenio.includes('Amil')}
                onChange={handleConvenioChange}
              />
              <label className="opcao" htmlFor="amil">Amil</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="bradesco"
                name="convenio"
                value="bradesco"
                checked={convenio.includes('Bradesco')}
                onChange={handleConvenioChange}
              />
              <label className="opcao" htmlFor="bradesco">Bradesco</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="norden"
                name="convenio"
                value="norden"
                checked={convenio.includes('Norden')}
                onChange={handleConvenioChange}
              />
              <label className="opcao" htmlFor="norden">Norden</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="portoSeguro"
                name="convenio"
                value="portoSeguro"
                checked={convenio.includes('Porto Seguro')}
                onChange={handleConvenioChange}
              />
              <label className="opcao" htmlFor="portoSeguro">Porto Seguro</label><br />
            </div>

            <div className="opcoes-inputs">
              <input
                type="checkbox"
                id="unimed"
                name="convenio"
                value="unimed"
                checked={convenio.includes('Unimed')}
                onChange={handleConvenioChange}
              />
              <label className="opcao" htmlFor="unimed">Unimed</label><br />
            </div>

          </div>

        </div>

        <span className="botao">
          <input className="botao-form" type="submit" value="Buscar Clínicas" />
        </span>

      </form>

      {clinicas.length > 0 && <ListaClinicas latitude={latitude} longitude={longitude} distancia={distancia} especialidade={especialidade} clinicas={clinicas} horario={horario} avaliacao={avaliacao} convenio={convenio} />}

      <footer className="footer-home">
        <div className="descricao">
          Luggaris: escolha o tipo de estabelecimento que você quer encontrar para visualizar as localizações mais próximas de você!
        </div>
        <div className="copyright">
          © 2024. Todos os direitos reservados.
        </div>
      </footer>

    </div>
  );
};

export default FormularioClinica;
