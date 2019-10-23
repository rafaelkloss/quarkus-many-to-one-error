package com.proposito.dto.contract;

/**
 * Interface para DTOs que representem entidades que possuem id
 * 
 * @author kloss
 *
 */
public interface HasIdDTO {

	public abstract void setId(Integer id);

	public abstract Integer getId();

}
