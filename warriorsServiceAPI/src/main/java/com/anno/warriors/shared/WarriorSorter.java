package com.anno.warriors.shared;

import java.util.List;

public class WarriorSorter<T extends Comparable<T>> {

	private List<T> list;

	public WarriorSorter(List<T> list) {
		this.list = list;
		quickSort(list, 0, this.list.size() - 1);
	}

	public WarriorSorter(List<T> list, boolean ASC) {
		this.list = list;
		if (ASC) {
			quickSort(list, 0, this.list.size() - 1);
		} else {
			quickSortDescending(list, 0, this.list.size() - 1);
		}
	}

	public List<T> getSortedList() {
		return list;
	}

	private int partition(List<T> list, int low, int high) {
		T pivot = list.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (list.get(j).compareTo(pivot) < 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, high);
		return i + 1;
	}

	private int partitionDescending(List<T> list, int low, int high) {
		T pivot = list.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (list.get(j).compareTo(pivot) > 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, high);
		return i + 1;
	}

	private void quickSort(List<T> list, int low, int high) {
		if (low < high) {
			int pi = partition(list, low, high);
			quickSort(list, low, pi - 1);
			quickSort(list, pi + 1, high);
		}
	}

	private void quickSortDescending(List<T> list, int low, int high) {
		if (low < high) {
			int pi = partitionDescending(list, low, high);
			quickSortDescending(list, low, pi - 1);
			quickSortDescending(list, pi + 1, high);
		}
	}

	private void swap(List<T> list, int first, int second) {
		T temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}

}
