package com.proposito.model.cliente;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proposito.model.AbstractModel;
import com.proposito.model.i18n.Idioma;
import com.proposito.model.i18n.LocationTimeZone;
import com.proposito.model.util.Endereco;
import com.proposito.model.util.LogRegistro;

@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 10)
@Cacheable
public abstract class Cliente extends AbstractModel {

	@Id
	@SequenceGenerator(name = "clienteSequence", sequenceName = "cliente_id_seq", allocationSize = 1, initialValue = 3)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteSequence")
	private Integer id;

	@Column(length = 60, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private StatusCliente status = StatusCliente.ATIVO;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "`idIdiomaDefault`", nullable = false)
	private Idioma idiomaDefault;

	/**
	 * Detault, mudar se necessário
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false, name = "`timeZone`")
	private LocationTimeZone timeZone = LocationTimeZone.AMERICA_SAO_PAULO;

	@Column(length = 20)
	private String telefone;

	private Short quantidadeEstimadaFuncionarios;

	@Embedded
	private Endereco endereco = new Endereco();

	@Embedded
	private LogRegistro log = new LogRegistro();

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

	public LogRegistro getLog() {
		return log;
	}

	public Idioma getIdiomaDefault() {
		return idiomaDefault;
	}

	public void setIdiomaDefault(Idioma idiomaDefault) {
		this.idiomaDefault = idiomaDefault;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Short getQuantidadeEstimadaFuncionarios() {
		return quantidadeEstimadaFuncionarios;
	}

	public void setQuantidadeEstimadaFuncionarios(Short quantidadeEstimadaFuncionarios) {
		this.quantidadeEstimadaFuncionarios = quantidadeEstimadaFuncionarios;
	}

	public LocationTimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(LocationTimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public void setLog(LogRegistro log) {
		this.log = log;
	}

	public Matriz getMatrizCliente() {
		if (this instanceof Matriz) {
			return (Matriz) this;
		}
		return ((Filial) this).getMatriz();
	}

}
