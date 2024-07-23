package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.MedicoDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Especialidades;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/logout.jsp", "/listaGeralMedicos", "/listaEspecialidadeMedicos" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MedicoDAO medicoDao;

	@Override
	public void init() {
		medicoDao = new MedicoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "";
		String especialidade = "";
		
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("mensagem.loginNaoInformado");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("mensagem.senhaNaoInformada");
			}
			if (!erros.isExisteErros()) {
				UsuarioDAO dao = new UsuarioDAO();
				Usuario usuario = dao.getbyLogin(login);
				if (usuario != null) {
					if (usuario.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
						if (usuario.getPapel().equals("ADMIN")) {
							response.sendRedirect("admin/");
						} else {
							response.sendRedirect("usuario/");
						}
						return;
					} else {
						erros.add("mensagem.senhaInvalida");
					}
				} else {
					erros.add("mensagem.usuarioNaoEncontrado");
				}
			}
		}
		
		request.setAttribute("especialidades", Especialidades.values());
		action = request.getServletPath();

		try {
			switch (action) {
				case "/listaGeralMedicos":
					listaGeralMedicos(request, response);
					break;
				case "/listaEspecialidadeMedicos":
					especialidade = request.getParameter("especialidade");
					listaEspecialidadeMedicos(request, response, especialidade);
					break;
				default:
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
		
		request.getSession().invalidate();
		request.setAttribute("erros", erros);
		String URL = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}
	
	private void listaGeralMedicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> listaGeralMedicos = medicoDao.getAll();
		if (!listaGeralMedicos.isEmpty()) {
			Collections.sort(listaGeralMedicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
			request.setAttribute("listaGeralMedicos", listaGeralMedicos);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaGeralMedicos.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listaEspecialidadeMedicos(HttpServletRequest request, HttpServletResponse response, String especialidade) throws ServletException, IOException {
		List<Medico> listaGeralMedicos = medicoDao.getAll();
		List<Medico> listaFiltradaMedicos = new ArrayList<>();
		for (Medico medico : listaGeralMedicos) {
	        if (medico.getEspecialidade().equalsIgnoreCase(especialidade)) {
	            listaFiltradaMedicos.add(medico);
	        }
	    }
		if (!listaFiltradaMedicos.isEmpty()) {
			Collections.sort(listaFiltradaMedicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
			request.setAttribute("listaFiltradaMedicos", listaFiltradaMedicos);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEspecialidadeMedicos.jsp");
		dispatcher.forward(request, response);
	}
}