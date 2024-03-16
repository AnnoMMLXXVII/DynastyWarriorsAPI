package com.anno.warriors.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WarriorSorterTest {

	@Autowired
	private WarriorSorter<Integer> sorter;
	private Random r = new Random();
	private List<Integer> list = new ArrayList<>();
	private int testNumber = -1;
	private long start, end;

	@BeforeEach
	void setUp() throws Exception {
		generateRandomNumber();
		start = System.nanoTime();
		sorter = new WarriorSorter<>(list);
		end = System.nanoTime();
	}

	@AfterEach
	void breakDown() throws Exception {
		list.clear();
		System.out.printf("Test[%d] Sort Time : %s ms\n", testNumber, ((end - start) * 10E-3));
		testNumber = -1;
	}

	@Test
	void testIfListIsSorted() {
		testNumber = 1;
		List<Integer> temp = sorter.getSortedList();
		temp.forEach(e -> System.out.printf(e + ","));
		for (int i = 0, j = 1; i < temp.size() - 1 && j < temp.size(); i++, j++) {
			assertTrue(temp.get(i) <= temp.get(j));
		}
	}

	@Test
	void testIfListIsSortedWithSwitch_ASC() {
		testNumber = 2;
		sorter = new WarriorSorter<>(list, true);
		List<Integer> temp = sorter.getSortedList();
		temp.forEach(e -> System.out.printf(e + ","));
		for (int i = 0, j = 1; i < temp.size() - 1 && j < temp.size(); i++, j++) {
			assertTrue(temp.get(i) <= temp.get(j));
		}
	}

	@Test
	void testIfListIsSortedWithSwitch_DESC() {
		testNumber = 3;
		sorter = new WarriorSorter<>(list, false);
		List<Integer> temp = sorter.getSortedList();
		temp.forEach(e -> System.out.printf(e + ","));
		for (int i = 0, j = 1; i < temp.size() - 1 && j < temp.size(); i++, j++) {
			assertTrue(temp.get(i) >= temp.get(j));
		}
	}

	private void generateRandomNumber() {
		int rand = Math.abs(r.nextInt(1000));
		for (int i = 0; i < 10; i++) {
			list.add(rand);
			rand = Math.abs(r.nextInt(1000));
		}
	}

}
