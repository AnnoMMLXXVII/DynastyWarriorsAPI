package com.anno.warriors.dw8.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anno.warriors.dw8.database.DBConnection;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.TABLES;
import com.anno.warriors.dw8.database.DatabaseQueries;
import com.anno.warriors.dw8.database.JDBCManager;

public abstract class DAO<T> implements DataAccesObject<T> {
	private T t;
	private List<T> ts;
	protected ResultSet rs;
	protected boolean isAddAction = false;
	protected PreparedStatement ps;
	protected TABLES table;
	protected COLUMNS col_id;
	protected COLUMNS[] composite_id;
	protected int fieldCount = 0;
	protected COLUMNS[] fields;

	@Override
	public List<T> getAll() {
		try {
			DBConnection.connectToDB();
			ts = new ArrayList<>();
			JDBCManager.makePreparedStatement(DatabaseQueries.queryAll(table.name()), JDBCManager.getConnection());
			rs = JDBCManager.getPreparedStatement().executeQuery();
			while (rs.next()) {
				ts.add(getAllColumnsUsingResultSet(rs));
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} catch (NullPointerException e) {
//			getApplicationLogger().logERROR("NULL EXCEPTION" + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return ts;
	}

	@Override
	public T getById(int id) {
		try {
			JDBCManager.openConnection();
			JDBCManager.makePreparedStatement(
					DatabaseQueries.queryAllByCondition(table.name(), this.col_id.name(), String.format("%s", id)),
					JDBCManager.getConnection());
			rs = JDBCManager.getPreparedStatement().executeQuery();
			while (rs.next()) {
				t = getAllColumnsUsingResultSet(rs);
				if (t == null) {
//					getApplicationLogger().logERROR("NULL EXCEPTION Using ID " + id);
					throw new NullPointerException("Could not retrieve Appointment By ID : " + id);
				}
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return t;
	}

	@Override
	public boolean create(T object) {
		try {
			JDBCManager.openConnection();
			JDBCManager.makePreparedStatement(DatabaseQueries.createInsertQuery(this.table.name(), this.fieldCount),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			isAddAction = true;
			executeModificationQuery(ps, object);
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}

	@Override
	public abstract boolean update(T object);

	@Override
	public boolean removeById(int id) {
		try {
			JDBCManager.openConnection();
			JDBCManager.makePreparedStatement(
					DatabaseQueries.createDeleteQueryByCondition(this.table.name(), this.col_id.name(), id + ""),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}

	@Override
	public boolean removeById(String id) {
		try {
			JDBCManager.openConnection();
			JDBCManager.makePreparedStatement(
					DatabaseQueries.createDeleteQueryByCondition(this.table.name(), this.col_id.name(), id + ""),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}

	public boolean removeByCondition(COLUMNS column, String value) {
		try {
			JDBCManager.openConnection();
			JDBCManager.makePreparedStatement(
					DatabaseQueries.createDeleteQueryByCondition(this.table.name(), column.name(), value.toString() + ""),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}

	@Override
	public abstract T getAllColumnsUsingResultSet(ResultSet rs) throws SQLException;

	@Override
	public abstract void executeModificationQuery(PreparedStatement ps, T z) throws SQLException;

	protected boolean update(T t, int object_id) {
		try {
			JDBCManager.openConnection();
			isAddAction = false;
			JDBCManager.makePreparedStatement(DatabaseQueries.createUpdateQuery(table.name(), col_id.name(), object_id + "", fields),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			executeModificationQuery(ps, t);
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}

	protected boolean update(T t, String object_id) {
		try {
			JDBCManager.openConnection();
			isAddAction = false;
			JDBCManager.makePreparedStatement(DatabaseQueries.createUpdateQuery(table.name(), col_id.name(), object_id + "", fields),
					JDBCManager.getConnection());
			ps = JDBCManager.getPreparedStatement();
			executeModificationQuery(ps, t);
			ps.execute();
			if (ps.getUpdateCount() > 0) {
				return true;
			}
		} catch (SQLException e) {
//			getApplicationLogger().logERROR("SQL EXCEPTION : " + e.getMessage());
		} finally {
			JDBCManager.closeConnection();
		}
		return false;
	}
}
