package com.anno.warriors.dw8.shared;

public class DBConstants {

	private static final String SCHEMA = "DYN";
	static final String DATABASE = "DYN_WARRIORS_SERVICE";

	static String HOST = System.getProperty("HOST");

	public static enum TABLES {
		AFFINITY,ATTRIBUTES
	}

	static String getTable(TABLES table) {
		return "\"" + DATABASE + "\".\"" + SCHEMA + "\"." + table.toString().toLowerCase();
	}

}
