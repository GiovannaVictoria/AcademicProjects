import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      {/* Cabeçalho */}
      <header className="botao-titulo">
        <div className="nome">Luggaris</div>
      </header>

      {/* Botões principais */}
      <section className="botoes-principal">
        <div className="botao-principal">
          <a href="formularioClinica.html">Bancos</a>
        </div>
        <div className="botao-principal">
          <a href="formularioClinica.html">Clínicas</a>
        </div>
        <div className="botao-principal">
          <a href="formularioClinica.html">Farmácias</a>
        </div>
        <div className="botao-principal">
          <a href="formularioClinica.html">Hospitais</a>
        </div>
        <div className="botao-principal">
          <a href="formularioClinica.html">Hotéis</a>
        </div>
        <div className="botao-principal">
          <a href="formularioClinica.html">Restaurantes</a>
        </div>
      </section>

      {/* Rodapé */}
      <footer>
        <div className="descricao">
          Luggaris: escolha o tipo de estabelecimento que você quer encontrar para visualizar as localizações mais próximas de você!
        </div>
        <div className="copyright">
          © 2024. Todos os direitos reservados.
        </div>
      </footer>
    </div>
  );

  // return (
    // <>
      {/* <div> */}
        {/* <a href="https://vite.dev" target="_blank"> */}
          {/* <img src={viteLogo} className="logo" alt="Vite logo" /> */}
        {/* </a> */}
        {/* <a href="https://react.dev" target="_blank"> */}
          {/* <img src={reactLogo} className="logo react" alt="React logo" /> */}
        {/* </a> */}
      {/* </div> */}
      {/* <h1>Vite + React</h1> */}
      {/* <div className="card"> */}
        {/* <button onClick={() => setCount((count) => count + 1)}> */}
          {/* count is {count} */}
        {/* </button> */}
        {/* <p> */}
          {/* Edit <code>src/App.jsx</code> and save to test HMR */}
        {/* </p> */}
      {/* </div> */}
      {/* <p className="read-the-docs"> */}
        {/* Click on the Vite and React logos to learn more */}
      {/* </p> */}
    {/* </> */}
  // )
}

export default App
