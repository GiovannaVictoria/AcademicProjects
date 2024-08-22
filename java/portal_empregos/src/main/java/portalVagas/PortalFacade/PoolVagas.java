package portalVagas.PortalFacade;

import java.util.ArrayList;

public class PoolVagas {
	
	private ArrayList<Vaga> vagas;
	
	PoolVagas() {
		this.vagas = new ArrayList<>();
	}
	
	PoolVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}

	ArrayList<Vaga> getVagas() {
		return vagas;
	}

	void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	void adicionarVaga(Vaga vaga) {
		this.vagas.add(vaga);
	}

}
