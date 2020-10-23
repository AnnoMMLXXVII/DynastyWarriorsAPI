/**
 * 
 */
package com.anno.dw8xl.dao;

import java.util.Collection;
import java.util.Optional;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface DAO <E, V> {

	public Collection<E> getAll();
	public Optional<E> getBy(V criteria);
	public void add(E entity);
	public void remove(E entity);
	
}
