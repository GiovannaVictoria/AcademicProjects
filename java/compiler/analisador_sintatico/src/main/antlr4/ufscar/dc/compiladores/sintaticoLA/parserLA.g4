grammar parserLA;

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

// regras sintaticas

programa:
      (declaracoes 'algoritmo' corpo 'fim_algoritmo');

declaracoes:
      (decl_local_global*);

decl_local_global:
      (declaracao_local | declaracao_global);

declaracao_local:
      (('declare' variavel)                                    |
       ('constante' IDENT ':' tipo_basico '=' valor_constante) |
       ('tipo' IDENT ':' tipo)                                 );

variavel:
      (identificador (',' identificador)* ':' tipo);

identificador:
      (IDENT ('.' IDENT)* dimensao);

dimensao:
      ('[' exp_aritmetica ']')*;

tipo:
      (registro | tipo_estendido);

tipo_basico:
      ('literal' |
       'inteiro' |
       'real'    |
       'logico'  );

tipo_basico_ident:
      (tipo_basico | IDENT);

tipo_estendido:
      ('^'? tipo_basico_ident);

valor_constante:
      (CADEIA       |
       NUM_INT      |
       NUM_REAL     |
       'verdadeiro' |
       'falso'      );

registro:
      ('registro' variavel* 'fim_registro');

declaracao_global:
      (('procedimento' IDENT '(' parametros? ')' declaracao_local* cmd* 'fim_procedimento')       |
       ('funcao' IDENT '(' parametros? ')' ':' tipo_estendido declaracao_local* cmd* 'fim_funcao'));

parametro:
      ('var'? identificador (',' identificador)* ':' tipo_estendido);

parametros:
      (parametro  (',' parametro)*);

corpo:
      (declaracao_local* cmd*);

cmd:
      (cmdLeia       |
       cmdEscreva    |
       cmdSe         |
       cmdCaso       |
       cmdPara       |
       cmdEnquanto   |
       cmdFaca       |
       cmdAtribuicao |
       cmdChamada    |
       cmdRetorne    );

cmdLeia:
      ('leia' '(' '^'? identificador (',' '^'? identificador)* ')');

cmdEscreva:
      ('escreva' '(' expressao (',' expressao)* ')');

cmdSe:
      ('se' expressao 'entao' cmd* ('senao' cmd*)? 'fim_se');

cmdCaso:
      ('caso' exp_aritmetica 'seja' selecao ('senao' cmd*)? 'fim_caso');

cmdPara:
      ('para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' cmd* 'fim_para');

cmdEnquanto:
      ('enquanto' expressao 'faca' cmd* 'fim_enquanto');

cmdFaca:
      ('faca' cmd* 'ate' expressao);

cmdAtribuicao:
      ('^'? identificador '<-' expressao);

cmdChamada:
      (IDENT '(' expressao (',' expressao)* ')');

cmdRetorne:
      ('retorne' expressao);

selecao:
      (item_selecao*);

item_selecao:
      (constantes ':' cmd*);

constantes:
      (numero_intervalo (',' numero_intervalo)*);

numero_intervalo:
      (op_unario? NUM_INT ('..' op_unario? NUM_INT)?);

op_unario:
      ('-');

exp_aritmetica:
      (termo (op1 termo)*);

termo:
      (fator (op2 fator)*);

fator:
      (parcela (op3 parcela)*);

op1:
      ('+' | '-');

op2:
      ('*' | '/');

op3:
      ('%');

parcela:
      ((op_unario? parcela_unario) | parcela_nao_unario);

parcela_unario:
      (('^'? identificador)                       |
       (IDENT '(' expressao (',' expressao)* ')') |
       NUM_INT                                    |
       NUM_REAL                                   |
       ('(' expressao ')')                        );

parcela_nao_unario:
      (('&' identificador) | CADEIA);

exp_relacional:
      (exp_aritmetica (op_relacional exp_aritmetica)?);

op_relacional:
      ('='  |
       '<>' |
       '>=' |
       '<=' |
       '>'  |
       '<'  );

expressao:
      (termo_logico (op_logico_1 termo_logico)*);

termo_logico:
      (fator_logico (op_logico_2 fator_logico)*);

fator_logico:
      ('nao'? parcela_logica);

parcela_logica:
      (('verdadeiro' | 'falso') | exp_relacional);

op_logico_1:
      ('ou');

op_logico_2:
      ('e');
