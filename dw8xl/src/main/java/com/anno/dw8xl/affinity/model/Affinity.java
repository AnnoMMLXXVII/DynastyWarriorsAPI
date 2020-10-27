package com.anno.dw8xl.affinity.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

@Component
@JsonView(CharacterView.Affinity.class)
public class Affinity implements AffinityI {

	@JsonView({CharacterView.Weapon.Affinity.class})
	private String name;

	protected Affinity() {
		/*
		 * Empty Constructor
		 * Security Reasons
		 * Sonar Resolve Compilation
		 */
	}

	/**
	 * @param affinity
	 */
	public Affinity(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affinity other = (Affinity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
