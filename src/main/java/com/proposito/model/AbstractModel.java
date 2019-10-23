package com.proposito.model;

import java.util.Objects;


public abstract class AbstractModel {

	
	public abstract Integer getId();

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AbstractModel abs = (AbstractModel) o;
		if (null == getId() || null == abs.getId()) {
			return false;
		}
		return Objects.equals(getId(), abs.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
