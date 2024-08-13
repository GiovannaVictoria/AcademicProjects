package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Especialidade;
import br.ufscar.dc.dsw.domain.Genero;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IMedicoDAO medicoDAO,
			IPacienteDAO pacienteDAO, IConsultaDAO consultaDAO) {
		return (args) -> {

			// Administradores
			
			Usuario u1 = new Usuario();
			u1.setUsername("admin1");
			u1.setPassword(encoder.encode("senhaadmin1"));
			u1.setEmail("admin1@org.br");
			u1.setName("Administrador 1");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);

			Usuario u2 = new Usuario();
			u2.setUsername("admin2");
			u2.setPassword(encoder.encode("senhaadmin2"));
			u2.setEmail("admin2@org.br");
			u2.setName("Administrador 2");
			u2.setRole("ROLE_ADMIN");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			// Médicos
			
			Medico m1 = new Medico();
			m1.setCRM("942864/AL");
			m1.setEmail("robertodesouza@gmail.com");
			m1.setEnabled(true);
			m1.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m1.setName("Roberto de Souza");
			m1.setPassword(encoder.encode("senhamedico1"));
			m1.setRole("ROLE_USER");
			m1.setUsername("medico1");
			medicoDAO.save(m1);

			Medico m2 = new Medico();
			m2.setCRM("184233/PB");
			m2.setEmail("fernandobarbosa@gmail.com");
			m2.setEnabled(true);
			m2.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m2.setName("Fernando Barbosa");
			m2.setPassword(encoder.encode("senhamedico2"));
			m2.setRole("ROLE_USER");
			m2.setUsername("medico2");
			medicoDAO.save(m2);

			Medico m3 = new Medico();
			m3.setCRM("995426/RN");
			m3.setEmail("sebastiaodecarvalho@gmail.com");
			m3.setEnabled(true);
			m3.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m3.setName("Sebastião de Carvalho");
			m3.setPassword(encoder.encode("senhamedico3"));
			m3.setRole("ROLE_USER");
			m3.setUsername("medico3");
			medicoDAO.save(m3);

			Medico m4 = new Medico();
			m4.setCRM("842615/GO");
			m4.setEmail("carladesouza@gmail.com");
			m4.setEnabled(true);
			m4.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m4.setName("Carla de Souza");
			m4.setPassword(encoder.encode("senhamedico4"));
			m4.setRole("ROLE_USER");
			m4.setUsername("medico4");
			medicoDAO.save(m4);

			Medico m5 = new Medico();
			m5.setCRM("152246/SE");
			m5.setEmail("mariaramos@gmail.com");
			m5.setEnabled(true);
			m5.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m5.setName("Maria Ramos");
			m5.setPassword(encoder.encode("senhamedico5"));
			m5.setRole("ROLE_USER");
			m5.setUsername("medico5");
			medicoDAO.save(m5);

			Medico m6 = new Medico();
			m6.setCRM("842695/SP");
			m6.setEmail("andreiadealmeida@gmail.com");
			m6.setEnabled(true);
			m6.setEspecialidade(Especialidade.DERMATOLOGIA.toString());
			m6.setName("Andréia de Almeida");
			m6.setPassword(encoder.encode("senhamedico6"));
			m6.setRole("ROLE_USER");
			m6.setUsername("medico6");
			medicoDAO.save(m6);

			Medico m7 = new Medico();
			m7.setCRM("100526/RJ");
			m7.setEmail("luisdasilva@gmail.com");
			m7.setEnabled(true);
			m7.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m7.setName("Luís da Silva");
			m7.setPassword(encoder.encode("senhamedico7"));
			m7.setRole("ROLE_USER");
			m7.setUsername("medico7");
			medicoDAO.save(m7);

			Medico m8 = new Medico();
			m8.setCRM("106539/DF");
			m8.setEmail("thiagosilva@gmail.com");
			m8.setEnabled(true);
			m8.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m8.setName("Thiago Silva");
			m8.setPassword(encoder.encode("senhamedico8"));
			m8.setRole("ROLE_USER");
			m8.setUsername("medico8");
			medicoDAO.save(m8);

			Medico m9 = new Medico();
			m9.setCRM("548924/PR");
			m9.setEmail("joaosantos@gmail.com");
			m9.setEnabled(true);
			m9.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m9.setName("João Santos");
			m9.setPassword(encoder.encode("senhamedico9"));
			m9.setRole("ROLE_USER");
			m9.setUsername("medico9");
			medicoDAO.save(m9);

			Medico m10 = new Medico();
			m10.setCRM("542863/AP");
			m10.setEmail("gabrielasoares@gmail.com");
			m10.setEnabled(true);
			m10.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m10.setName("Gabriela Soares");
			m10.setPassword(encoder.encode("senhamedico10"));
			m10.setRole("ROLE_USER");
			m10.setUsername("medico10");
			medicoDAO.save(m10);

			Medico m11 = new Medico();
			m11.setCRM("826340/SP");
			m11.setEmail("alinenascimento@gmail.com");
			m11.setEnabled(true);
			m11.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m11.setName("Aline Nascimento");
			m11.setPassword(encoder.encode("senhamedico11"));
			m11.setRole("ROLE_USER");
			m11.setUsername("medico11");
			medicoDAO.save(m11);

			Medico m12 = new Medico();
			m12.setCRM("248379/RJ");
			m12.setEmail("camiladealmeida@gmail.com");
			m12.setEnabled(true);
			m12.setEspecialidade(Especialidade.CARDIOLOGIA.toString());
			m12.setName("Camila de Almeida");
			m12.setPassword(encoder.encode("senhamedico12"));
			m12.setRole("ROLE_USER");
			m12.setUsername("medico12");
			medicoDAO.save(m12);

			Medico m13 = new Medico();
			m13.setCRM("342852/BA");
			m13.setEmail("pedrosantana@gmail.com");
			m13.setEnabled(true);
			m13.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m13.setName("Pedro Santana");
			m13.setPassword(encoder.encode("senhamedico13"));
			m13.setRole("ROLE_USER");
			m13.setUsername("medico13");
			medicoDAO.save(m13);

			Medico m14 = new Medico();
			m14.setCRM("824915/MG");
			m14.setEmail("guilhermemarques@gmail.com");
			m14.setEnabled(true);
			m14.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m14.setName("Guilherme Marques");
			m14.setPassword(encoder.encode("senhamedico14"));
			m14.setRole("ROLE_USER");
			m14.setUsername("medico14");
			medicoDAO.save(m14);

			Medico m15 = new Medico();
			m15.setCRM("943825/RS");
			m15.setEmail("fernandomarques@gmail.com");
			m15.setEnabled(true);
			m15.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m15.setName("Fernando Marques");
			m15.setPassword(encoder.encode("senhamedico15"));
			m15.setRole("ROLE_USER");
			m15.setUsername("medico15");
			medicoDAO.save(m15);

			Medico m16 = new Medico();
			m16.setCRM("334056/PA");
			m16.setEmail("vanessaalmeida@gmail.com");
			m16.setEnabled(true);
			m16.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m16.setName("Vanessa Almeida");
			m16.setPassword(encoder.encode("senhamedico16"));
			m16.setRole("ROLE_USER");
			m16.setUsername("medico16");
			medicoDAO.save(m16);

			Medico m17 = new Medico();
			m17.setCRM("322841/PR");
			m17.setEmail("lucianabarbosa@gmail.com");
			m17.setEnabled(true);
			m17.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m17.setName("Luciana Barbosa");
			m17.setPassword(encoder.encode("senhamedico17"));
			m17.setRole("ROLE_USER");
			m17.setUsername("medico17");
			medicoDAO.save(m17);

			Medico m18 = new Medico();
			m18.setCRM("635995/MS");
			m18.setEmail("josefadesousa@gmail.com");
			m18.setEnabled(true);
			m18.setEspecialidade(Especialidade.ACUPUNTURA.toString());
			m18.setName("Josefa de Sousa");
			m18.setPassword(encoder.encode("senhamedico18"));
			m18.setRole("ROLE_USER");
			m18.setUsername("medico18");
			medicoDAO.save(m18);

			Medico m19 = new Medico();
			m19.setCRM("615248/TO");
			m19.setEmail("geraldodearaujo@gmail.com");
			m19.setEnabled(true);
			m19.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m19.setName("Geraldo de Araujo");
			m19.setPassword(encoder.encode("senhamedico19"));
			m19.setRole("ROLE_USER");
			m19.setUsername("medico19");
			medicoDAO.save(m19);

			Medico m20 = new Medico();
			m20.setCRM("352855/AM");
			m20.setEmail("manoelalves@gmail.com");
			m20.setEnabled(true);
			m20.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m20.setName("Manoel Alves");
			m20.setPassword(encoder.encode("senhamedico20"));
			m20.setRole("ROLE_USER");
			m20.setUsername("medico20");
			medicoDAO.save(m20);

			Medico m21 = new Medico();
			m21.setCRM("310823/AC");
			m21.setEmail("rodrigosantana@gmail.com");
			m21.setEnabled(true);
			m21.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m21.setName("Rodrigo Santana");
			m21.setPassword(encoder.encode("senhamedico21"));
			m21.setRole("ROLE_USER");
			m21.setUsername("medico21");
			medicoDAO.save(m21);

			Medico m22 = new Medico();
			m22.setCRM("672331/PE");
			m22.setEmail("luciabatista@gmail.com");
			m22.setEnabled(true);
			m22.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m22.setName("Lúcia Batista");
			m22.setPassword(encoder.encode("senhamedico22"));
			m22.setRole("ROLE_USER");
			m22.setUsername("medico22");
			medicoDAO.save(m22);

			Medico m23 = new Medico();
			m23.setCRM("005624/MA");
			m23.setEmail("deboracarvalho@gmail.com");
			m23.setEnabled(true);
			m23.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m23.setName("Débora Carvalho");
			m23.setPassword(encoder.encode("senhamedico23"));
			m23.setRole("ROLE_USER");
			m23.setUsername("medico23");
			medicoDAO.save(m23);

			Medico m24 = new Medico();
			m24.setCRM("511249/RR");
			m24.setEmail("gabrielateixeira@gmail.com");
			m24.setEnabled(true);
			m24.setEspecialidade(Especialidade.ENDOCRINOLOGIA_E_METABOLOGIA.toString());
			m24.setName("Gabriela Teixeira");
			m24.setPassword(encoder.encode("senhamedico24"));
			m24.setRole("ROLE_USER");
			m24.setUsername("medico24");
			medicoDAO.save(m24);

			Medico m25 = new Medico();
			m25.setCRM("955736/RO");
			m25.setEmail("sergiorodrigues@gmail.com");
			m25.setEnabled(true);
			m25.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m25.setName("Sérgio Rodrigues");
			m25.setPassword(encoder.encode("senhamedico25"));
			m25.setRole("ROLE_USER");
			m25.setUsername("medico25");
			medicoDAO.save(m25);

			Medico m26 = new Medico();
			m26.setCRM("351885/ES");
			m26.setEmail("renatodossantos@gmail.com");
			m26.setEnabled(true);
			m26.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m26.setName("Renato dos Santos");
			m26.setPassword(encoder.encode("senhamedico26"));
			m26.setRole("ROLE_USER");
			m26.setUsername("medico26");
			medicoDAO.save(m26);

			Medico m27 = new Medico();
			m27.setCRM("726115/MT");
			m27.setEmail("eduardofernandes@gmail.com");
			m27.setEnabled(true);
			m27.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m27.setName("Eduardo Fernandes");
			m27.setPassword(encoder.encode("senhamedico27"));
			m27.setRole("ROLE_USER");
			m27.setUsername("medico27");
			medicoDAO.save(m27);

			Medico m28 = new Medico();
			m28.setCRM("152944/SC");
			m28.setEmail("vitoriadias@gmail.com");
			m28.setEnabled(true);
			m28.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m28.setName("Vitória Dias");
			m28.setPassword(encoder.encode("senhamedico28"));
			m28.setRole("ROLE_USER");
			m28.setUsername("medico28");
			medicoDAO.save(m28);

			Medico m29 = new Medico();
			m29.setCRM("874653/PI");
			m29.setEmail("rosanunes@gmail.com");
			m29.setEnabled(true);
			m29.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m29.setName("Rosa Nunes");
			m29.setPassword(encoder.encode("senhamedico29"));
			m29.setRole("ROLE_USER");
			m29.setUsername("medico29");
			medicoDAO.save(m29);

			Medico m30 = new Medico();
			m30.setCRM("426851/CE");
			m30.setEmail("soniaalmeida@gmail.com");
			m30.setEnabled(true);
			m30.setEspecialidade(Especialidade.GASTROENTEROLOGIA.toString());
			m30.setName("Sônia Almeida");
			m30.setPassword(encoder.encode("senhamedico30"));
			m30.setRole("ROLE_USER");
			m30.setUsername("medico30");
			medicoDAO.save(m30);
			
			// Pacientes
			
			Paciente p1 = new Paciente();
			p1.setCPF("152.322.641-10");
			p1.setDataNascimento("2001-01-01");
			p1.setEmail("vitordesousa@gmail.com");
			p1.setEnabled(true);
			p1.setGenero(Genero.M.toString());
			p1.setName("Vítor de Sousa");
			p1.setPassword(encoder.encode("senhapaciente1"));
			p1.setRole("ROLE_USER");
			p1.setTelefone("(81)97355-8221");
			p1.setUsername("paciente1");
			pacienteDAO.save(p1);

			Paciente p2 = new Paciente();
			p2.setCPF("429.215.384-76");
			p2.setDataNascimento("2002-02-02");
			p2.setEmail("lucascosta@gmail.com");
			p2.setEnabled(true);
			p2.setGenero(Genero.M.toString());
			p2.setName("Lucas Costa");
			p2.setPassword(encoder.encode("senhapaciente2"));
			p2.setRole("ROLE_USER");
			p2.setTelefone("(13)94751-5233");
			p2.setUsername("paciente2");
			pacienteDAO.save(p2);

			Paciente p3 = new Paciente();
			p3.setCPF("442.625.153-88");
			p3.setDataNascimento("2003-03-03");
			p3.setEmail("fabiovieira@gmail.com");
			p3.setEnabled(true);
			p3.setGenero(Genero.M.toString());
			p3.setName("Fábio Vieira");
			p3.setPassword(encoder.encode("senhapaciente3"));
			p3.setRole("ROLE_USER");
			p3.setTelefone("(19)95524-9653");
			p3.setUsername("paciente3");
			pacienteDAO.save(p3);

			Paciente p4 = new Paciente();
			p4.setCPF("763.248.615-55");
			p4.setDataNascimento("2004-04-04");
			p4.setEmail("sergiodossantos@gmail.com");
			p4.setEnabled(true);
			p4.setGenero(Genero.M.toString());
			p4.setName("Sérgio dos Santos");
			p4.setPassword(encoder.encode("senhapaciente4"));
			p4.setRole("ROLE_USER");
			p4.setTelefone("(21)96488-0423");
			p4.setUsername("paciente4");
			pacienteDAO.save(p4);

			Paciente p5 = new Paciente();
			p5.setCPF("942.615.320-81");
			p5.setDataNascimento("2005-05-05");
			p5.setEmail("joaodeoliveira@gmail.com");
			p5.setEnabled(true);
			p5.setGenero(Genero.M.toString());
			p5.setName("João de Oliveira");
			p5.setPassword(encoder.encode("senhapaciente5"));
			p5.setRole("ROLE_USER");
			p5.setTelefone("(27)97102-5124");
			p5.setUsername("paciente5");
			pacienteDAO.save(p5);

			Paciente p6 = new Paciente();
			p6.setCPF("152.342.615.82");
			p6.setDataNascimento("2006-06-06");
			p6.setEmail("raquelrodrigues@gmail.com");
			p6.setEnabled(true);
			p6.setGenero(Genero.F.toString());
			p6.setName("Raquel Rodrigues");
			p6.setPassword(encoder.encode("senhapaciente6"));
			p6.setRole("ROLE_USER");
			p6.setTelefone("(32)98144-8364");
			p6.setUsername("paciente6");
			pacienteDAO.save(p6);

			Paciente p7 = new Paciente();
			p7.setCPF("156.931.526-84");
			p7.setDataNascimento("2007-07-07");
			p7.setEmail("simonerocha@gmail.com");
			p7.setEnabled(true);
			p7.setGenero(Genero.F.toString());
			p7.setName("Simone Rocha");
			p7.setPassword(encoder.encode("senhapaciente7"));
			p7.setRole("ROLE_USER");
			p7.setTelefone("(49)94155-7525");
			p7.setUsername("paciente7");
			pacienteDAO.save(p7);

			Paciente p8 = new Paciente();
			p8.setCPF("426.153.286-50");
			p8.setDataNascimento("2008-08-08");
			p8.setEmail("brunalopes@gmail.com");
			p8.setEnabled(true);
			p8.setGenero(Genero.F.toString());
			p8.setName("Bruna Lopes");
			p8.setPassword(encoder.encode("senhapaciente8"));
			p8.setRole("ROLE_USER");
			p8.setTelefone("(58)94221-8253");
			p8.setUsername("paciente8");
			pacienteDAO.save(p8);

			Paciente p9 = new Paciente();
			p9.setCPF("816.420.301-82");
			p9.setDataNascimento("2009-09-09");
			p9.setEmail("larissadacosta@gmail.com");
			p9.setEnabled(true);
			p9.setGenero(Genero.F.toString());
			p9.setName("Larissa da Costa");
			p9.setPassword(encoder.encode("senhapaciente9"));
			p9.setRole("ROLE_USER");
			p9.setTelefone("(63)95428-8422");
			p9.setUsername("paciente9");
			pacienteDAO.save(p9);

			Paciente p10 = new Paciente();
			p10.setCPF("516.234.526-81");
			p10.setDataNascimento("2010-10-10");
			p10.setEmail("raquelsoares@gmail.com");
			p10.setEnabled(true);
			p10.setGenero(Genero.F.toString());
			p10.setName("Raquel Soares");
			p10.setPassword(encoder.encode("senhapaciente10"));
			p10.setRole("ROLE_USER");
			p10.setTelefone("(72)98425-6435");
			p10.setUsername("paciente10");
			pacienteDAO.save(p10);

		};
	}
}
