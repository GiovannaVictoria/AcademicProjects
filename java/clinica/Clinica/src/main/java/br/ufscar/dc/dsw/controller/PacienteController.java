package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.MedicoDAO;
import br.ufscar.dc.dsw.dao.PacienteDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Generos;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Papel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Sucesso;

@WebServlet(urlPatterns = "/paciente/*")
public class PacienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MedicoDAO medicoDao;
	private PacienteDAO pacienteDao;
	private UsuarioDAO usuarioDao;

	@Override
	public void init() {
		medicoDao = new MedicoDAO();
		pacienteDao = new PacienteDAO();
		usuarioDao = new UsuarioDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!usuario.getPapel().equals("ADMIN")) {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoAdmin");
			request.setAttribute("erros", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insere(request, response);
				break;
			case "/remocao":
				remove(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/atualizacao":
				atualize(request, response);
				break;
			default:
				lista(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}
	
	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Paciente> listaPacientes = pacienteDao.getAll();
		if (!listaPacientes.isEmpty()) {
			Collections.sort(listaPacientes, Ordenacao.PACIENTE_POR_NOME_CPF_DATANASCIMENTO_GENERO.getComparator());
			request.setAttribute("listaPacientes", listaPacientes);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("generos", Generos.values());
		request.setAttribute("papeis", Papel.values());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CPF = request.getParameter("CPF");
		Paciente paciente = pacienteDao.getByCPF(CPF);
		String login = paciente.getLogin();
		Usuario usuario = usuarioDao.getbyLogin(login);
		request.setAttribute("paciente", paciente);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", Generos.values());
		request.setAttribute("papeis", Papel.values());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		String CPF = request.getParameter("CPF");
		String login = request.getParameter("login");
		
		if (pacienteDao.getByCPF(CPF) != null) {
			erros.add("mensagem.usuarioNaoCadastrado");
			erros.add("mensagem.usuarioCPFDuplicado");
			request.setAttribute("erros", erros);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/lista.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if (pacienteDao.getByLogin(login) != null || medicoDao.getByLogin(login) != null) {
			erros.add("mensagem.usuarioNaoCadastrado");
			erros.add("mensagem.usuarioLoginDuplicado");
			request.setAttribute("erros", erros);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/lista.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		String dataNascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String papel = request.getParameter("papel");
		
		Usuario usuario = new Usuario(email, login, nome, papel, senha);
		Paciente paciente = new Paciente(CPF, dataNascimento, email, genero, login, nome, papel, senha, telefone);
		usuarioDao.insert(usuario);
		pacienteDao.insert(paciente);
		sucessos.add("mensagem.usuarioCadastrado");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		
		String CPF = request.getParameter("CPF");
		String dataNascimento = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String papel = request.getParameter("papel");
		
		Usuario usuario = new Usuario(email, login, nome, papel, senha);
		Paciente paciente = new Paciente(CPF, dataNascimento, email, genero, login, nome, papel, senha, telefone);
		usuarioDao.update(usuario);
		pacienteDao.update(paciente);
		sucessos.add("mensagem.usuarioAtualizado");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		
		String CPF = request.getParameter("CPF");
		Paciente paciente = pacienteDao.getByCPF(CPF);
		Usuario usuario = usuarioDao.getbyLogin(paciente.getLogin());
		
		usuarioDao.delete(usuario);
		pacienteDao.delete(paciente);
		sucessos.add("mensagem.usuarioRemovido");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/lista.jsp");
		dispatcher.forward(request, response);
	}
}