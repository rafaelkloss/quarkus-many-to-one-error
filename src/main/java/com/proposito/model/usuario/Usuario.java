package com.proposito.model.usuario;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

import com.proposito.model.AbstractModel;
import com.proposito.model.cliente.Cliente;
import com.proposito.model.cliente.Filial;
import com.proposito.model.cliente.Matriz;
import com.proposito.model.i18n.Idioma;
import com.proposito.model.i18n.LocationTimeZone;
import com.proposito.model.util.LogRegistro;

/**
 * Entidade que representa todos os usuários da plataforma, sejam eles PRO ou de
 * um cliente, vide {@link PerfilUsuario}
 * 
 * @author kloss
 */
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractModel {

	@Id
	@SequenceGenerator(name = "usuarioSequence", sequenceName = "usuario_id_seq", allocationSize = 1, initialValue = 4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSequence")
	private Integer id;

	@Column(length = 120, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String nick;

	@Column(length = 200, nullable = false, unique = true)
	private String email;

	@Column(nullable = false, length = 128)
	private String senha;

	@Column(length = 128)
	private String hash;

	@Column(length = 20)
	private String celular;

	@Column(name = "`senhasIncorretas`", nullable = false)
	private Short senhasIncorretas = 0;

	/**
	 * Url da logo
	 */
	@Column(name = "`fotoPerfil`", nullable = true, length = 255)
	private String fotoPerfil;

	@ManyToOne(optional = false)
	@JoinColumn(name = "`idIdiomaDefault`", unique = false, nullable = false)
	private Idioma idiomaDefault;

	@Column(name = "`jobTitle`", nullable = true, length = 150)
	private String jobTitle;

	/**
	 * Detault, mudar se necessário
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false, name = "`timeZone`")
	private LocationTimeZone timeZone = LocationTimeZone.AMERICA_SAO_PAULO;

	// armazena se esse usuário é ou não um gestor de pessoas
	@Column(name = "`isGestor`", nullable = false)
	private Boolean isGestor = Boolean.FALSE;

	@Column(name = "`dataUltimoAcesso`", nullable = true, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataUltimoAcesso;

	@Column(name = "`dataNascimento`")
	private LocalDate dataNascimento;

	@Embedded
	private LogRegistro log = new LogRegistro(false);

	/**
	 * Se {@link PerfilUsuario} === {@link PerfilUsuario}#CLIENTE esse campo é
	 * obrigatório !
	 */
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "`idCliente`")
	private Cliente cliente;

	/**
	 * Se {@link PerfilUsuario} === {@link PerfilUsuario}#CLIENTE esse campo é
	 * obrigatório !
	 */
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "`idCargo`")
	private Cargo cargo;

	@Column(name = "`dataInicio`", nullable = true)
	private LocalDate dataInicio;

	public Usuario() {
	}

	public Usuario(Integer id) {
		this.id = id;
	}

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

	public String getNick() {
		return nick;
	}

	public String getAdaptedNick() {
		if (null == nick && nick.isEmpty()) {
			if (nome.indexOf(" ") > -1) {
				return nome.split(" ")[1];
			}
			return nome;
		}
		return nick.trim();
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

	public LogRegistro getLog() {
		return log;
	}

	public void setLog(LogRegistro log) {
		this.log = log;
	}

	public String getSenha() {
		return senha;
	}

	/**
	 * Coloca a senha do usuário usando {@link DigestUtils#sha256(String)}
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = DigestUtils.sha256Hex(senha);
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Idioma getIdiomaDefault() {
		return idiomaDefault;
	}

	public void setIdiomaDefault(Idioma idiomaDefault) {
		this.idiomaDefault = idiomaDefault;
	}

	public OffsetDateTime getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(OffsetDateTime dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Short getSenhasIncorretas() {
		return senhasIncorretas;
	}

	public void setSenhasIncorretas(Short senhasIncorretas) {
		this.senhasIncorretas = senhasIncorretas;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Boolean getIsGestor() {
		return isGestor;
	}

	public void setIsGestor(Boolean isGestor) {
		this.isGestor = isGestor;
	}

	public LocationTimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(LocationTimeZone timeZone) {
		this.timeZone = timeZone;
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

	/**
	 * Retorna SEMPRE a {@link Matriz} do {@link Cliente}
	 * 
	 * @return
	 */
	public Matriz getMatriz() {
		if (this.cliente instanceof Matriz) {
			return (Matriz) this.cliente;
		}
		return ((Filial) this.cliente).getMatriz();
	}

}
