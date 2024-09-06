package ufscar.dc.compiladores.agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ufscar.dc.compiladores.gramatica.gramaticaAgendaBaseVisitor;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaParser;

public class Analisador extends gramaticaAgendaBaseVisitor<String> {

    private final HashMap<String, Integer> meses;    // armazena o correspondente numerico de cada mes
    private final HashMap<Integer, String> numMeses; // armazena o nome de cada mes a partir do seu correspondente numerico

    public Analisador() {
        this.meses = new HashMap<>();
        this.numMeses = new HashMap<>();

        meses.put("janeiro", 1);
        meses.put("fevereiro", 2);
        meses.put("março", 3);
        meses.put("abril", 4);
        meses.put("maio", 5);
        meses.put("junho", 6);
        meses.put("julho", 7);
        meses.put("agosto", 8);
        meses.put("setembro", 9);
        meses.put("outubro", 10);
        meses.put("novembro", 11);
        meses.put("dezembro", 12);

        numMeses.put(1, "janeiro");
        numMeses.put(2, "fevereiro");
        numMeses.put(3, "março");
        numMeses.put(4, "abril");
        numMeses.put(5, "maio");
        numMeses.put(6, "junho");
        numMeses.put(7, "julho");
        numMeses.put(8, "agosto");
        numMeses.put(9, "setembro");
        numMeses.put(10, "outubro");
        numMeses.put(11, "novembro");
        numMeses.put(12, "dezembro");
    }
    
    @Override
    public String visitCalendario(gramaticaAgendaParser.CalendarioContext ctx) {
        List<gramaticaAgendaParser.CorpoAnoContext> corpo_ano_ctx = ctx.corpoAno();
        ArrayList<Integer> anos = new ArrayList<>();
        for (gramaticaAgendaParser.CorpoAnoContext ano : corpo_ano_ctx) {
            // agrupando todos os anos declarados
            anos.add(Integer.parseInt(ano.NUM_INT().getText()));
        }
        for (int ano : anos) {
            if (anos.indexOf(ano) != anos.lastIndexOf(ano)) {
                // nao eh permitido declarar duas instancias separadas de um mesmo ano, elas precisam estar juntas
                if (!UtilsAgenda.errosSemanticos.contains("Linha " + ctx.start.getLine() + ": nao pode haver duas instancias do mesmo ano (" + ano + "). Junte ambas ou separe em duas agendas.\n")) {
                    UtilsAgenda.adicionarErroSemantico(ctx.start, "nao pode haver duas instancias do mesmo ano (" + ano + "). Junte ambas ou separe em duas agendas.\n");
                }
            }
        }
        for (gramaticaAgendaParser.CorpoAnoContext ano : corpo_ano_ctx) {
            visitCorpoAno(ano);
        }
        return null;
    }

    @Override
    public String visitCorpoAno(gramaticaAgendaParser.CorpoAnoContext ctx) {        
        int numAno = Integer.parseInt(ctx.NUM_INT().getText());
        int anoAtual = LocalDate.now().getYear();
        List<gramaticaAgendaParser.CorpoMesContext> corpoMesCTX = ctx.corpoMes();
        ArrayList<Integer> numMes = new ArrayList<>();
        if (numAno < anoAtual) {
            // nao eh permitido adicionar anos anteriores na agenda
            UtilsAgenda.adicionarErroSemantico(ctx.start, "o(s) ano(s) escolhido(s) (" + numAno + ") nao pode(m) ser anterior(es) ao ano atual (" + anoAtual + ").\n");
        } else if (numAno == anoAtual) {
            verificaMes(corpoMesCTX);
        }
        for (gramaticaAgendaParser.CorpoMesContext corpo_mes_ctx : corpoMesCTX) {
            // agrupando todos os meses declarados
            numMes.add(meses.get(corpo_mes_ctx.MES().getText().toLowerCase()));
        }
        for (int num : numMes) {
            if (numMes.indexOf(num) != numMes.lastIndexOf(num)) {
                // nao eh permitido declarar duas instancias separadas de um mesmo mes dentro do mesmo ano, elas precisam estar juntas
                if (!UtilsAgenda.errosSemanticos.contains("Linha " + ctx.start.getLine() + ": nao pode haver duas instancias do mesmo mes (" + numMeses.get(num) + ") dentro do mesmo ano. Junte ambas ou separe em duas agendas.\n")) {
                    UtilsAgenda.adicionarErroSemantico(ctx.start, "nao pode haver duas instancias do mesmo mes (" + numMeses.get(num) + ") dentro do mesmo ano. Junte ambas ou separe em duas agendas.\n");
                }
            }
        }
        for (gramaticaAgendaParser.CorpoMesContext corpo_mes_ctx : corpoMesCTX) {
            visitCorpoMes(corpo_mes_ctx, numAno);
        }
        return null;
    }

    /*
    visitCorpoMes personalizado
    recebe o ano para verificar se eh bissexto, para o caso de Fevereiro ter 29 dias
    */
    public String visitCorpoMes(gramaticaAgendaParser.CorpoMesContext ctx, int numAno) {
        int numDia;
        String mes = ctx.MES().getText();
        List<gramaticaAgendaParser.CorpoDiaContext> dias = ctx.corpoDia();
        List<Integer> numDias = new ArrayList<>();
        for (gramaticaAgendaParser.CorpoDiaContext dia : dias) {
            // agrupando todos os dias declarados
            numDias.add(Integer.parseInt(dia.NUM_INT().getText()));
        }
        for (int num : numDias) {
            if (numDias.indexOf(num) != numDias.lastIndexOf(num)) {
                // nao eh permitido declarar duas instancias separadas de um mesmo dia dentro de um mesmo mes dentro do mesmo ano, elas precisam estar juntas
                if (!UtilsAgenda.errosSemanticos.contains("Linha " + ctx.start.getLine() + ": nao pode haver duas instancias do mesmo dia (" + num + ") dentro do mesmo mes dentro do mesmo ano. Junte ambas ou separe em duas agendas.\n")) {
                    UtilsAgenda.adicionarErroSemantico(ctx.start, "nao pode haver duas instancias do mesmo dia (" + num + ") dentro do mesmo mes dentro do mesmo ano. Junte ambas ou separe em duas agendas.\n");
                }
            }
        }
        for (gramaticaAgendaParser.CorpoDiaContext dia : dias) {
            numDia = Integer.parseInt(dia.NUM_INT().getText());
            verificaDiaDoMes(dia, numDia, numAno, mes);
        }
        return super.visitCorpoMes(ctx);
    }

    @Override
    public String visitHorario(gramaticaAgendaParser.HorarioContext ctx) {
        int hora = Integer.parseInt(ctx.NUM_INT(0).getText());
        int minuto = Integer.parseInt(ctx.NUM_INT(1).getText());
        if (hora < 0 || hora > 23) {
            UtilsAgenda.adicionarErroSemantico(ctx.start, hora + " nao eh um numero valido para hora.\n");
        }
        if (minuto < 0 | minuto > 59) {
            UtilsAgenda.adicionarErroSemantico(ctx.start, minuto + " nao eh um numero valido para minuto.\n");
        }
        return null;
    }
    
    // verifica se o mes eh valido (se nao eh anterior ao atual)
    public void verificaMes(List<gramaticaAgendaParser.CorpoMesContext> corpoMesCTX) {
        int mesAtual = LocalDate.now().getMonthValue();
        List<gramaticaAgendaParser.CorpoDiaContext> corpoDiaCTX;
        for (gramaticaAgendaParser.CorpoMesContext corpo_mes_ctx : corpoMesCTX) {
            String mes = corpo_mes_ctx.MES().getText().toLowerCase();
            if (meses.get(mes) < mesAtual) {
                // nao eh permitido adicionar meses anteriores na agenda (quando o ano for o atual)
                UtilsAgenda.adicionarErroSemantico(corpo_mes_ctx.start, "quando o ano escolhido eh o ano atual, o(s) meses(s) escolhido(s) (" + mes + ") nao pode(m) ser anterior(es) ao mes atual (" + numMeses.get(mesAtual) + ").\n");
            } else if (meses.get(mes) == mesAtual) {
                corpoDiaCTX = corpo_mes_ctx.corpoDia();
                verificaDia(corpoDiaCTX);
            }
        }
    }

    // verifica se o dia eh valido (se nao eh anterior ao atual)
    public void verificaDia(List<gramaticaAgendaParser.CorpoDiaContext> corpoDiaCTX) {
        int diaAtual = LocalDate.now().getDayOfMonth();
        for (gramaticaAgendaParser.CorpoDiaContext corpo_dia_ctx : corpoDiaCTX) {
            int dia = Integer.parseInt(corpo_dia_ctx.NUM_INT().getText());
            if (dia < diaAtual) {
                // nao eh permitido adicionar dias anteriores na agenda (quando o ano e o mes forem os atuais)
                UtilsAgenda.adicionarErroSemantico(corpo_dia_ctx.start, "quando o ano e o mes escolhidos sao o ano e mes atuais, o(s) dia(s) escolhido(s) (" + dia + ") nao pode(m) ser anterior(es) ao dia atual (" + diaAtual + ").\n");
            }
        }
    }

    // verifica se o dia escolhido existe no mes
    public void verificaDiaDoMes(gramaticaAgendaParser.CorpoDiaContext dia, int numDia, int numAno, String mes) {
        if (numDia > 31) {
            UtilsAgenda.adicionarErroSemantico(dia.start, "dia " + numDia + " nao existe no mes de " + mes + ".\n");
        } else if (numDia == 31) {
            if (!("Janeiro".equals(mes)
                    | "Março".equals(mes)
                    | "Maio".equals(mes)
                    | "Julho".equals(mes)
                    | "Agosto".equals(mes)
                    | "Outubro".equals(mes)
                    | "Dezembro".equals(mes))) {
                UtilsAgenda.adicionarErroSemantico(dia.start, "dia " + numDia + " nao existe no mes de " + mes + ".\n");
            }
        } else if (numDia == 30) {
            if ("Fevereiro".equals(mes)) {
                UtilsAgenda.adicionarErroSemantico(dia.start, "dia " + numDia + " nao existe no mes de " + mes + ".\n");
            }
        } else if (numDia == 29) {
            boolean anoBissexto = false;
            // verificando se eh bissexto
            if (numAno % 400 == 0) {
                anoBissexto = true;
            } else if (numAno % 4 == 0 && numAno % 100 != 0) {
                anoBissexto = true;
            }
            if ("Fevereiro".equals(mes) && !anoBissexto) {
                UtilsAgenda.adicionarErroSemantico(dia.start, "dia 29 existe no mes de fevereiro apenas em anos bissextos. " + numAno + " nao eh ano bissexto.\n");
            }
        }
    }

}
