package br.ufscar.dc.dsw.domain;

public enum Generos {
	F(1L, "Feminino"),
	M(2L, "Masculino");
	
	private final Long key;
    private final String value;

    Generos(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}