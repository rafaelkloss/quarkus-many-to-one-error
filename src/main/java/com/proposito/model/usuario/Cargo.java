package com.proposito.model.usuario;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.proposito.model.AbstractModel;
import com.proposito.model.HasLogAndCliente;
import com.proposito.model.HasToggleAtivo;
import com.proposito.model.cliente.Cliente;
import com.proposito.model.util.LogRegistro;

@Entity
@Table(name = "cargo", uniqueConstraints = @UniqueConstraint(name = "cargo_nome_unique", columnNames = { "`idCliente`",
		"nome" }))
@Cacheable
public class Cargo extends AbstractModel implements HasLogAndCliente, HasToggleAtivo {

	@Id
	@SequenceGenerator(name = "cargoSequence", sequenceName = "cargo_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargoSequence")
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 200)
	private String descricao;

	@Column(nullable = false)
	private Boolean ativo = true;

	@Column(nullable = false)
	private Boolean isGestao = false;

	@Embedded
	private LogRegistro log = new LogRegistro();

	@ManyToOne(optional = false)
	@JoinColumn(name = "`idCliente`")
	private Cliente cliente;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LogRegistro getLog() {
		return log;
	}

	public void setLog(LogRegistro log) {
		this.log = log;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getIsGestao() {
		return isGestao;
	}

	public void setIsGestao(Boolean isGestao) {
		this.isGestao = isGestao;
	}

}
