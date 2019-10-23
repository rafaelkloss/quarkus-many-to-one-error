package com.proposito.dto.cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.proposito.dto.AbstractDTO;
import com.proposito.dto.contract.HasIdDTO;
import com.proposito.model.cliente.Cliente;

/**
 * Classe DTO que representa um {@link Depar} de um {@link Cliente}
 * 
 * @author kloss
 *
 */
public class CargoDTO extends AbstractDTO implements HasIdDTO {

	private Integer id;

	@NotEmpty
	@Size(min = 3, max = 60)
	private String nome;

	@NotNull
	private Boolean ativo = true;

	@Size(min = 3, max = 200)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
