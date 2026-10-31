package entidades;

import entidades.enums.StatusTarefa;

public class SubTarefa {

	private String nomeSubtarefa;
	private StatusTarefa status = StatusTarefa.PENDENTE;
	
	public SubTarefa(String nomeSubtarefa) {
		this.nomeSubtarefa = nomeSubtarefa;
	}

	public String getNomeSubtarefa() {
		return nomeSubtarefa;
	}

	public void setNomeSubtarefa(String nomeSubtarefa) {
		this.nomeSubtarefa = nomeSubtarefa;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}
	
	
}
