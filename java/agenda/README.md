# Agenda Organizadora

## Documentação externa - arquivo de ajuda para compilação e execução do projeto

Nome: Giovanna Victória Rossetto
RA: 791648

### Informações gerais:
O presente trabalho consiste em um compilador completo, com analisadores léxico, sintático e semântico, além de um gerador de código HTML, para uma gramática de agenda organizadora.
A agenda organizadora permite escrever eventos dentro de um horario, um dia, um mes e um ano, e ao final será gerado um calendário em formato HTML, o qual pode ser aberto em um navegador.

### Informações sobre a linguagem:
A especificação da gramática está presente no arquivo Agenda/src/main/antlr4/ufscar/dc/compiladores/gramatica/gramaticaAgenda.g4. Sua descrição vem a seguir:
	- podem-se definir um ou mais anos, seguindo a sintaxe 'ano' NUMERO;
	- dentro de cada ano, podem-se definir um ou mais meses, seguindo a sintaxe NOME_DO_MES;
	- dentro de cada mês, podem-se definir um ou mais dias, seguindo a sintaxe 'dia' NUMERO;
	- dentro de cada dia, podem-se definir um ou mais eventos, seguindo a sintaxe HH'h'MM : "descricao do evento";
	- comentários podem ser escritos com # e são considerados até o final da linha;
	- não é permitido colocar dois ou mais anos/meses/dias iguais de forma separada, eles precisam estar juntos;
	- não é permitido colocar datas anteriores à data atual, seja em relação ao ano, ao mês ou ao dia; quanto ao horário, não há esse tipo de restrição;
	- as horas devem seguir o formato de 24h apenas (00h00 até 23h59); não é permitido 12h com AM ou PM;
	- as verificações semânticas são:
		- verificação se o ano/mes/dia escolhido é igual ou posterior ao atual;
		- validação do dia dentro do mês (se ele existe dentro do mês);
		- validação da hora, em questão de formato e intervalo;

### Exemplo simples:
ano 2024
	mes Outubro
		dia 30
			14h00: "evento"

### Informações sobre o repositório:
Foram fornecidos 3 itens:
	- Este arquivo de ajuda com informações importantes sobre a compilação e execução do trabalho;
	- A pasta Agenda, com o projeto completo;
	- A pasta Casos_teste, com os casos de teste usados para testar o projeto;
		- os testes incluem testes de erros léxico, sintático, semântico e testes sem erros;
		- foram fornecidas tanto as entradas quanto as saidas esperadas, separadas em pastas com o nome apropriado;
    		- com relação aos casos de testes com erros léxico, sintático e semântico, é recomendável guardar as saídas em arquivos do tipo txt, como nas saídas esperadas;
    		- com relação aos casos de teste que não contém erros e gerarão o código HTML, é recomendável guardar as saídas em arquivos do tipo HTML, para que eles possam ser abertos em um navegador;


### Informações para compilação e execução:
O trabalho foi todo desenvolvido no NetBeans com o Maven e o ANTLR em Java. Portanto, seguir as instruções do vídeo introdutório disponível no link https://www.youtube.com/watch?v=LDRA-VOy2Bs&list=PLaPmgS59eMSEKNRIBxuBK4mJr-8pFP3lW&index=4 ou das intruções em código disponíveis no link https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico06.An%C3%A1lise%20Sint%C3%A1tica%20Conclus%C3%A3o.roteiro.md, ambos do professor Daniel Lucrédio, é suficiente para compilar e executar o trabalho.

Versões utilizadas:
	- Java: java version "22" 2024-03-19;
		Java(TM) SE Runtime Environment (build 22+36-2370);
		Java HotSpot(TM) 64-Bit Server VM (build 22+36-2370, mixed mode, sharing);
	- NetBeans: 12.2;
	- ANTLR: 4.8.
	
Para a compilação, basta abrir a pasta Agenda no NetBeans e selecionar a opção Clean and Build Project. Será gerado um executável dentro da pasta Agenda/target.

A execução em linha de comando para um único caso de teste precisa de 3 argumentos:
	- caminho completo da raiz até o diretório do executável;
	- caminho completo da raiz até o arquivo de entrada;
	- caminho completo da raiz até o arquivo destinada para a saída.

O comando final é para ser assim:
	- java -jar ARG1 ARG2 ARG3
	- java -jar /caminho_da_pasta_Agenda/Agenda/target/Agenda-1.0-SNAPSHOT-jar-with-dependencies.jar /caminho_do_arquivo_de_entrada /caminho_do_arquivo_de_saida

Após a execução, o executável gerará a saída no arquivo destinado contido no caminho fornecido.

### Observações:
- Todas essas instruções são referentes ao Linux, no Windows ou Mac pode haver algumas discrepâncias;
- É necessário autorizar a permissão dos arquivos do corretor e do executável como programas;
- O java deve estar configurado na variável de ambiente PATH;
- A versão mínima para o Java é a 11.0.2;
- Apesar de haver versões mais recentes do ANTLR posteriores à 4.8, o projeto precisa ser rodado com essa versão.

###### Autor: Giovanna Victória Rossetto
###### Data de criação: 08/09/2024 - 8 de Setembro de 2024
###### Data da última modificação: 08/09/2024 - 8 de Setembro de 2024
