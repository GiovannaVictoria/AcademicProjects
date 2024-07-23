package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		
		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
		} else if (usuario.getPapel().equals("ADMIN")) {
			
			String action = request.getPathInfo();
			if (action == null) {
				action = "";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
			dispatcher.forward(request, response);
		} else {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoAdmin");
			request.setAttribute("erros", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
	}
	
}