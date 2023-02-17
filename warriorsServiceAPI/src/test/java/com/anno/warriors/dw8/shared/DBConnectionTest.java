package com.anno.warriors.dw8.shared;

import static com.anno.warriors.dw8.shared.DBConstants.TABLES.AFFINITY;
import static com.anno.warriors.dw8.shared.DBConstants.TABLES.ATTRIBUTES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.warriors.dw8.attributes.dao.AttributesDAO;
import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

class DBConnectionTest {

	@BeforeEach
	void setUp() throws Exception {
		DBConnection.connectToDB();
	}

	@Test
	void testIfConnectionIsTrue() {
		try {
			assertTrue(DBConnection.isConnected());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testIfConnectionIsDisconnected() {
		try {
			DBConnection.disconnect();
			assertFalse(DBConnection.isConnected());
			assertNull(DBConnection.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRetrieveFromDB_AFFINITY() {
		try {
			String query = "SELECT * FROM " + DBConstants.getTable(AFFINITY) + ";";
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			assertNotNull(rs);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	void testRetrieveFromDB_ATTRIBUTE_WHERE() {
		String key = "Awareness";
//		String key = "Thorns";
		try {
			String query = "SELECT * FROM " + DBConstants.getTable(ATTRIBUTES)
					+ String.format(" WHERE ATTR_NAME ='%s'", key) + ";";
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			AttributeInterface actual = null;
			while (rs.next()) {
				String name = rs.getString("ATTR_NAME");
				String desc = rs.getString("ATTR_DESC");
				String type = rs.getString("ATTR_TYPE");
				actual = new Attribute(name, desc, type);
				System.out.printf("%s\n", actual.toString());
			}
//			AttributeInterface a = new AttributesDAO().getNormalAttributesByNames(actual.getName()).get(0);
//			assertEquals(a, actual);
//			System.out.printf("%s\n%s\n", a.toString(), actual.toString());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
