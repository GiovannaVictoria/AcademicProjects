lexer grammar lexerLA;

// regras lexicas

// 1 - Comentario: cadeia de caracteres entre chaves sem quebra de linha ({})
Comentario:
      ('{' (~('\n' | '}'))* '}') -> skip;

// 2 - Espaco em branco: espaco, quebra de linha, retorno de carro, tabulacoes
Espaco:
      (' '  |
       '\n' |
       '\r' |
       '\t' ) -> skip;

// 3 - Delimitadores: dois pontos
Delimitador:
      (':');

// 4 - Pontuacao: ponto final, intervalo, virgula
Pontuacao:
      ('.'  |
       '..' |
       ','  );

// 5 - Abre parenteses
Abre_Parenteses: 
      ('(');

// 6 - Fecha parenteses
Fecha_Parenteses:
      (')');

// 7 - Abre colchetes
Abre_Colchetes:
      ('[');

// 8 - Fecha colchetes
Fecha_Colchetes:
      (']');

// 9 - Operador de atribuicao
Atribuicao:
      ('<-');

// 10 - Operador relacional: menor, menor ou igual, igual, maior, maior ou igual, diferente
Operador_Relacional:
      ('<'  |
       '<=' |
       '='  |
       '>'  |
       '>=' |
       '<>' );

// 11 - Operador aritmetico: soma, subtracao, multiplicacao, divisao, resto
Operador_Aritmetico:
      ('+' |
       '-' |
       '*' |
       '/' |
       '%' );

// 12 - Ponteiro e endereco
Ponteiro:
      ('^' | '&');

// 13 - Palavra chave: palavras reservadas da linguagem
Palavra_chave:
      ('ate'              |
       'algoritmo'        |
       'caso'             |
       'constante'        |
       'declare'          |
       'e'                |
       'enquanto'         |
       'entao'            |
       'escreva'          |
       'faca'             |
       'falso'            |
       'fim_algoritmo'    |
       'fim_caso'         |
       'fim_enquanto'     |
       'fim_funcao'       |
       'fim_para'         |
       'fim_procedimento' |
       'fim_registro'     |
       'fim_se'           |
       'funcao'           |
       'inteiro'          |
       'leia'             |
       'literal'          |
       'logico'           |
       'nao'              |
       'ou'               |
       'para'             |
       'procedimento'     |
       'real'             |
       'registro'         |
       'retorne'          |
       'se'               |
       'seja'             |
       'senao'            |
       'tipo'             |
       'var'              |
       'verdadeiro'       );

// 14 - Numero inteiro
NUM_INT:
      (Digito+);

// 15 - Numero real: numero de ponto flutuante com o ponto como separador
NUM_REAL:
      (Digito+ '.' Digito+);

// 16 - Identificador: variavel contendo letras, numeros ou _ e comecando por letras ou _
IDENT:
      (Letra | '_') (Letra | Digito | '_')*;

// 17 - Cadeia: string entre aspas duplas e sem quebra de linha
CADEIA:
      ('"' (ESC_SEQ | ~('"' | '\\' | '\n'))* '"');

// 18 - Comentario nao fechado: abertura de comentario com { sem seu fechamento ou com o fechamento em outra linha
Erro_Comentario:
      ('{' (~('}'))* '\n');

// 19 - Cadeia nao fechada: abertura de string com " sem seu fechamento ou com o fechamento em outra linha
Erro_Cadeia:
      ('"' (~('"'))* '\n');

// 20 - Simbolo nao identificado: simbolos nao inclusos nas regras
Simbolo_nao_identificado:
      ('!' |
       '@' |
       '#' |
       '$' |
       '¨' |
       '¹' |
       '²' |
       '³' |
       '£' |
       '|' |
       '¢' |
       '¬' |
       '§' |
       '~' |
       '`' |
       '´' |
       'ª' |
       'º' |
       '°' |
       '}' );

fragment
ESC_SEQ:
      ('\\\'');

fragment
Letra:
      ('a'..'z' | 'A'..'Z');

fragment
Digito:
      ('0'..'9');
