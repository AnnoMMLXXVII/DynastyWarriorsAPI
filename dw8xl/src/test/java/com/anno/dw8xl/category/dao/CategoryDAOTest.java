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
import com.anno.dw8xl.category.model.NullCategory;

/**
 * @author Haku Wei
 *
 */
class CategoryDAOTest {

	private CategoryDAOInterface dao;
	private CategoryI expected;
	private long start, finish;
	private Collection<CategoryI> categories;
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
		categories = dao.getAll();
		assertEquals(4, categories.size());
	}
	
	@DisplayName("Category equals Expected [Dasher]")
	@Test
	void testGetCategoryByNumberEqualsExpected() {
		Optional<CategoryI> actual = dao.getBy(3);
		assertEquals(expected, actual.get());
	}
	
	@DisplayName("Category equals Expected [NullCategory]")
	@Test
	void testGetCategoryByNameEqualsNullCategory() {
		// Due to Map Key. Cannot search by String. Only Integer;
		Optional<CategoryI> actual = dao.getBy("Dasher");
		assertEquals(new NullCategory().getName(), actual.get().getName());
	}
	
	@DisplayName("Category !equals Expected [Void]")
	@Test
	void testGetCategoryByNameDoesNotEqualExpected() {
		CategoryI actual = dao.getBy(new Category("Void")).get();
		assertNotEquals(expected, actual);
	}
	
	@DisplayName("Category add Expected [VOID]")
	@Test
	void testCreateCategory() {
		categories = dao.getAll();
		int size = categories.size();
		dao.add(new Category("Void"));
		categories = dao.getAll();
		assertEquals(size+1, categories.size());
	}
	
	@DisplayName("Category add Dupicate Expected [Dasher] and Size Increases by 0")
	@Test
	void testAddExpectedDuplicateAndSizeIncreasesByZero() {
		categories = dao.getAll();
		int size = categories.size();
		dao.add(expected);
		categories = dao.getAll();
		assertEquals(size, categories.size());
	}
	
	@DisplayName("Category create FAIL Expected [A-z]*25")
	@Test
	void testCreateCategory_FAIL_LENGTH() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			dao.add(new Category("abcefghijklmnopqrstuvwxyz"));			
		});
		assertEquals("Illegal Category name: empty or length(0-24)", e.getMessage());
	}
	
	@DisplayName("Test add Category with Null and Size increases by 0 && Throws")
	@Test
	void testAddWithNullAndSizeIncreasesByZero() {
		categories = dao.getAll();
		int size = categories.size();
		Exception e = assertThrows(NullPointerException.class, () -> {
			dao.add(null);			
		});
		categories = dao.getAll();
		assertEquals(size, categories.size());
		assertEquals("Category cannot be added due to Null!", e.getMessage());
	}
	
	@DisplayName("Test Remove Expected Category 'Object' and size decrease by 1")
	@Test
	void testRemoveExpectedCategoryAndSizeDecreasesByOne() {
		categories = dao.getAll();
		int size = categories.size(); 
		dao.remove(expected);
		categories = dao.getAll();
		assertEquals(size-1, categories.size());
	}
	
	@DisplayName("Test Remove Non-Existent Category 'Object' and size decrease by 0")
	@Test
	void testRemoveDNEAndReturnsEqualMapSize_Special() {
		categories = dao.getAll();
		int size = categories.size();
		CategoryI expected = new Category("VOID");
		dao.remove(expected);
		categories = dao.getAll();;
		assertEquals(size, categories.size());
	}
	
}
