package br.ufscar.dc.dsw.domain;

public enum Genero {
	
	F(1L, "Feminino"),
	M(2L, "Masculino");
	
	private final Long key;
    private final String value;

    Genero(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
    	return this.name();
    }
    
}