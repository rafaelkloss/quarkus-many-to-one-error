package com.proposito.model.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.proposito.model.core.feature.Feature;
import com.proposito.model.usuario.Usuario;

@DiscriminatorValue(value = "MATRIZ")
@Entity(name = "Matriz")
public class Matriz extends Cliente {

	@Column(length = 125)
	private URL site;

	@Column(length = 120, nullable = false, updatable = false, unique = true)
	private String slug;

	/**
	 * Url da logo
	 */
	@Column(name = "logo", nullable = true, length = 255)
	private String logo;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "`idResponsavel`")
	private Usuario responsavel;

	@Column(length = 20)
	private String cnpj;

	/**
	 * User no banco de dados firebase
	 */
	@Column(length = 100, name = "`firebaseUser`")
	private String firebaseUser;

	/**
	 * Senha no banco de dados firebase
	 */
	@Column(length = 100, name = "`firebasePassword`")
	private String firebasePassword;

	/**
	 * User no banco de dados firebase
	 */
	@Column(length = 100, name = "`dominioEmail`", nullable = false)
	private String dominioEmail;

	@OneToMany(targetEntity = Filial.class, cascade = CascadeType.ALL, mappedBy = "matriz", fetch = FetchType.LAZY)
	private List<Filial> filiais = new ArrayList<Filial>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cliente_features", joinColumns = @JoinColumn(name = "`idCliente`"))
	@MapKeyColumn(name = "`idFeature`", length = 50)
	@MapKeyClass(Feature.class)
	@Column(name = "`nomeCustomizado`", nullable = false, length = 155)
	@MapKeyEnumerated(EnumType.STRING)
	private Map<Feature, String> features = new HashMap<>();

	/**
	 * Empresa modo de sandbox para criar usuários sem email válido e outros ítens
	 * como celular, etc...
	 */
	@Column(nullable = false)
	@ColumnDefault(value = "false")
	private Boolean sandbox = false;

	public URL getSite() {
		return site;
	}

	public void setSite(URL site) {
		this.site = site;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Filial> filiais) {
		this.filiais = filiais;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Map<Feature, String> getFeatures() {
		return features;
	}

	public void setFeatures(Map<Feature, String> features) {
		this.features = features;
	}

	public Boolean getSandbox() {
		return sandbox;
	}

	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}

	public String getFirebaseUser() {
		return firebaseUser;
	}

	public void setFirebaseUser(String firebaseUser) {
		this.firebaseUser = firebaseUser;
	}

	public String getFirebasePassword() {
		return firebasePassword;
	}

	public void setFirebasePassword(String firebasePassword) {
		this.firebasePassword = firebasePassword;
	}

	public String getDominioEmail() {
		return dominioEmail;
	}

	public void setDominioEmail(String dominioEmail) {
		this.dominioEmail = dominioEmail;
	}

	/**
	 * Adiciona uma nova {@link Role} para o usuário em questão
	 * 
	 * @param role
	 */
	public void addFeature(final Feature feature, final String descricao) {
		if (null != descricao) {
			this.features.put(feature, descricao);
			return;
		}
		this.features.put(feature, feature.getDescricao());
	}

}
