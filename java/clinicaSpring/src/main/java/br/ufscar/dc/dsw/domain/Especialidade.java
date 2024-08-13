package br.ufscar.dc.dsw.domain;

public enum Especialidade {
	
	ACUPUNTURA                              (1L, "Acupuntura"),
	ALERGOLOGIA_E_IMUNOLOGIA                (2L, "Alergologia e Imunologia"),
	ANESTESIOLOGIA                          (3L, "Anestesiologia"),
	ANGIOLOGIA                              (4L, "Angiologia"),
	CARDIOLOGIA                             (5L, "Cardiologia"),
	CIRURGIA_CARDIOVASCULAR                 (6L, "Cirurgia Cardiovascular"),
	CIRURGIA_DA_MAO                         (7L, "Cirurgia da Mão"),
	CIRURGIA_DE_CABECA_E_PESCOCO            (8L, "Cirurgia de Cabeça e Pescoço"),
	CIRURGIA_DO_APARELHO_DIGESTIVO          (9L, "Cirurgia do Aparelho Digestivo"),
	CIRURGIA_GERAL                          (10L, "Cirurgia Geral"),
	CIRURGIA_ONCOLOGICA                     (11L, "Cirurgia Oncológica"),
	CIRURGIA_PEDIATRICA                     (12L, "Cirurgia Pediátrica"),
	CIRURGIA_PLASTICA                       (13L, "Cirurgia Plástica"),
	CIRURGIA_TORACICA                       (14L, "Cirurgia Torácica"),
	CIRURGIA_VASCULAR                       (15L, "Cirurgia Vascular"),
	CLINICA_MEDICA                          (16L, "Clínica Médica"),
	COLOPROCTOLOGIA                         (17L, "Coloproctologia"),
	DERMATOLOGIA                            (18L, "Dermatologia"),
	ENDOCRINOLOGIA_E_METABOLOGIA            (19L, "Endocrinologia e Metabologia"),
	ENDOSCOPIA                              (20L, "Endoscopia"),
	GASTROENTEROLOGIA                       (21L, "Gastroenterologia"),
	GENETICA_MEDICA                         (22L, "Genética Médica"),
	GERIATRIA                               (23L, "Geriatria"),
	GINECOLOGIA_E_OBSTETRICIA               (24L, "Ginecologia e Obstetrícia"),
	HEMATOLOGIA_E_HEMOTERAPIA               (25L, "Hematologia e Hemoterapia"),
	HOMEOPATIA                              (26L, "Homeopatia"),
	INFECTOLOGIA                            (27L, "Infectologia"),
	MASTOLOGIA                              (28L, "Mastologia"),
	MEDICINA_DE_EMERGENCIA                  (29L, "Medicina de Emergência"),
	MEDICINA_DE_FAMILIA_E_COMUNIDADE        (30L, "Medicina de Família e Comunidade"),
	MEDICINA_DO_TRABALHO                    (31L, "Medicina do Trabalho"),
	MEDICINA_DE_TRAFEGO                     (32L, "Medicina de Tráfego"),
	MEDICINA_ESPORTIVA                      (33L, "Medicina Esportiva"),
	MEDICINA_FISICA_E_REABILITACAO          (34L, "Medicina Física e Reabilitação"),
	MEDICINA_INTENSIVA                      (35L, "Medicina Intensiva"),
	MEDICINA_LEGAL_E_PERICIA_MEDICA         (36L, "Medicina Legal e Perícia Médica"),
	MEDICINA_NUCLEAR                        (37L, "Medicina Nuclear"),
	MEDICINA_PREVENTIVA_E_SOCIAL            (38L, "Medicina Preventiva e Social"),
	NEFROLOGIA                              (39L, "Nefrologia"),
	NEUROCIRURGIA                           (40L, "Neurocirurgia"),
	NEUROLOGIA                              (41L, "Neurologia"),
	NUTROLOGIA                              (42L, "Nutrologia"),
	OFTALMOLOGIA                            (43L, "Oftalmologia"),
	ONCOLOGIA_CLINICA                       (44L, "Oncologia Clínica"),
	ORTOPEDIA_E_TRAUMATOLOGIA               (45L, "Ortopedia e Traumatologia"),
	OTORRINOLARINGOLOGIA                    (46L, "Otorrinolaringologia"),
	PATOLOGIA                               (47L, "Patologia"),
	PATOLOGIA_CLINICA_MEDICINA_LABORATORIAL (48L, "Patologia Clínica/Medicina Laboratorial"),
	PEDIATRIA                               (49L, "Pediatria"),
	PNEUMOLOGIA                             (50L, "Pneumologia"),
	PSIQUIATRIA                             (51L, "Psiquiatria"),
	RADIOLOGIA_E_DIAGNOSTICO_POR_IMAGEM     (52L, "Radiologia e Diagnóstico por Imagem"),
	RADIOTERAPIA                            (53L, "Radioterapia"),
	REUMATOLOGIA                            (54L, "Reumatologia"),
	UROLOGIA                                (55L, "Urologia");
	
	private final Long key;
    private final String value;

    Especialidade(Long key, String value) {
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