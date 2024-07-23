package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.dao.MedicoDAO;
import br.ufscar.dc.dsw.dao.PacienteDAO;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Hora;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Sucesso;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/consulta/*")
public class ConsultaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConsultaDAO consultaDao;
	private MedicoDAO medicoDao;
	private PacienteDAO pacienteDao;

	@Override
	public void init() {
		consultaDao = new ConsultaDAO();
		medicoDao = new MedicoDAO();
		pacienteDao = new PacienteDAO();
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
		} else if (!usuario.getPapel().equals("USER")) {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoUsuarioGeral");
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
			case "/listaConsultasPaciente":
				listaConsultasPaciente(request, response);
				break;
			case "/listaConsultasMedico":
				listaConsultasMedico(request, response);
				break;
			default:
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}
	
	private void listaConsultasPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String login = request.getParameter("login");
		
		if (!usuario.getLogin().equals(login)) {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoUsuarioDono");
			request.setAttribute("erros", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
		
		Paciente paciente = pacienteDao.getByLogin(login);
		List<Consulta> listaConsultas = consultaDao.getAllByPatient(paciente.getCPF());
		if (!listaConsultas.isEmpty()) {
			Collections.sort(listaConsultas, Ordenacao.CONSULTA_POR_HORARIO_NOMEPACIENTE_CPF_NOMEMEDICO_CRM_ESPECIALIDADE.getComparator());
			request.setAttribute("listaConsultas", listaConsultas);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/paciente/listaConsultasPaciente.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listaConsultasMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String login = request.getParameter("login");
		
		if (!usuario.getLogin().equals(login)) {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoUsuarioDono");
			request.setAttribute("erros", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
		
		Medico medico = medicoDao.getByLogin(login);
		List<Consulta> listaConsultas = consultaDao.getAllByDoctor(medico.getCRM());
		if (!listaConsultas.isEmpty()) {
			Collections.sort(listaConsultas, Ordenacao.CONSULTA_POR_HORARIO_NOMEPACIENTE_CPF_NOMEMEDICO_CRM_ESPECIALIDADE.getComparator());
			request.setAttribute("listaConsultas", listaConsultas);
		}
		request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/medico/listaConsultasMedico.jsp");
		dispatcher.forward(request, response);
	}
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		List<Medico> listaMedicos = medicoDao.getAll();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String login = request.getParameter("login");
		Paciente paciente = pacienteDao.getByLogin(login);
		
		if (!usuario.getLogin().equals(login)) {
			erros.add("mensagem.acessoNaoAutorizado");
			erros.add("mensagem.acessoUsuarioDono");
			request.setAttribute("erros", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
		}
		
		request.setAttribute("horas", Hora.values());
		request.setAttribute("usuario", usuario);
		request.setAttribute("paciente", paciente);
		Collections.sort(listaMedicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
		request.setAttribute("listaMedicos", listaMedicos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/paciente/formularioConsulta.jsp");
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro(request.getSession().getAttribute("userLocale").toString());
		Sucesso sucessos = new Sucesso(request.getSession().getAttribute("userLocale").toString());
		request.setCharacterEncoding("UTF-8");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String login = usuario.getLogin();
		Paciente paciente = pacienteDao.getByLogin(login);
		String CPF = paciente.getCPF();
		String CRM = request.getParameter("CRM");
		Medico medico = medicoDao.getByCRM(CRM);
		String hora = request.getParameter("hora");
		String data = request.getParameter("data");
		String horario = data + " " + hora;
		
		List<Consulta> listaConsultas = consultaDao.getAllByDateTime(horario);
		if (!listaConsultas.isEmpty()) {
			for (Consulta c : listaConsultas) {
				if (c.getCPF().equals(CPF)) {
					erros.add("mensagem.consultaNaoAgendada");
					erros.add("mensagem.conflitoHorarioPaciente");
					request.setAttribute("erros", erros);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/paciente/index.jsp");
					dispatcher.forward(request, response);
					return;
				}
				if (c.getCRM().equals(CRM)) {
					erros.add("mensagem.consultaNaoAgendada");
					erros.add("mensagem.conflitoHorarioMedico");
					request.setAttribute("erros", erros);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/paciente/index.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}
		}
		
		Consulta consulta = new Consulta(CPF, CRM, medico.getEspecialidade(), medico.getNome(), paciente.getNome(), horario);
		consultaDao.insert(consulta);
		sucessos.add("mensagem.consultaAgendada");
		sucessos.add("mensagem.confirmacaoEmail");
		request.setAttribute("sucessos", sucessos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/paciente/index.jsp");
		dispatcher.forward(request, response);
	}

}