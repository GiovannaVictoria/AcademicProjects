import { Link } from "react-router-dom";
import './Home.css';
// import './FormularioClinica.css'
// import "../index.css";

function Home() {
  return (
    <div>
      <header className="botao-titulo">
        <div className="nome">Luggaris</div>
      </header>

      <section className="botoes-principal">
        <div className="botao-principal">
          <Link to="/formulario-clinica">Bancos</Link>
        </div>
        <div className="botao-principal">
          <Link to="/formulario-clinica">Clínicas</Link>
        </div>
        <div className="botao-principal">
          <Link to="/formulario-clinica">Farmácias</Link>
        </div>
        <div className="botao-principal">
          <Link to="/formulario-clinica">Hospitais</Link>
        </div>
        <div className="botao-principal">
          <Link to="/formulario-clinica">Hotéis</Link>
        </div>
        <div className="botao-principal">
          <Link to="/formulario-clinica">Restaurantes</Link>
        </div>
      </section>

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
}

export default Home;
