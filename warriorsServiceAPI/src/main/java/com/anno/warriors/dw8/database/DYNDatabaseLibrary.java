package com.anno.warriors.dw8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.TABLES;

/**
 * 
 * @author Haku Wei
 * 
 *         Class to house a list of methods that can be reused.
 *
 */
public class DYNDatabaseLibrary {

	private static Logger logger = LogManager.getLogger();
	private static final String SELECT_ALL_PREFIX = "SELECT * FROM ";
	private static final String DELETE_FROM = "DELETE FROM";
	private static final String UPDATE_PREFIX = "UPDATE ";
	private static final String WHERE = "WHERE";
	private static final String LIKE = "LIKE";
	private static final String IN = "IN";
	private static final String SET = "SET";
	private static final String INSERT = "INSERT";
	private static final String INTO = "INTO";
	private static final String VALUES = "VALUES";
	private static final String PLACEHOLDER = "?";
	private static final String AND = "AND";
	private static final String PLACEHOLDER_WITH_COMMA = PLACEHOLDER + ",";
	private static PreparedStatement ps;
	// SELECT

	public static ResultSet executeSelectAll(TABLES table) {
		final String query = SELECT_ALL_PREFIX + DatabaseDYNConstants.getTable(table) + ";";
		return executeRetrieveCall(query);
	}

	public static ResultSet executeSelectAllWhere(TABLES table, COLUMNS column, String value) {
		String where = String.format(" %s %s = ?", WHERE, column.getColumn());
		final String query = SELECT_ALL_PREFIX + DatabaseDYNConstants.getTable(table) + where + ";";
		return executeRetrieveCall(query, value);
	}

	public static ResultSet executeSelectAllWhereLike(TABLES table, COLUMNS column, String value) {
		String where = String.format(" %s %s %s %%?%%", WHERE, column.getColumn(), LIKE);
		final String query = SELECT_ALL_PREFIX + DatabaseDYNConstants.getTable(table) + where + ";";
		return executeRetrieveCall(query, value);
	}

	public static ResultSet executeSelectAllWhere(TABLES table, COLUMNS column, String... values) {
		String placeHolder = formatPlaceHolderValues(values.length);
		String where = String.format(" %s %s %s ( %s )", WHERE, column.getColumn(), IN, placeHolder);
		final String query = SELECT_ALL_PREFIX + DatabaseDYNConstants.getTable(table) + where + ";";
		return executeRetrieveCall(query, values);
	}

	// CREATE
	public static boolean executeInsert(TABLES table, Object[] columns, Object... values) {
		final String column = formatValuesLikeCSV(columns);
		final String value = formatInsertValues(values, columns.length);
		final String query = String.format("%s %s %s (%s) %s %s;", INSERT, INTO, DatabaseDYNConstants.getTable(table),
				column, VALUES, value);
		return executeQueryUpdate(query);
	}

	// UPDATE
	public static boolean executeUpdate(TABLES table, COLUMNS pk, String pkValue, Object[] columns, Object... values) {
		if (columns.length != values.length) {
			return false;
		}
		String where = String.format("%s %s='%s'", WHERE, pk.getColumn(), pkValue);
		String fields = String.format(" %s %s ", SET, formatMultiColumnAssignmentClause(columns, values));
		final String query = UPDATE_PREFIX + DatabaseDYNConstants.getTable(table) + fields + where + ";";
		return executeQueryUpdate(query);
	}

	private static void closeDB(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				DBConnection.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DELETE
	public static boolean executeDelete(TABLES table, Object[] columns, Object[] values) {
		final String whereClause = formatMultiColumnAssignmentClause(columns, values);
		final String query = String.format("%s %s %s %s;", DELETE_FROM, DatabaseDYNConstants.getTable(table), WHERE,
				whereClause);
		return executeQueryUpdate(query);
	}

	/**
	 * Creates n placeholder values and trims last comma
	 * 
	 * @param size
	 * @return
	 */
	private static String formatPlaceHolderValues(int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(PLACEHOLDER_WITH_COMMA);
		}
		return sb.substring(0, sb.length() - 1);
	}

	private static String formatValuesLikeCSV(Object[] columns) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			sb.append(columns[i].toString() + ",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	private static String formatInsertValues(Object[] values, int numberOfColumns) {
		assert values.length % numberOfColumns == 0;
		int quotient = values.length / numberOfColumns;
		StringBuilder formatted = new StringBuilder();
		int i = 0;
		while (i < quotient) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < numberOfColumns; j++) {
				sb.append("'" + values[j] + "',");
				i = j;
			}
			formatted.append("(" + sb.substring(0, sb.length() - 1) + "),");
		}

		return formatted.substring(0, formatted.length() - 1);
	}

	private static String formatMultiColumnAssignmentClause(Object[] columns, Object[] values) {
		assert columns.length == values.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			sb.append(String.format("%s='%s' %s", columns[i], values[i], AND));
		}
		return sb.substring(0, sb.length() - AND.length()).trim();
	}

	private static ResultSet executeRetrieveCall(String query, String... values) {
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try {
			if (conn == null) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			if (values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					ps.setString(i + 1, values[i]);
				}
			}
			logger.info("QUERY: {}", query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
		return rs;
	}

	private static boolean executeQueryUpdate(String query) {
		Connection conn = DBConnection.getConnection();
		boolean isUpdated = false;
		try {
			if (conn == null || !DBConnection.isConnected()) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			logger.info("QUERY: {}", query);
			isUpdated = ps.execute();
			if (isUpdated) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
		return isUpdated;
	}

}
