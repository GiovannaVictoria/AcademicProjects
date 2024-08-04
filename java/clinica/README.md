# Sistema web para agendamento de consultas médicas

O sistema foi construído na arquivetura MVC (Model-View-Controller) e usou as seguintes tecnologias: Servlet, JSP, JSTL e JDBC no lado do servidor e CSS no lado do cliente.

### O sistema oferece três tipos de cadastro:
  - de pacientes, com os seguintes dados: e-mail, senha, CPF, nome, telefone, sexo e data de nascimento;
  - de médicos, com os seguintes dados: e-mail, senha, CRM, nome e especialidade;
  - de consultas, com os seguintes dados: CPF do paciente, CRM do médico e data/hora da consulta. A duração da consulta é de 30 minutos e sempre inicia-se em "hora cheia" ou "hora meia".

### O sistema possui as seguintes funcionalidades:
  - CRUD de médicos mediante login de administrador;
  - CRUD de pacientes mediante login de administrador;
  - Listagem de todos os médicos em uma única página;
  - Listagem de todos os médicos por especialidade;
  - Agendamento de consulta com um médico meidante login do paciente;
  - Listagem de todas as consultas de um paciente mediante login do paciente;
  - Listagem de todas as consultas de um médico mediante login do médico;
  - Internacionalização em dois idiomas: português e inglês.

### Informações para execução local:
  - É necessário ter instalados: Apache Tomcat - versão 9.0.88, e Apache Maven - versão 3.6.3 ou superior;
  - Primeiro, é necessário subir o servidor do Tomcat através do comando: "<caminho-para-o-local-de-instalacao-do-Tomcat>/apache-tomcat-9.0.88/bin/catalina.sh run";
  - Depois, é necessário dar o deploy da aplicação, a partir da sua pasta raiz, através do comando: "mvn tomcat7:redeploy";

###### Autor: Giovanna Victória Rossetto
###### Data de criação: 25/07/2024 - 25 de julho de 2024
###### Última modificação: 25/07/2024 - 25 de julho de 2024
