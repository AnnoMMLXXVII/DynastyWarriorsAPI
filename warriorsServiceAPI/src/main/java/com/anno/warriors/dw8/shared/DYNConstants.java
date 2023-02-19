package com.anno.warriors.dw8.shared;

public class DYNConstants {

	private static final String SCHEMA = "DYN";
	static final String DATABASE = "DYN_WARRIORS_SERVICE";
	static String HOST = System.getProperty("HOST");

	public static final String NORMAL = "Normal";
	public static final String SPECIAL = "Special";

	public static enum TABLES {
		AFFINITY, ATTRIBUTES
	}

	public static enum COLUMNS {
		ATTRNAME("ATTR_NAME"), ATTRDESC("ATTR_DESC"), ATTRTYPE("ATTR_TYPE"), AFFINITYNAME("NAME");

		private String columnName;

		COLUMNS(String databaseColumnName) {
			this.columnName = databaseColumnName;
		}

		public String getColumn() {
			return columnName;
		}
	}

	public static String getTable(TABLES table) {
		return "\"" + DATABASE + "\".\"" + SCHEMA + "\"." + table.toString().toLowerCase();
	}

}
