package com.proposito.dto.usuario;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import com.proposito.dto.AbstractDTO;
import com.proposito.dto.cliente.CargoDTO;
import com.proposito.dto.contract.HasIdDTO;

/**
 * Classse de usuario logado para ser utilizada na view, sem os ids que estão
 * armazenados no token de seguraçna Também utilizado para crud de usuários
 *
 * @author kloss
 *
 */
public class UsuarioDTO extends AbstractDTO implements HasIdDTO {

	private Integer id;

	private String nome;

	private String nick;

	private String email;

	private CargoDTO cargo;

	private String celular;

	private Integer idIdioma;

	private String fotoPerfil;

	private String jobTitle;

	private LocalDate dataNascimento;

	private LocalDate dataInicio;

	// armazena se esse usuário é ou não um gestor de pessoas
	private Boolean isGestor = Boolean.FALSE;

	// senha válida para primeiro acesso, recuperação de senha etc...
	private String senhaTemporaria;

	// hash válida para primeiro acesso, recuperação de senha etc...
	private String hash;

	private OffsetDateTime dataUltimoAcesso;

	private Integer idGestorDireto;
	private String nomeGestorDireto;

	private Set<String> roles = new HashSet<String>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(final Set<String> roles) {
		this.roles = roles;
	}

	public void addRole(final String role) {
		this.roles.add(role);
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getSenhaTemporaria() {
		return senhaTemporaria;
	}

	public void setSenhaTemporaria(String senhaTemporaria) {
		this.senhaTemporaria = senhaTemporaria;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public CargoDTO getCargo() {
		return cargo;
	}

	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}

	public Boolean getIsGestor() {
		return isGestor;
	}

	public void setIsGestor(Boolean isGestor) {
		this.isGestor = isGestor;
	}

	public OffsetDateTime getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(OffsetDateTime dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getIdGestorDireto() {
		return idGestorDireto;
	}

	public void setIdGestorDireto(Integer idGestorDireto) {
		this.idGestorDireto = idGestorDireto;
	}

	public String getNomeGestorDireto() {
		return nomeGestorDireto;
	}

	public void setNomeGestorDireto(String nomeGestorDireto) {
		this.nomeGestorDireto = nomeGestorDireto;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

}
