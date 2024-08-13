package br.ufscar.dc.dsw.domain;

public enum Hora {
	
	M8_0(1L, "08:00"),
	M8_1(2L, "08:30"),
	M9_0(3L, "09:00"),
	M9_1(4L, "09:30"),
	M10_0(5L, "10:00"),
	M10_1(6L, "10:30"),
	M11_0(7L, "11:00"),
	M11_1(8L, "11:30"),
	T13_0(9L, "13:00"),
	T13_1(10L, "13:30"),
	T14_0(11L, "14:00"),
	T14_1(12L, "14:30"),
	T15_0(13L, "15:00"),
	T15_1(14L, "15:30"),
	T16_0(15L, "16:00"),
	T16_1(16L, "16:30"),
	T17_0(17L, "17:00"),
	T17_1(18L, "17:30");
	
	private final Long key;
    private final String value;

    Hora(Long key, String value) {
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