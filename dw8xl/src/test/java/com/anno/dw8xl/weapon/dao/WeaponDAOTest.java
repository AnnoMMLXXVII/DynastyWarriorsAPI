/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.shared.Postman;
import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.model.AbNormal;
import com.anno.dw8xl.weapon.model.Normal;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
class WeaponDAOTest {

	private WeaponDAOInterface dao;
	private String expectedNormalJSON;
	private String expectedAbNormalJSON;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = WeaponDAO.getInstance();
		expectedNormalJSON = new String("{\n" + "    \"state\": \"normal\",\n" + "    \"name\": \"Razor Dance\",\n"
				+ "    \"baseAttack\": 14,\n" + "    \"type\": {\n" + "        \"state\": \"type\",\n"
				+ "        \"name\": \"Flying Swords\",\n" + "        \"category\": {\n"
				+ "            \"state\": \"category\",\n" + "            \"category\": \"Dasher\"\n" + "        }\n"
				+ "    },\n" + "    \"star\": 1,\n" + "    \"length\": {\n" + "        \"state\": \"length\",\n"
				+ "        \"size\": \"4'5\\\"\"\n" + "    },\n" + "    \"affinity\": {\n"
				+ "        \"state\": \"affinity\",\n" + "        \"name\": \"?\"\n" + "    },\n"
				+ "    \"rarity\": {\n" + "        \"state\": \"rarity\",\n" + "        \"type\": \"Normal\"\n"
				+ "    }\n" + "}");
		expectedAbNormalJSON = new String("{\n" + "    \"state\": \"abnormal\",\n" + "    \"name\": \"Crystal Fan\",\n"
				+ "    \"baseAttack\": 41,\n" + "    \"type\": {\n" + "        \"state\": \"type\",\n"
				+ "        \"name\": \"War Fan\",\n" + "        \"category\": {\n"
				+ "            \"state\": \"category\",\n" + "            \"category\": \"Dasher\"\n" + "        }\n"
				+ "    },\n" + "     \"star\": 5,\n" + "        \"affinity\": {\n"
				+ "            \"state\": \"affinity\",\n" + "            \"name\": \"Earth\"\n" + "        },\n"
				+ "        \"rarity\": {\n" + "            \"state\": \"rarity\",\n"
				+ "            \"type\": \"Unique\"\n" + "        },\n" + "        \"length\": {\n"
				+ "            \"state\": \"length\",\n" + "            \"size\": \"---\"\n" + "        }\n" + "}");
	}

	@DisplayName("Get all Weapons...")
	@Test
	void testGetAllWeapons() {
		Collection<WeaponI> weapons = dao.getAll();
		assertEquals(690, weapons.size());
	}
	
	@DisplayName("Get Type Hash...")
	@Test
	void testGetTypeHashWeapons() {
		Map<TypeI, List<WeaponI>> hash = dao.getTypeHash();
		assertEquals(67, hash.size());
	}

	@DisplayName("Test Parsed JSON exists [Normal]...")
	@Test
	void testGetParsedJSONExists_Normal() {
		WeaponI actual = dao.deserializeWeapon(expectedNormalJSON);
		assertEquals("Razor Dance", actual.getName());
	}

	@DisplayName("Test Parsed JSON exists [AbNormal]...")
	@Test
	void testGetParsedJSONExists_AbNormal() {
		WeaponI actual = dao.deserializeWeapon(expectedAbNormalJSON);
		assertEquals("Crystal Fan", actual.getName());
	}

	@Test
	void givenJsonArray_whenDeserializingAsArray_thenCorrect()
			throws JsonParseException, JsonMappingException, IOException {
		Collection<WeaponI> weapons = dao.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(weapons);
		WeaponI[] asArray = mapper.readValue(jsonArray, WeaponI[].class);
		assertTrue(asArray[0] instanceof WeaponI);
	}

	@Test
	void testComparePostmanAndFileReader() throws JsonMappingException, JsonProcessingException {
		dao.getAll();
		dao.deserializeWeaponsList(Postman.getPostmanList());
		List<WeaponI> weapons = new ArrayList<>(dao.getWeapons().values());
		List<WeaponI> postman = new ArrayList<>(dao.getPostman().values());
		Collections.sort(weapons, new Comparator<WeaponI>() {
			@Override
			public int compare(WeaponI o, WeaponI o1) {
				return o.getName().toLowerCase().trim().compareTo(o1.getName().toLowerCase().trim());
			}
		});
		Collections.sort(postman, new Comparator<WeaponI>() {
			@Override
			public int compare(WeaponI o, WeaponI o1) {
				return o.getName().toLowerCase().trim().compareTo(o1.getName().toLowerCase().trim());
			}
		});
		assertEquals(postman.size(), weapons.size());
	}
	
	@DisplayName("Test weapons filter for category - Dasher")
	@Test
	void testWeaponFilterByCategory_Dasher() {
		Collection<WeaponI> dashers = dao.getWeaponsByCategory("Dasher");
		assertTrue(!dashers.isEmpty());
	}
	
	@DisplayName("Test weapons filter for Type - Sword")
	@Test
	void testWeaponFilterByType_Sword() {
		Collection<WeaponI> swords = dao.getWeaponsByType("Sword");
		assertTrue(!swords.isEmpty());
	}
	
	@DisplayName("Test weapons filter for State - Normal")
	@Test
	void testWeaponFilterByState_Normal() {
		Collection<WeaponI> states = dao.getWeaponsByState("Normal");
		assertTrue(!states.isEmpty());
	}
	
	@DisplayName("Test weapons filter for Star - 5")
	@Test
	void testWeaponFilterByStar_5() {
		Collection<WeaponI> weapons = dao.getWeaponsByStar(5);
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter for State - Normal")
	@Test
	void testWeaponFilterByAffinity_Man() {
		Collection<WeaponI> weapons = dao.getWeaponsByAffinity("man");
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter with Base Attack Equal to - 30")
	@Test
	void testWeaponFilterByBaseAttackEqualTo_Thirty() {
		Collection<WeaponI> weapons = dao.getWeaponsWithBaseAttack(30);
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter with Base Attack Greater than - 30")
	@Test
	void testWeaponFilterByBaseAttackGreaterThan_Thirty() {
		Collection<WeaponI> weapons = dao.getWeaponsWithBaseAttackGreaterThan(30, false);
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter with Base Attack Greater than (inclusive) - 30")
	@Test
	void testWeaponFilterByBaseAttackGreaterThanInclusive_Thirty() {
		Collection<WeaponI> weapons = dao.getWeaponsWithBaseAttackGreaterThan(30, true);
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter with Base Attack Less than - 30")
	@Test
	void testWeaponFilterByBaseAttackLessThan_Thirty() {
		Collection<WeaponI> weapons = dao.getWeaponsWithBaseAttackLessThan(30, false);
		assertTrue(!weapons.isEmpty());
	}
	
	@DisplayName("Test weapons filter with Base Attack Less than (inclusive) - 30")
	@Test
	void testWeaponFilterByBaseAttackLessThanInclusive_Thirty() {
		Collection<WeaponI> weapons = dao.getWeaponsWithBaseAttackLessThan(30, true);
		assertTrue(!weapons.isEmpty());
	}
	

	@DisplayName("Test adding new Weapon [Void]...")
	@Test
	void testAddNewWeapon() {
		Collection<WeaponI> weapons = dao.getAll();
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, new Type("", new Category("")));
		dao.add(expected);
		weapons = dao.getAll();
		int size = weapons.size();
		assertEquals(691, size);
	}

	@DisplayName("Test adding new Weapon [Void] -> Affinity == Expected")
	@Test
	void testAddNewWeapon_AffinityEqualsExpected() {
		WeaponI expected = new Normal("VOID", 70, new Length("10\""), 0, new Type("Void", new Category("Void")));
		dao.add(expected);
		assertEquals("?", expected.getAffinity().getName());
	}

	@DisplayName("Test adding new Weapon [Null] -> NULL POINTER EXCEPTION")
	@Test
	void testAddNewWeapon_ThrowsNPE() {
		WeaponI expected = null;
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to Null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon [Void] -> Null Type")
	@Test
	void testAddNewWeapon_ThrowsNPE_Type() {
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, null);
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to type being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon [Void] -> Null Value for Type ")
	@Test
	void testAddNewWeapon_ThrowsNPE_Type_value() {
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, new Type(null));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to type being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon [Void] -> Null Type Object")
	@Test
	void testAddNewWeapon_ThrowsNPE_NullType() {
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, new NullType());
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to type being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon [Void] -> Null Category")
	@Test
	void testAddNewWeapon_ThrowsNPE_Cateogry_NULL() {
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, new Type("", null));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to category being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon [Void] -> Null Value for Category")
	@Test
	void testAddNewWeapon_ThrowsNPE_Cateogry_NULL_value() {
		WeaponI expected = new Normal("VOID", -1, new Length("-1"), 0, new Type("", new Category(null)));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to category being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon Abnormal [Void] -> Null Affinity")
	@Test
	void testAddNewWeapon_Abnormal_null_affinity() {
		WeaponI expected = new AbNormal("VOID", -1, null, 0, new Type("", new Category("")), new Rarity("VOID"));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to affinity being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon Abnormal [Void] -> Null value for Affinity")
	@Test
	void testAddNewWeapon_Abnormal_null_affinity_value() {
		WeaponI expected = new AbNormal("VOID", -1, new Affinity(null), 0, new Type("", new Category("")),
				new Rarity("VOID"));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to affinity being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon Abnormal [Void] -> Null Rarity")
	@Test
	void testAddNewWeapon_AbnormalNullRarity() {
		WeaponI expected = new AbNormal("VOID", -1, new Affinity(""), 0, new Type("", new Category("")), null);
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to rarity being null!", e.getMessage());
	}

	@DisplayName("Test adding new Weapon Abnormal [Void] -> Null value for Rarity")
	@Test
	void testAddNewWeapon_AbnormalNullValueRarity() {
		WeaponI expected = new AbNormal("VOID", -1, new Affinity(""), 0, new Type("", new Category("")),
				new Rarity(null));
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(expected);
		});
		assertEquals("Weapon cannot be added due to rarity being null!", e.getMessage());
	}

	@DisplayName("Test Weapon remove --> Null ")
	@Test
	void testRemoveWeapon_Null() {
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.remove(null);
		});
		assertEquals("Weapon cannot be removed due to Null!", e.getMessage());
	}

	@DisplayName("Test Weapon remove --> Null Value")
	@Test
	void testRemoveWeapon_NullValue() {
		WeaponI expected = null;
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.remove(expected);
		});
		assertEquals("Weapon cannot be removed due to Null!", e.getMessage());
	}

	@DisplayName("Test Weapon remove --> Does not Exist")
	@Test
	void testRemoveWeapon_NonExistent() {
		Collection<WeaponI> weapons = dao.getAll();
		int size = weapons.size();
		WeaponI expected = new AbNormal("VOID", -1, new Affinity("VOID"), 0, new Type("", new Category("")),
				new Rarity("VOID"));
		dao.remove(expected);
		weapons = dao.getAll();
		assertEquals(size, weapons.size());
	}

}
