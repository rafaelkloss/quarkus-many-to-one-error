package com.proposito.model.core.evidencia.feedback;

/**
 * <ul>
 * <li>Dar feedback a um colega</li>
 * <li>Pedir feedback a um colega</li>
 * <li>Informar feedback recebido</li>
 * </ul>
 * 
 * @author kloss
 *
 */
public enum StatusSolicitacaoFeedback {

	SOLICITADO("Solicitado"), VISTO("Hash já foi acessado pelo menos uma vez"),
	NEGADO("Feedback negado pelo evidenciador"), ATENDIDO("Feedback atendido pelo evidenciador");

	private final String descricao;

	private StatusSolicitacaoFeedback(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
