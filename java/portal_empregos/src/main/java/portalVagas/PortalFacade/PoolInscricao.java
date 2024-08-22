package portalVagas.PortalFacade;

import java.util.ArrayList;

public class PoolInscricao {
	
	private ArrayList<Inscricao> inscricoes;
	
	PoolInscricao() {
		this.inscricoes = new ArrayList<>();
	}
	
	PoolInscricao(ArrayList<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	}

	void setInscricoes(ArrayList<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	void adicionarInscricao(Inscricao inscricao) {
		this.inscricoes.add(inscricao);
	}

}