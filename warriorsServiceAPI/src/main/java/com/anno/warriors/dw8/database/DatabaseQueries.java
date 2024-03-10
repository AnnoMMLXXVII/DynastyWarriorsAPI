package com.anno.warriors.dw8.database;

import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.TABLES;

public class DatabaseQueries {

	/**
	 * @param table String
	 * @return String
	 */
	public static String queryAll(String table) {
		String query = String.format("SELECT * FROM %s", table);
		return query;
	}

	/**
	 *
	 * @param table          TABLES
	 * @param innerJoinTable TABLES
	 * @param joinPK         COLUMNS
	 * @param joinPKValue    String
	 * @return String
	 */
	public static String queryAllWithInnerJoin(TABLES table, TABLES innerJoinTable, COLUMNS joinPK,
			String joinPKValue) {
		String join = appendInnerJoin(table.name(), innerJoinTable.name(), joinPK.name());
		String query = String.format("%s %s %s", String.format("SELECT * FROM %s", table), join,
				!(joinPKValue.isBlank() || joinPKValue == null || joinPKValue.isEmpty() || join.equals(""))
						? String.format("WHERE %s.%s = %s", innerJoinTable, joinPK.name(), joinPKValue)
						: "");
		return query;
	}

	/**
	 * @param table   String
	 * @param colName String
	 * @param value   String
	 * @return String
	 */
	public static String queryAllByCondition(String table, String colName, String value) {
		String query = String.format("SELECT * FROM %s WHERE %s = %s", table, colName, value);
		return query;
	}

	/**
	 * @param table   String
	 * @param colName String
	 * @param value   String
	 * @return String
	 */
	public static String queryAllByCondition(String table, String[] colName, String[] value) {
		if (colName.length != value.length) {
			throw new NullPointerException(
					"Unable to create Query with Multiple Col-Val. Columns and Value counts must match!");
//				getApplicationLogger().logERROR
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < colName.length; i++) {
			sb.append(String.format("%s = %s AND", colName[i], value[i]));
		}
		String formattedSB = sb.substring(0, sb.toString().length() - 3);
		String query = String.format("SELECT * FROM %s WHERE %s", table, formattedSB.trim());
		return query;
	}

	/**
	 * @param table   String
	 * @param rsCount Integer
	 * @return String
	 */
	public static String createInsertQuery(String table, int rsCount) {
		String query = String.format("INSERT INTO `%s` VALUES ( %s )", table, createQuestionMarksForQuery(rsCount));
		return query;
	}

	/**
	 * @param table      String
	 * @param primaryKey String
	 * @param value      String
	 * @param COLUMNS    COLUMNS
	 * @return String
	 */
	public static String createUpdateQuery(String table, String primaryKey, String value, COLUMNS... COLUMNS) {
		String query = String.format("UPDATE `%s` SET %s WHERE %s = %s", table,
				createColumnQuestionMarkMapForUpdateQuery(COLUMNS), primaryKey, value);
		return query;
	}

	/**
	 * @param table  String
	 * @param colNum String
	 * @param value  String
	 * @return String
	 */
	public static String createDeleteQueryByCondition(String table, String colNum, String value) {
		String query = String.format("DELETE FROM `%s` WHERE %s = %s", table, colNum, value);
		return query;
	}

	/**
	 * @param COLUMNS COLUMNS
	 * @return String
	 */
	private static String createColumnQuestionMarkMapForUpdateQuery(COLUMNS[] COLUMNS) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < COLUMNS.length; i++) {
			sb.append(String.format("%s=?,", COLUMNS[i].name()));
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * @param count int
	 * @return String
	 */
	private static String createQuestionMarksForQuery(int count) {
		StringBuilder sb = new StringBuilder();
//			sb.append("");
		for (int i = 0; i < count; i++) {
			sb.append("?,");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * @param table     String
	 * @param joinTable String
	 * @param joinPK    String
	 * @return String
	 */
	public static String appendInnerJoin(String table, String joinTable, String joinPK) {
		return (table.isEmpty() || joinTable.isEmpty() || joinPK.isEmpty()) ? ""
				: String.format("INNER JOIN %s ON %s.%s = %s.%s", joinTable, table, joinPK, joinTable, joinPK);
	}
}
