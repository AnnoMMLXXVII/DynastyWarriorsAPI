package com.anno.warriors.dw8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class JDBCManager {

	private static final String PREFIX = "jdbc:postgresql";
	private static final String PORT = "26257";
	private static final String SSL_MODE_FULL = "sslmode=verify-full";
	private static final String SSL_MODE_REQUIRE = "sslmode=require";
	private static String url;
	private static Connection connection = null; // Connection Interface
	private static PreparedStatement preparedStatement;

	public static void openConnection() throws SQLException {
		PGSimpleDataSource ds = new PGSimpleDataSource();
		url = PREFIX + "://" + DatabaseDYNConstants.HOST + ":" + PORT + "/" + DatabaseDYNConstants.DATABASE + "?"
				+ SSL_MODE_REQUIRE;
		ds.setUrl(url);
		ds.setUser(System.getProperty("DB_USER"));
		ds.setPassword(System.getProperty("DB_KEY"));
		connection = ds.getConnection();
	}

	/**
	 * Returns the Connection
	 *
	 * @return Connection
	 * @throws SQLException SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return connection;
	}

	/**
	 * Closes the Connection
	 */
	public static void closeConnection() {
		try {
			connection.close();
//			getApplicationLogger().logINFO("Closed Database Connection");
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQLError:" + e.getMessage());
		}
	}

	/**
	 * Creates a PreparedStatement
	 *
	 * @param sqlStatement String
	 * @param conn         Connection
	 * @throws SQLException SQLException
	 */
	public static void makePreparedStatement(String sqlStatement, Connection conn) throws SQLException {
		if (conn != null) {
			preparedStatement = conn.prepareStatement(sqlStatement);
		} else {
		}
	}

	/**
	 * Returns the PreparedStatement
	 *
	 * @return PreparedStatement
	 * @throws NullPointerException NullPointerException
	 */
	public static PreparedStatement getPreparedStatement() throws NullPointerException {
		if (preparedStatement != null) {
//			getApplicationLogger().logINFO("Retrieving Prepared Statement");
			return preparedStatement;
		} else {
//			getApplicationLogger().logERROR("Null reference to Prepared Statement");
			return null;
		}
	}

}
