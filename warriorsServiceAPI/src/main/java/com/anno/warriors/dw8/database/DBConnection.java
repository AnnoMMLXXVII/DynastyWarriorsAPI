package com.anno.warriors.dw8.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class DBConnection {
	private static final String PREFIX = "jdbc:postgresql";
	private static final String PORT = "26257";
	private static final String SSL_MODE_FULL = "sslmode=verify-full";
	private static final String SSL_MODE_REQUIRE = "sslmode=require";
	private static Connection conn;

	public static void connectToDB() throws SQLException {
		PGSimpleDataSource ds = new PGSimpleDataSource();
		String url = PREFIX + "://" + DatabaseDYNConstants.HOST + ":" + PORT + "/" + DatabaseDYNConstants.DATABASE + "?"
				+ SSL_MODE_REQUIRE;
		ds.setUrl(url);
		ds.setUser(System.getProperty("DB_USER"));
		ds.setPassword(System.getProperty("DB_KEY"));
		conn = ds.getConnection();
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void disconnect() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	public static boolean isConnected() throws SQLException {
		return conn != null && !conn.isClosed();
	}

}
