package com.anno.warriors.dw8.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anno.warriors.dw8.shared.DYNConstants.COLUMNS;
import com.anno.warriors.dw8.shared.DYNConstants.TABLES;

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
	private static final String UPDATE_PREFIX = "UPDATE ";
	private static final String WHERE = "WHERE";
	private static final String LIKE = "LIKE";
	private static final String IN = "IN";
	private static final String SET = "SET";
	private static PreparedStatement ps;
	// SELECT

	public static ResultSet executeSelectAll(TABLES table) {
		final String query = SELECT_ALL_PREFIX + DYNConstants.getTable(table) + ";";
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try {
			if (conn == null) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			logger.info("QUERY: {}", query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
		return rs;
	}

	public static ResultSet executeSelectAllWhere(TABLES table, COLUMNS column, String value) {
		String where = String.format(" %s %s = ?", WHERE, column.getColumn());
		final String query = SELECT_ALL_PREFIX + DYNConstants.getTable(table) + where + ";";
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try {
			if (conn == null) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, value);
			logger.info("QUERY: {}", query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
		return rs;
	}

	public static ResultSet executeSelectAllWhereLike(TABLES table, COLUMNS column, String value) {
		String where = String.format(" %s %s %s %%?%%", WHERE, column.getColumn(), LIKE);
		final String query = SELECT_ALL_PREFIX + DYNConstants.getTable(table) + where + ";";
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try {
			if (conn == null) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, value);
			logger.info("QUERY: {}", query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(conn);
		}
		return rs;
	}

	public static ResultSet executeSelectAllWhere(TABLES table, COLUMNS column, String... values) {
		StringBuilder sb = new StringBuilder();
		for (String s : values) {
			sb.append("?,");
		}
		String where = String.format(" %s %s %s ( %s )", WHERE, column.getColumn(), IN,
				sb.substring(0, sb.length() - 1));
		final String query = SELECT_ALL_PREFIX + DYNConstants.getTable(table) + where + ";";
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try {
			if (conn == null) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
			for (int i = 0; i < values.length; i++) {
				ps.setString(i + 1, values[i]);
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

	// UPDATE
	public static boolean executeUpdate(TABLES table, COLUMNS pk, String pkValue, Object[] columns, Object... values) {
		if (columns.length != values.length) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			sb.append(((COLUMNS) columns[i]).getColumn() + "='" + (String) values[i] + "',");
		}
		String where = String.format("%s %s='%s'", WHERE, pk.getColumn(), pkValue);
		String fields = String.format(" %s %s ", SET, sb.toString().substring(0, sb.length() - 1));
		final String query = UPDATE_PREFIX + DYNConstants.getTable(table) + fields + where + ";";
		Connection conn = DBConnection.getConnection();
		boolean isUpdated = false;
		try {
			if (conn == null || !DBConnection.isConnected()) {
				DBConnection.connectToDB();
				conn = DBConnection.getConnection();
			}
			ps = conn.prepareStatement(query);
//			for (int i = 0; i < values.length; i++) {
//				ps.setString(i + 1, (String) values[i]);
//			}
//			ps.setString(values.length + 1, pkValue); // Where value
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

	private static void closeDB(Connection conn) {
		try {
			conn.close();
			DBConnection.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DELETE

}
