drop database if exists Clinica;

create database Clinica;
   
use Clinica

create table Usuario(
	login varchar(20) primary key,
	senha varchar(64) not null,
	papel varchar(64) not null,
	email varchar(256) not null unique,
	nome varchar(256) not null
);

create table Medico(
	CRM varchar(64) not null unique,
	email varchar(256) not null unique,
	especialidade varchar(256) not null,
	nome varchar(256) not null,
	login varchar(20) not null,
	senha varchar(64) not null,
	papel varchar(64) not null,
	foreign key (login) references Usuario(login)
		on delete cascade
		on update cascade
);

create table Paciente(
	CPF varchar(64) not null unique,
	dataNascimento date not null,
	email varchar(256) not null unique,
	genero varchar(256) not null,
	nome varchar(256) not null,
	telefone varchar(256) not null unique,
	login varchar(20) not null,
	senha varchar(64) not null,
	papel varchar(64) not null,
	foreign key (login) references Usuario(login)
		on delete cascade
		on update cascade
);

create table Consulta(
	protocolo bigint auto_increment primary key,
	CPF varchar(64) not null,
	CRM varchar(64) not null,
	especialidade varchar(256) not null,
	nomeMedico varchar(256) not null,
	nomePaciente varchar(256) not null,
	horario datetime not null
);

insert into Usuario(login, senha, papel, email, nome) values
 ('admin1', 'senhaadmin1', 'ADMIN', 'admin1@sistema.com', 'Administrador 1'),
 ('admin2', 'senhaadmin2', 'ADMIN', 'admin2@sistema.com', 'Administrador 2');

insert into Usuario(login, senha, papel, email, nome) values
 ('medico1', 'senhamedico1', 'USER', 'robertodesouza@gmail.com', 'Roberto de Souza'),
 ('medico2', 'senhamedico2', 'USER', 'fernandobarbosa@gmail.com', 'Fernando Barbosa'),
 ('medico3', 'senhamedico3', 'USER', 'sebastiaodecarvalho@gmail.com', 'Sebastião de Carvalho'),
 ('medico4', 'senhamedico4', 'USER', 'carladesouza@gmail.com', 'Carla de Souza'),
 ('medico5', 'senhamedico5', 'USER', 'mariaramos@gmail.com', 'Maria Ramos'),
 ('medico6', 'senhamedico6', 'USER', 'andreiadealmeida@gmail.com', 'Andréia de Almeida'),
 ('medico7', 'senhamedico7', 'USER', 'luisdasilva@gmail.com', 'Luís da Silva'),
 ('medico8', 'senhamedico8', 'USER', 'thiagosilva@gmail.com', 'Thiago Silva'),
 ('medico9', 'senhamedico9', 'USER', 'joaosantos@gmail.com', 'João Santos'),
 ('medico10', 'senhamedico10', 'USER', 'gabrielasoares@gmail.com', 'Gabriela Soares'),
 ('medico11', 'senhamedico11', 'USER', 'alinenascimento@gmail.com', 'Aline Nascimento'),
 ('medico12', 'senhamedico12', 'USER', 'camiladealmeida@gmail.com', 'Camila de Almeida'),
 ('medico13', 'senhamedico13', 'USER', 'pedrosantana@gmail.com', 'Pedro Santana'),
 ('medico14', 'senhamedico14', 'USER', 'guilhermemarques@gmail.com', 'Guilherme Marques'),
 ('medico15', 'senhamedico15', 'USER', 'fernandomarques@gmail.com', 'Fernando Marques'),
 ('medico16', 'senhamedico16', 'USER', 'vanessaalmeida@gmail.com', 'Vanessa Almeida'),
 ('medico17', 'senhamedico17', 'USER', 'lucianabarbosa@gmail.com', 'Luciana Barbosa'),
 ('medico18', 'senhamedico18', 'USER', 'josefadesousa@gmail.com', 'Josefa de Sousa'),
 ('medico19', 'senhamedico19', 'USER', 'geraldodearaujo@gmail.com', 'Geraldo de Araujo'),
 ('medico20', 'senhamedico20', 'USER', 'manoelalves@gmail.com', 'Manoel Alves'),
 ('medico21', 'senhamedico21', 'USER', 'rodrigosantana@gmail.com', 'Rodrigo Santana'),
 ('medico22', 'senhamedico22', 'USER', 'luciabatista@gmail.com', 'Lúcia Batista'),
 ('medico23', 'senhamedico23', 'USER', 'deboracarvalho@gmail.com', 'Débora Carvalho'),
 ('medico24', 'senhamedico24', 'USER', 'gabrielateixeira@gmail.com', 'Gabriela Teixeira'),
 ('medico25', 'senhamedico25', 'USER', 'sergiorodrigues@gmail.com', 'Sérgio Rodrigues'),
 ('medico26', 'senhamedico26', 'USER', 'renatodossantos@gmail.com', 'Renato dos Santos'),
 ('medico27', 'senhamedico27', 'USER', 'eduardofernandes@gmail.com', 'Eduardo Fernandes'),
 ('medico28', 'senhamedico28', 'USER', 'vitoriadias@gmail.com', 'Vitória Dias'),
 ('medico29', 'senhamedico29', 'USER', 'rosanunes@gmail.com', 'Rosa Nunes'),
 ('medico30', 'senhamedico30', 'USER', 'soniaalmeida@gmail.com', 'Sônia Almeida');

insert into Usuario(login, senha, papel, email, nome) values
 ('paciente1', 'senhapaciente1', 'USER', 'vitordesousa@gmail.com', 'Vítor de Sousa'),
 ('paciente2', 'senhapaciente2', 'USER', 'lucascosta@gmail.com', 'Lucas Costa'),
 ('paciente3', 'senhapaciente3', 'USER', 'fabiovieira@gmail.com', 'Fábio Vieira'),
 ('paciente4', 'senhapaciente4', 'USER', 'sergiodossantos@gmail.com', 'Sérgio dos Santos'),
 ('paciente5', 'senhapaciente5', 'USER', 'joaodeoliveira@gmail.com', 'João de Oliveira'),
 ('paciente6', 'senhapaciente6', 'USER', 'raquelrodrigues@gmail.com', 'Raquel Rodrigues'),
 ('paciente7', 'senhapaciente7', 'USER', 'simonerocha@gmail.com', 'Simone Rocha'),
 ('paciente8', 'senhapaciente8', 'USER', 'brunalopes@gmail.com', 'Bruna Lopes'),
 ('paciente9', 'senhapaciente9', 'USER', 'larissadacosta@gmail.com', 'Larissa da Costa'),
 ('paciente10', 'senhapaciente10', 'USER', 'raquelsoares@gmail.com', 'Raquel Soares');

insert into Medico(CRM, email, especialidade, nome, login, senha, papel) values
 ('942864/AL', 'robertodesouza@gmail.com', 'DERMATOLOGIA', 'Roberto de Souza', 'medico1', 'senhamedico1', 'USER'),
 ('184233/PB', 'fernandobarbosa@gmail.com', 'DERMATOLOGIA', 'Fernando Barbosa', 'medico2', 'senhamedico2', 'USER'),
 ('995426/RN', 'sebastiaodecarvalho@gmail.com', 'DERMATOLOGIA', 'Sebastião de Carvalho', 'medico3', 'senhamedico3', 'USER'),
 ('842615/GO', 'carladesouza@gmail.com', 'DERMATOLOGIA', 'Carla de Souza', 'medico4', 'senhamedico4', 'USER'),
 ('152246/SE', 'mariaramos@gmail.com', 'DERMATOLOGIA', 'Maria Ramos', 'medico5', 'senhamedico5', 'USER'),
 ('842695/SP', 'andreiadealmeida@gmail.com', 'DERMATOLOGIA', 'Andréia de Almeida', 'medico6', 'senhamedico6', 'USER'),
 ('100526/RJ', 'luisdasilva@gmail.com', 'CARDIOLOGIA', 'Luís da Silva','medico7', 'senhamedico7', 'USER'),
 ('106539/DF', 'thiagosilva@gmail.com', 'CARDIOLOGIA', 'Thiago Silva','medico8', 'senhamedico8', 'USER'),
 ('548924/PR', 'joaosantos@gmail.com', 'CARDIOLOGIA', 'João Santos','medico9', 'senhamedico9', 'USER'),
 ('542863/AP', 'gabrielasoares@gmail.com', 'CARDIOLOGIA', 'Gabriela Soares','medico10', 'senhamedico10', 'USER'),
 ('826340/SP', 'alinenascimento@gmail.com', 'CARDIOLOGIA', 'Aline Nascimento','medico11', 'senhamedico11', 'USER'),
 ('248379/RJ', 'camiladealmeida@gmail.com', 'CARDIOLOGIA', 'Camila de Almeida','medico12', 'senhamedico12', 'USER'),
 ('342852/BA', 'pedrosantana@gmail.com', 'ACUPUNTURA', 'Pedro Santana', 'medico13', 'senhamedico13', 'USER'),
 ('824915/MG', 'guilhermemarques@gmail.com', 'ACUPUNTURA', 'Guilherme Marques', 'medico14', 'senhamedico14', 'USER'),
 ('943825/RS', 'fernandomarques@gmail.com', 'ACUPUNTURA', 'Fernando Marques', 'medico15', 'senhamedico15', 'USER'),
 ('334056/PA', 'vanessaalmeida@gmail.com', 'ACUPUNTURA', 'Vanessa Almeida', 'medico16', 'senhamedico16', 'USER'),
 ('322841/PR', 'lucianabarbosa@gmail.com', 'ACUPUNTURA', 'Luciana Barbosa', 'medico17', 'senhamedico17', 'USER'),
 ('635995/MS', 'josefadesousa@gmail.com', 'ACUPUNTURA', 'Josefa de Sousa', 'medico18', 'senhamedico18', 'USER'),
 ('615248/TO', 'geraldodearaujo@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Geraldo de Araujo', 'medico19', 'senhamedico19', 'USER'),
 ('352855/AM', 'manoelalves@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Manoel Alves', 'medico20', 'senhamedico20', 'USER'),
 ('310823/AC', 'rodrigosantana@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Rodrigo Santana', 'medico21', 'senhamedico21', 'USER'),
 ('672331/PE', 'luciabatista@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Lúcia Batista', 'medico22', 'senhamedico22', 'USER'),
 ('005624/MA', 'deboracarvalho@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Débora Carvalho', 'medico23', 'senhamedico23', 'USER'),
 ('511249/RR', 'gabrielateixeira@gmail.com', 'ENDOCRINOLOGIA_E_METABOLOGIA', 'Gabriela Teixeira', 'medico24', 'senhamedico24', 'USER'),
 ('955736/RO', 'sergiorodrigues@gmail.com', 'GASTROENTEROLOGIA', 'Sérgio Rodrigues', 'medico25', 'senhamedico25', 'USER'),
 ('351885/ES', 'renatodossantos@gmail.com', 'GASTROENTEROLOGIA', 'Renato dos Santos', 'medico26', 'senhamedico26', 'USER'),
 ('726115/MT', 'eduardofernandes@gmail.com', 'GASTROENTEROLOGIA', 'Eduardo Fernandes', 'medico27', 'senhamedico27', 'USER'),
 ('152944/SC', 'vitoriadias@gmail.com', 'GASTROENTEROLOGIA', 'Vitória Dias', 'medico28', 'senhamedico28', 'USER'),
 ('874653/PI', 'rosanunes@gmail.com', 'GASTROENTEROLOGIA', 'Rosa Nunes', 'medico29', 'senhamedico29', 'USER'),
 ('426851/CE', 'soniaalmeida@gmail.com', 'GASTROENTEROLOGIA', 'Sônia Almeida', 'medico30', 'senhamedico30', 'USER');

insert into Paciente(CPF, dataNascimento, email, genero, nome, telefone, login, senha, papel) values
 ('152.322.641-10', '2001-01-01', 'vitordesousa@gmail.com', 'M', 'Vítor de Sousa', '97355-8221', 'paciente1', 'senhapaciente1', 'USER'),
 ('429.215.384-76', '2002-02-02', 'lucascosta@gmail.com', 'M', 'Lucas Costa', '94751-5233', 'paciente2', 'senhapaciente2', 'USER'),
 ('442.625.153-88', '2003-03-03', 'fabiovieira@gmail.com', 'M', 'Fábio Vieira', '95524-9653', 'paciente3', 'senhapaciente3', 'USER'),
 ('763.248.615-55', '2004-04-04', 'sergiodossantos@gmail.com', 'M', 'Sérgio dos Santos', '96488-0423', 'paciente4', 'senhapaciente4', 'USER'),
 ('942.615.320-81', '2005-05-05', 'joaodeoliveira@gmail.com', 'M', 'João de Oliveira', '97102-5124', 'paciente5', 'senhapaciente5', 'USER'),
 ('152.342.615.82', '2006-06-06', 'raquelrodrigues@gmail.com', 'F', 'Raquel Rodrigues', '98144-8364', 'paciente6', 'senhapaciente6', 'USER'),
 ('156.931.526-84', '2007-07-07', 'simonerocha@gmail.com', 'F', 'Simone Rocha', '94155-7525', 'paciente7', 'senhapaciente7', 'USER'),
 ('426.153.286-50', '2008-08-08', 'brunalopes@gmail.com', 'F', 'Bruna Lopes', '94221-8253', 'paciente8', 'senhapaciente8', 'USER'),
 ('816.420.301-82', '2009-09-09', 'larissadacosta@gmail.com', 'F', 'Larissa da Costa', '95428-8422', 'paciente9', 'senhapaciente9', 'USER'),
 ('516.234.526-81', '2010-10-10', 'raquelsoares@gmail.com', 'F', 'Raquel Soares', '98425-6435', 'paciente10', 'senhapaciente10', 'USER');