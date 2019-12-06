
package com.proposito.services.impl.evidencia;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;

import org.apache.commons.codec.digest.DigestUtils;

import com.proposito.dto.evidencia.feedback.SolicitacaoFeedbackInternoDTO;
import com.proposito.model.cliente.Matriz;
import com.proposito.model.core.evidencia.feedback.InternalRequest;
import com.proposito.model.project.ConfiguracaoCompetencia;
import com.proposito.model.project.ParticipacaoProjeto;
import com.proposito.model.project.Projeto;
import com.proposito.model.usuario.Cargo;
import com.proposito.model.usuario.Usuario;
import com.proposito.services.contract.evidencia.ErrorHereService;

@RequestScoped
public class ErrorHereServiceImpl extends EvidenciaServiceImpl implements ErrorHereService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String errorRequestHere(SolicitacaoFeedbackInternoDTO solicitacaoDTO) {
		// fake logged user
		final Usuario usuario = (Usuario) evidenciaDAO.getById(Usuario.class, 2);
//		Matriz company;
//		final Matriz matriz = usuario.getMatriz();
//		company = matriz;
		final InternalRequest solicitacao = new InternalRequest();
		solicitacao.setDescricao(solicitacaoDTO.getDescricao());
		solicitacao.setSolicitante(usuario);
		final Usuario usuarioSolicitacao = (Usuario) evidenciaDAO.getById(Usuario.class,
				solicitacaoDTO.getUsuarioSolicitacao().getId());
		solicitacao.setUsuarioSolicitacao(usuarioSolicitacao);
		final InternalRequest solicitacaoPersistida = (InternalRequest) evidenciaDAO.persist(solicitacao);
		solicitacaoPersistida.setHash(DigestUtils.sha256Hex(solicitacaoPersistida.getId().toString()));
		evidenciaDAO.persist(solicitacaoPersistida);
		return usuarioSolicitacao.getAdaptedNick();
	}

	@Override
	public String errorProxy() {
		Projeto pro = (Projeto) evidenciaDAO.getById(Projeto.class, 1);
		return "Name: " + pro.getNome() + ", Description: " + pro.getDescricao();
	}

	@Override
	public Integer createProject() {
		Projeto projeto = new Projeto();
		projeto.setNome("Test project");
		projeto.setDescricao("test description");
		final Matriz matriz = new Matriz();
		matriz.setId(2);
		projeto.setCliente(matriz);
		final ConfiguracaoCompetencia conf = new ConfiguracaoCompetencia();
		conf.setDataConclusao(LocalDate.now());
		conf.setDataFim(LocalDate.now());
		conf.setDataInicio(LocalDate.now());
		projeto.setConfiguracao(conf);
		final Cargo cargo = new Cargo();
		cargo.setId(1);
		for (int x = 0; x < 18; x++) {
			final ParticipacaoProjeto par = new ParticipacaoProjeto();
			par.setCargo(cargo);
			par.setColaborador(new Usuario(3));
			par.setHash("no-hash-only-test" + x);
			par.setProjeto(projeto);
			projeto.getParticipacoes().add(par);
		}
		projeto = (Projeto) evidenciaDAO.persist(projeto);
		return projeto.getId();
	}

}
