package com.anno.warriors.dw8.shared;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;

public class CharacterSorter {

	private List<CharacterInterface<Character>> list;

	public CharacterSorter(List<CharacterInterface<Character>> list, DW8Constants.SortBy sortBy) {
		this.list = list;
		if (sortBy.equals(DW8Constants.SortBy.TYPES)) {
			quickSortByType(this.list, 0, this.list.size() - 1);
		}
	}
	
	public List<CharacterInterface<Character>> getSortedList() {
		return list;
	}

	private int partitionByType(List<CharacterInterface<Character>> list, int low, int high) {
		Types pivot = list.get(high).getWeaponType();
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

	private void quickSortByType(List<CharacterInterface<Character>> list, int low, int high) {
		if (low < high) {
			int pi = partitionByType(list, low, high);
			quickSortByType(list, low, pi - 1);
			quickSortByType(list, pi + 1, high);
		}
	}

	private void swap(List<CharacterInterface<Character>> list, int first, int second) {
		CharacterInterface<Character> temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}

}
