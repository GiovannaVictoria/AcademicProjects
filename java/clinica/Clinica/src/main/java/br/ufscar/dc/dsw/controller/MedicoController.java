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
import br.ufscar.dc.dsw.domain.Especialidades;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Papel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Sucesso;

@WebServlet(urlPatterns = "/medico/*")
public class MedicoController extends HttpServlet {

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
		List<Medico> listaMedicos = medicoDao.getAll();
		if (!listaMedicos.isEmpty()) {
			Collections.sort(listaMedicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
			request.setAttribute("listaMedicos", listaMedicos);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("especialidades", Especialidades.values());
		request.setAttribute("papeis", Papel.values());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CRM = request.getParameter("CRM");
		Medico medico = medicoDao.getByCRM(CRM);
		String login = medico.getLogin();
		Usuario usuario = usuarioDao.getbyLogin(login);
		request.setAttribute("medico", medico);
		request.setAttribute("usuario", usuario);
		request.setAttribute("especialidades", Especialidades.values());
		request.setAttribute("papeis", Papel.values());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		String CRM = request.getParameter("CRM");
		String login = request.getParameter("login");
		
		if (medicoDao.getByCRM(CRM) != null) {
			erros.add("mensagem.usuarioNaoCadastrado");
			erros.add("mensagem.usuarioCRMDuplicado");
			request.setAttribute("erros", erros);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/lista.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if (medicoDao.getByLogin(login) != null || pacienteDao.getByLogin(login) != null) {
			erros.add("mensagem.usuarioNaoCadastrado");
			erros.add("mensagem.usuarioLoginDuplicado");
			request.setAttribute("erros", erros);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/lista.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		String email = request.getParameter("email");
		String especialidade = request.getParameter("especialidade");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String papel = request.getParameter("papel");

		Usuario usuario = new Usuario(email, login, nome, papel, senha);
		Medico medico = new Medico(CRM, email, especialidade, login, nome, papel, senha);
		usuarioDao.insert(usuario);
		medicoDao.insert(medico);
		sucessos.add("mensagem.usuarioCadastrado");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		
		String CRM = request.getParameter("CRM");
		String email = request.getParameter("email");
		String especialidade = request.getParameter("especialidade");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String papel = request.getParameter("papel");

		Usuario usuario = new Usuario(email, login, nome, papel, senha);
		Medico medico = new Medico(CRM, email, especialidade, login, nome, papel, senha);
		usuarioDao.update(usuario);
		medicoDao.update(medico);
		sucessos.add("mensagem.usuarioAtualizado");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		
		String CRM = request.getParameter("CRM");
		Medico medico = medicoDao.getByCRM(CRM);
		Usuario usuario = usuarioDao.getbyLogin(medico.getLogin());
		
		medicoDao.delete(medico);
		usuarioDao.delete(usuario);
		sucessos.add("mensagem.usuarioRemovido");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/lista.jsp");
		dispatcher.forward(request, response);
		
	}
}