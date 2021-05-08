package com.anno.warriors.dw8.shared;

import java.util.List;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;

public class CharacterSearcher {

	private List<CharacterInterface<Character>> list;

	public CharacterSearcher(List<CharacterInterface<Character>> list) {
		this.list = list;
	}

	private int binarySearch(List<CharacterInterface<Character>> list, Types type) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (type.compare(type, list.get(mid).getWeaponType()) == 0) {
				return mid;
			}
			if (type.compare(type, list.get(mid).getWeaponType()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public CharacterInterface<Character> search(Types type) {
		int idx = binarySearch(this.list, type);
		return (idx == -1) ? null : list.get(idx);
	}
}
