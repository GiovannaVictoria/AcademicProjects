package br.ufscar.dc.dsw.domain;

public enum Papel {
	
	USER  (1L, "USER");
	
	private final Long key;
    private final String value;

    Papel(Long key, String value) {
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