package com.anno.dw8xl.dao;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface DataAccessObjectInterface <E, V> {
	public Collection<E> getAll();

	public Optional<E> getBy(V criteria);

	public void add(E entity);

	public void remove(E entity);

	static <K, V> K getKey(Map<K, V> map, V value) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	static String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	

}
