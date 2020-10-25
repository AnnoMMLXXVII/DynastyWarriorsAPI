/**
 * 
 */
package com.anno.dw8xl.category.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.dao.DAO;

/**
 * @author Haku Wei
 *
 */
class CategoryDAOTest {

	private DAO<CategoryI, Object> dao;
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
		Collection<CategoryI> categories = dao.getAll();
		assertEquals(4, categories.size());
	}
	
	@DisplayName("Category equals Expected [Dasher]")
	@Test
	void testGetCategoryByNameEqualsExpected() {
		Optional<CategoryI> actual = Optional.ofNullable(dao.getBy("Dasher")).get();
		assertEquals(expected, actual.get());
	}
	
	@DisplayName("Category !equals Expected [Void]")
	@Test
	void testGetCategoryByNameDoesNotEqualExpected() {
		CategoryI actual = dao.getBy(new Category("Void")).get();
		assertNotEquals(expected, actual);
	}
	
	@DisplayName("Category create Expected [VOID]")
	@Test
	void testCreateCategory() {
		Collection<CategoryI> categories = dao.getAll();
		dao.add(new Category("Void"));
		categories = dao.getAll();
		assertEquals(5, categories.size());
	}
	
	@DisplayName("Category create FAIL Expected [A-z]*25")
	@Test
	void testCreateCategory_FAIL_LENGTH() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			dao.add(new Category("abcefghijklmnopqrstuvwxyz"));			
		});
		assertEquals("Illegal Category name: empty or length(0-24)", e.getMessage());
	}
	
	@DisplayName("Category remove by Object Expected [Dasher] - v2")
	@Test
	void testRemoveExpectedCategory_Object() {
		Collection<CategoryI> categories = dao.getAll();
		dao.remove(expected);
		categories = dao.getAll();
		assertEquals(3, categories.size());
	}
	
	@DisplayName("Category remove by Object FAIL for Expected [VOID] = v2")
	@Test
	void testRemoveExpectedCategory_Object_FAIL() {
		Collection<CategoryI> categories = dao.getAll();
		Exception e = assertThrows(IllegalArgumentException.class, () -> {			
			dao.remove(new Category("Void"));
		});
				
		assertEquals(4, categories.size());
		assertEquals("Category does not exist!", e.getMessage());
	}
	
}
