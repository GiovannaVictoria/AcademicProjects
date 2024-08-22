package portalVagas.PortalFacade;

public class Inscricao {
	
	private Candidato candidato;
	private Vaga vaga;
	
	Inscricao(Vaga vaga, Candidato candidato) {
		this.vaga = vaga;
		this.candidato = candidato;
	}

	Candidato getCandidato() {
		return candidato;
	}

	void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	 Vaga getVaga() {
		return vaga;
	}

	void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
