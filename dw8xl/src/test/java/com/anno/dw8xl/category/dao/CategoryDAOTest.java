/**
 * 
 */
package com.anno.dw8xl.category.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;

/**
 * @author Haku Wei
 *
 */
class CategoryDAOTest {

	private CategoryDAO_I dao;
	private CategoryI expected;
	private long start, finish;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dao = CategoryDAO.getInstance();
		expected = new Category("Dasher");
		start = System.nanoTime();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		finish = System.nanoTime();
		System.out.printf("Time : \t%8d\n", (finish - start));
	}

	@DisplayName("Categories is greater than 0")
	@Test
	void testGetAllCategories() {
		List<CategoryI> categories = dao.getAllCategory();
		assertEquals(4, categories.size());
	}

	@DisplayName("Category exists in Categories")
	@Test
	void testCheckIfCategoryExists() {
		assertEquals(true, dao.isExist(expected));
	}
	
	@DisplayName("Category equals Expected [Dasher]")
	@Test
	void testGetCategoryByNameEqualsExpected() {
		CategoryI actual = dao.getCategoryByName("Dasher");
		assertEquals(expected, actual);
	}
	
	@DisplayName("Category !equals Expected [Void]")
	@Test
	void testGetCategoryByNameDoesNotEqualExpected() {
		CategoryI actual = dao.getCategoryByName("Void");
		assertNotEquals(expected, actual);
	}
	
	@DisplayName("Category create Expected [VOID]")
	@Test
	void testCreateCategory() {
		List<CategoryI> categories = dao.getAllCategory();
		dao.createCategory(new Category("Void"));
		categories = dao.getAllCategory();
		assertEquals(5, categories.size());
	}
	
	@DisplayName("Category create FAIL Expected [NULL]")
	@Test
	void testCreateCategory_FAIL_NULL() {
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.createCategory(null);			
		});
		assertEquals("Cannot create Category of Null Value", e.getMessage());
	}
	
	@DisplayName("Category create FAIL Expected [A-z]*25")
	@Test
	void testCreateCategory_FAIL_LENGTH() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			dao.createCategory(new Category("abcefghijklmnopqrstuvwxyz"));			
		});
		assertEquals("Illegal Category name: empty or length(0-24)", e.getMessage());
	}
	
	@DisplayName("Category remove by Name Expected [Dasher] - v1")
	@Test
	void testRemoveExpectedCategory() {
		List<CategoryI> categories = dao.getAllCategory();
		dao.removeCategory("Dasher");
		categories = dao.getAllCategory();
		assertEquals(3, categories.size());
	}
	
	@DisplayName("Category remove by Object Expected [Dasher] - v2")
	@Test
	void testRemoveExpectedCategory_Object() {
		List<CategoryI> categories = dao.getAllCategory();
		dao.removeCategory(expected);
		categories = dao.getAllCategory();
		assertEquals(3, categories.size());
	}
	
	@DisplayName("Category remove by Name FAIL for Expected [VOID]")
	@Test
	void testRemoveExpectedCategory_FAIL() {
		List<CategoryI> categories = dao.getAllCategory();
		dao.removeCategory("Void");
		categories = dao.getAllCategory();
		assertEquals(4, categories.size());
	}
	
	@DisplayName("Category remove by Object FAIL for Expected [VOID]")
	@Test
	void testRemoveExpectedCategory_Object_FAIL() {
		List<CategoryI> categories = dao.getAllCategory();
		dao.removeCategory(new Category("Void"));
		categories = dao.getAllCategory();
		assertEquals(4, categories.size());
	}
	
	@DisplayName("Category update by Objects [Object, Object]")
	@Test
	void testUpdateCategoryByObjects() {
		List<CategoryI> categories = dao.getAllCategory();
		CategoryI temp = new Category("Void");
		dao.updateCategory(expected, temp);
		assertTrue(categories.contains(temp));	
	}
	
	@DisplayName("Category update by Names [name, name]")
	@Test
	void testUpdateCategoryByNames() {
		List<CategoryI> categories = dao.getAllCategory();
		CategoryI temp = new Category("Void");
		dao.updateCategory("Dasher", "Void");
		assertTrue(categories.contains(temp));	
	}
	
	@DisplayName("Category update by Object & Name [Object, name]")
	@Test
	void testUpdateCategory_Combo_V1() {
		List<CategoryI> categories = dao.getAllCategory();
		CategoryI temp = new Category("Void");
		dao.updateCategory(expected, "Void");
		assertEquals(temp.getName(), categories.get(1).getName());
	}
	
	@DisplayName("Category update by Object & Name [name, Object]")
	@Test
	void testUpdateCategory_Combo_V2() {
		List<CategoryI> categories = dao.getAllCategory();
		CategoryI temp = new Category("Void");
		dao.updateCategory("Shadow Sprinter", temp);
		assertEquals(temp.getName(), categories.get(3).getName());	
	}
	
	
	
}
