package com.anno.warriors.dw8.database;

public class DatabaseDYNConstants {

	private static final String SCHEMA = "DYN";
	protected static final String DATABASE = "DYN_WARRIORS_SERVICE";
	protected static String HOST = System.getProperty("HOST");

	public static final String NORMAL = "Normal";
	public static final String SPECIAL = "Special";

	public static enum TABLES {
		AFFINITY, ATTRIBUTES
	}

	private static final String ATTRIBUTENAME = "ATTRNAME";
	private static final String ATTRIBUTEDESC = "ATTRDESC";
	private static final String ATTRIBUTETYPE = "ATTRTYPE";
	private static final String AFFINITYNAME = "AFFINITYNAME";

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
