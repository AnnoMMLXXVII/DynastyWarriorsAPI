package com.anno.warriors.dw8.shared;

import java.util.List;

import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public class AttributeSlotSorter {

	private List<AttributeSlot> list;

	public AttributeSlotSorter(List<AttributeSlot> list) {
		this.list = list;
		quickSort(this.list, 0, this.list.size() - 1);
	}

	public List<AttributeSlot> getSortedList() {
		return list;
	}

	private int partition(List<AttributeSlot> list, int low, int high) {
		AttributeSlot pivot = list.get(high);
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

	private void quickSort(List<AttributeSlot> list, int low, int high) {
		if (low < high) {
			int pi = partition(list, low, high);
			quickSort(list, low, pi - 1);
			quickSort(list, pi + 1, high);
		}
	}

	private void swap(List<AttributeSlot> list, int first, int second) {
		AttributeSlot temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}

}
