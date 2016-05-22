package com.kata.model;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class AbstractBean {

	@Id
	private Long id;

	@PrePersist
	public void ensureId() {
		if (id == null) {
			id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
