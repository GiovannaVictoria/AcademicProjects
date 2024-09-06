grammar gramaticaAgenda;

// regras lexicas

COMENTARIO:
    ('#' (~('\n'))* '\n') -> skip;

ESPACO:
    (' '  |
     '\n' |
     '\r' |
     '\t' ) -> skip;

DELIM: ':';
      
NUM_INT:
    (Digito+);

PALAVRA_CHAVE:
    ('ano' |
     'dia' |
     'h'   );

MES:
    ('Janeiro'   |
     'Fevereiro' |      
     'Março'     |
     'Abril'     |
     'Maio'      |
     'Junho'     |
     'Julho'     |
     'Agosto'    |
     'Setembro'  |
     'Outubro'   |
     'Novembro'  |
     'Dezembro'  );
      
CADEIA:
    ('"' (ESC_SEQ | ~('"' | '\\' | '\n'))* '"');
      
fragment
ESC_SEQ:
    ('\\\'');

fragment
Digito:
    ('0'..'9');

Erro_cadeia_nao_fechada:
    ('"' (~('"'))* '\n');

// ~(COMENTARIO | ESPACO | DELIM | ...);

// regras sintaticas

calendario: (corpoAno)+ EOF;

corpoAno: ('ano' NUM_INT corpoMes+);

corpoMes: (MES corpoDia+);

corpoDia: ('dia' NUM_INT corpoHorario+);

corpoHorario: (horario ':' descricao);

horario: (NUM_INT 'h' NUM_INT);

descricao: (CADEIA);
