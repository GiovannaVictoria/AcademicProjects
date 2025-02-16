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
        <Link to="/formulario-clinica" className="botao-principal">Bancos</Link>
        <Link to="/formulario-clinica" className="botao-principal">Clínicas</Link>
        <Link to="/formulario-clinica" className="botao-principal">Farmácias</Link>
        <Link to="/formulario-clinica" className="botao-principal">Hospitais</Link>
        <Link to="/formulario-clinica" className="botao-principal">Hotéis</Link>
        <Link to="/formulario-clinica" className="botao-principal">Restaurantes</Link>
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
