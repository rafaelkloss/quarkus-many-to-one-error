package com.proposito.dto.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import com.proposito.dto.AbstractDTO;
import com.proposito.model.cliente.Cliente;
import com.proposito.model.cliente.Matriz;
import com.proposito.model.cliente.StatusCliente;

/**
 * Classe DTO que representa um {@link Cliente} {@link Matriz}
 * 
 * @author kloss
 *
 */
public class ClienteDTO extends AbstractDTO {

	private Integer id;

	@NotEmpty
	@Size(min = 3, max = 60)
	private String nome;

	@NotNull
	private StatusCliente status = StatusCliente.ATIVO;

	@NotEmpty
	@Size(min = 3, max = 200)
	private String enderecoPadraoGoogle;

	@Size(min = 3, max = 255)
	private String complementoEndereco;

	private String logo;

	@Email
	private String emailAdministrador;

	@NotEmpty
	@Size(min = 3, max = 120)
	private String nomeAdministrador;

	private String hashConviteAdministrador;

	@NotNull
	private Integer idIdioma = 1;

	@NotEmpty
	@org.hibernate.validator.constraints.URL(protocol = "http")
	private String site;

	@Length(min = 5, max = 20)
	private String telefone;

	@CNPJ
	private String cnpj;

	private Short quantidadeEstimadaFuncionarios;

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

	public StatusCliente getStatus() {
		return status;
	}

	public void setStatus(StatusCliente status) {
		this.status = status;
	}

	public String getEnderecoPadraoGoogle() {
		return enderecoPadraoGoogle;
	}

	public void setEnderecoPadraoGoogle(String enderecoPadraoGoogle) {
		this.enderecoPadraoGoogle = enderecoPadraoGoogle;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmailAdministrador() {
		return emailAdministrador;
	}

	public void setEmailAdministrador(String emailAdministrador) {
		this.emailAdministrador = emailAdministrador;
	}

	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getNomeAdministrador() {
		return nomeAdministrador;
	}

	public void setNomeAdministrador(String nomeAdministrador) {
		this.nomeAdministrador = nomeAdministrador;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHashConviteAdministrador() {
		return hashConviteAdministrador;
	}

	public void setHashConviteAdministrador(String hashConviteAdministrador) {
		this.hashConviteAdministrador = hashConviteAdministrador;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Short getQuantidadeEstimadaFuncionarios() {
		return quantidadeEstimadaFuncionarios;
	}

	public void setQuantidadeEstimadaFuncionarios(Short quantidadeEstimadaFuncionarios) {
		this.quantidadeEstimadaFuncionarios = quantidadeEstimadaFuncionarios;
	}

}
