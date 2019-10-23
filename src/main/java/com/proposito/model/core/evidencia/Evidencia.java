package com.proposito.model.core.evidencia;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proposito.model.AbstractModelDeletavel;

@Entity(name = "Evidencia")
@Table(name = "evidencia")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 30)
@Cacheable
public abstract class Evidencia extends AbstractModelDeletavel {

	@Id
	@SequenceGenerator(name = "evidenciaSequence", sequenceName = "evidencia_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evidenciaSequence")
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
