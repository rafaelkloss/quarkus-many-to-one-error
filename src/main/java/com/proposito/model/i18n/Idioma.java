package com.proposito.model.i18n;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proposito.model.AbstractModel;

@Entity
@Table(name = "idioma")
@Cacheable
public class Idioma extends AbstractModel {

	@Id
	@SequenceGenerator(name = "idiomaSequence", sequenceName = "idioma_id_seq", allocationSize = 1, initialValue = 4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idiomaSequence")
	private Integer id;

	@Column(length = 30, nullable = false)
	private String nome;

	@Column(length = 30, nullable = false)
	private String original;

	@Column(nullable = false)
	private Boolean ativo = true;

	@Column(length = 6, nullable = false)
	private String iso;

	@Column(length = 60)
	private String descricao;

	public Idioma() {
	}

	public Idioma(Integer id) {
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

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
