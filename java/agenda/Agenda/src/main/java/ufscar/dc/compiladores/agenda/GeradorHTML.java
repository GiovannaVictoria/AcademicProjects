package ufscar.dc.compiladores.agenda;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaBaseVisitor;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaParser;

public class GeradorHTML extends gramaticaAgendaBaseVisitor<String> {

    private final HashMap<String, Integer> meses;   // armazena o correspondente numerico de cada mes
    private final HashMap<String, Integer> numDays; // armazena a quantidade de dias de cada mes
    StringBuilder tabulacoes;
    StringBuilder saida;

    public GeradorHTML() {
        this.saida = new StringBuilder();          // guarda o codigo gerado
        this.tabulacoes = new StringBuilder();     // padroniza a tabulacao do codigo
        this.meses = new HashMap<>();
        this.numDays = new HashMap<>();

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

        numDays.put("janeiro", 31);
        numDays.put("fevereiro", 28);
        numDays.put("março", 31);
        numDays.put("abril", 30);
        numDays.put("maio", 31);
        numDays.put("junho", 30);
        numDays.put("julho", 31);
        numDays.put("agosto", 31);
        numDays.put("setembro", 30);
        numDays.put("outubro", 31);
        numDays.put("novembro", 30);
        numDays.put("dezembro", 31);
    }

    @Override
    public String visitCalendario(gramaticaAgendaParser.CalendarioContext ctx) {
        // tag head padronizada, com css padronizado
        saida.append("<!DOCTYPE html>\n");
        saida.append("<html lang=\"en\">\n");
        saida.append("<head>\n");
        saida.append("<meta charset=\"UTF-8\">\n");
        saida.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        saida.append("<title>Calendário</title>\n");
        saida.append("<style>\n");
        saida.append("table {\n");
        saida.append("width: 100%;\n");
        saida.append("border-collapse: collapse;\n");
        saida.append("}\n");
        saida.append("th, td {\n");
        saida.append("border: 1px solid #000;\n");
        saida.append("width: 14.28%;\n");
        saida.append("height: 100px;\n");
        saida.append("text-align: left;\n");
        saida.append("vertical-align: top;\n");
        saida.append("padding: 5px;\n");
        saida.append("}\n");
        saida.append("th {\n");
        saida.append("background-color: #f0f0f0;\n");
        saida.append("}\n");
        saida.append(".day-number {\n");
        saida.append("font-weight: bold;\n");
        saida.append("margin-bottom: 5px;\n");
        saida.append("}\n");
        saida.append(".editable {\n");
        saida.append("outline: none;\n");
        saida.append("height: 80px;\n");
        saida.append("overflow: auto;\n");
        saida.append("}\n");
        saida.append("</style>\n");
        saida.append("</head>\n\n");
        saida.append("<body>\n");
        for (gramaticaAgendaParser.CorpoAnoContext corpo_ano_ctx : ctx.corpoAno()) {
            visitCorpoAno(corpo_ano_ctx);
        }
        saida.append("</body>\n");
        saida.append("</html>\n");
        return null;
    }

    @Override
    public String visitCorpoAno(gramaticaAgendaParser.CorpoAnoContext ctx) {
        boolean isBissexto = false;
        // verificando se eh bissexto
        int numAno = Integer.parseInt(ctx.NUM_INT().getText());

        if (numAno % 400 == 0) {
            isBissexto = true;
        } else if (numAno % 4 == 0 && numAno % 100 != 0) {
            isBissexto = true;
        }
        saida.append("<h1>" + ctx.NUM_INT().getText() + "</h1>\n");
        for (gramaticaAgendaParser.CorpoMesContext corpo_mes_ctx : ctx.corpoMes()) {
            visitCorpoMes(corpo_mes_ctx, numAno, isBissexto);
        }
        return null;
    }

    /*
    visitCorpoMes personalizado
    recebe o numero do ano e um boolean indicando se ele eh bissexto ou nao
     */
    public String visitCorpoMes(gramaticaAgendaParser.CorpoMesContext ctx, int numAno, boolean isBissexto) {
        List<gramaticaAgendaParser.CorpoDiaContext> corpo_dia_ctx = ctx.corpoDia();
        String mes = ctx.MES().getText().toLowerCase();
        LocalDate firstDay = LocalDate.of(numAno, meses.get(mes), 1); // recebe a data do primeiro dia do mes escolhido
        int numFirstDay = firstDay.getDayOfWeek().getValue();         // pega o numero do dia da semana correspondente a data do primeiro dia
        int numLastDay = numDays.get(mes);                            // pega a quantidade de dias do mes escolhido
        int countDays = 1;                                            // contador para o numero de dias ja escritos no HTML
        int auxCountDays = 1;                                         // contador para o numero de dias da semana (7) ja escritos no HTML
        int auxLastDay = 1;
        int countCorpoDia = 0;

        if ("fevereiro".equals(mes) && isBissexto) {
            numLastDay++;
        }

        // escrita da tabela HTML
        saida.append("<h2>" + ctx.MES().getText() + "</h2>\n");
        saida.append("<table>\n");
        saida.append("<tr>\n");
        saida.append("<th>Dom</th>\n");
        saida.append("<th>Seg</th>\n");
        saida.append("<th>Ter</th>\n");
        saida.append("<th>Qua</th>\n");
        saida.append("<th>Qui</th>\n");
        saida.append("<th>Sex</th>\n");
        saida.append("<th>Sáb</th>\n");
        saida.append("</tr>\n");

        if (numFirstDay != 7) {
            saida.append("<tr>\n");
            for (int i = 0; i < numFirstDay; i++) {
                // escrita dos dias que nao sao parte do mes em questao
                saida.append("<td></td>\n");
            }
            // escrita da primeira semana que precisa ser separada por causa dos dias que nao fazem parte do mes em questao
            for (int i = numFirstDay; i < 7; i++, countDays++) {
                saida.append("<td><div class=\"day-number\">" + countDays + "</div>");
                // verifica se ha alguma atividade naquele dia
                if (corpo_dia_ctx != null && countCorpoDia < corpo_dia_ctx.size()) {
                    if (Integer.parseInt(corpo_dia_ctx.get(countCorpoDia).NUM_INT().getText()) == countDays) {
                        visitCorpoDia(corpo_dia_ctx.get(countCorpoDia));
                        countCorpoDia++;
                    }
                }
                saida.append("<div class=\"editable\" contenteditable=\"true\"></div></td>\n");
            }
            saida.append("</tr>\n");
        }

        // escrita das outras semanas
        auxLastDay = countDays;
        while (auxLastDay <= numLastDay) {
            saida.append("<tr>\n");
            for (auxCountDays = 0; auxCountDays < 7 && countDays <= numLastDay; auxCountDays++, countDays++, auxLastDay++) {
                saida.append("<td><div class=\"day-number\">" + countDays + "</div>");
                // verifica se ha alguma atividade naquele dia
                if (corpo_dia_ctx != null && countCorpoDia < corpo_dia_ctx.size()) {
                    if (Integer.parseInt(corpo_dia_ctx.get(countCorpoDia).NUM_INT().getText()) == countDays) {
                        visitCorpoDia(corpo_dia_ctx.get(countCorpoDia));
                        countCorpoDia++;
                    }
                }
                saida.append("<div class=\"editable\" contenteditable=\"true\"></div></td>\n");
            }
            // escreve os dias restantes da ultima semana que nao fazem parte do mes em questao
            if (auxCountDays < 7) {
                for (int j = auxCountDays; j < 7; j++, auxLastDay++) {
                    saida.append("<td></td>\n");
                }
            }
            saida.append("</tr>\n");
        }

        saida.append("</table>\n");
        return null;
    }

    @Override
    public String visitCorpoDia(gramaticaAgendaParser.CorpoDiaContext ctx) {
        for (gramaticaAgendaParser.CorpoHorarioContext corpo_horario_ctx : ctx.corpoHorario()) {
            visitCorpoHorario(corpo_horario_ctx);
            saida.append("<br>");
        }
        return null;
    }

    @Override
    public String visitCorpoHorario(gramaticaAgendaParser.CorpoHorarioContext ctx) {
        saida.append(ctx.horario().NUM_INT(0).getText());
        saida.append("h");
        saida.append(ctx.horario().NUM_INT(1).getText());
        saida.append(": ");
        saida.append(ctx.descricao().CADEIA().getText());
        return null;
    }

}
