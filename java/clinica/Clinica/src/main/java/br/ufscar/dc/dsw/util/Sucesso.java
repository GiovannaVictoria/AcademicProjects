package br.ufscar.dc.dsw.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public final class Sucesso implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> mensagens = new ArrayList<>();
    private ResourceBundle messages;

    public Sucesso(String locale) {
    	String[] parts = locale.split("_");
        if (parts.length == 2) {
            messages = ResourceBundle.getBundle("messages", new Locale(parts[0], parts[1]));
        } else {
            messages = ResourceBundle.getBundle("messages", new Locale(locale));
        }
    }

    public void add(String key) {
        mensagens.add(messages.getString(key));
    }

    public boolean isExisteSucessos() {
        return !mensagens.isEmpty();
    }

    public List<String> getSucessos() {
        return mensagens;
    }
}