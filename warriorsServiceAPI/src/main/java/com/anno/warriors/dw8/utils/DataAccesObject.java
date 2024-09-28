package com.anno.warriors.dw8.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;

/**
 * 
 * @author Haku Wei
 *
 * @param <T>
 */
public interface DataAccesObject<T> {

	/**
	 * @return ObservableList T
	 */
	List<T> getAll();

	/**
	 * @param id Integer
	 * @return T
	 */
	T getById(int id);

	/**
	 * @param object T
	 * @return boolean
	 */
	boolean create(T object);

	/**
	 * @param object T
	 * @return boolean
	 */
	boolean update(T object);

	/**
	 * @param id Integer
	 * @return boolean
	 */
	boolean removeById(int id);
	
	boolean removeById(String id);

	/**
	 * @param rs ResultSet
	 * @return T
	 * @throws SQLException Exception
	 */
	T getAllColumnsUsingResultSet(ResultSet rs) throws SQLException;

	/**
	 * @param ps     PreparedStatement
	 * @param object T
	 * @throws SQLException Exception
	 */
	void executeModificationQuery(PreparedStatement ps, T z) throws SQLException;

	/**
	 * @param column DB_COLUMNS
	 * @param value  Object
	 * @return boolean boolean
	 * @throws SQLException Exception
	 */
	boolean removeByCondition(COLUMNS column, String value) throws SQLException;

	/**
	 * Helper method that will reverse look up the T Id by the @param Name Override
	 * toString() method in the Model classes such only the names get returned
	 * Lambda Expression that will find the first Optional T object and return T if
	 * found
	 * 
	 * @param name String
	 * @return T DAO
	 */
	default T getIdFrom(String name) {
		Optional<T> opt = getAll().stream().filter(e -> e.toString().equalsIgnoreCase(name)).findFirst();
		if (opt == null) {
			throw new NullPointerException(String.format("NULL POINTER EXCEPTION: Unable to find %s from the Database", name));
		}
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
}
