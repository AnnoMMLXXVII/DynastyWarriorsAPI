package com.anno.warriors.dw8.shared;

import java.util.List;

import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public class AttributeSlotSearcher {

	private List<AttributeSlot> list;

	public AttributeSlotSearcher(List<AttributeSlot> list) {
		this.list = list;
	}

	public int search(String name) {
		int idx = binarySearch(this.list, name);
		return (idx < 0) ? -1 : idx;
	}

	public int search(Integer level) {
		int idx = binarySearch(this.list, level);
		return (idx < 0) ? -1 : idx;
	}

	public boolean search(String name, Integer level) {
		int idx = binarySearch(this.list, name, level);
		return (idx < 0) ? false : true;
	}

	private int binarySearch(List<AttributeSlot> list, String name) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (name.compareTo(list.get(mid).getName()) == 0) {
				return mid;
			}
			if (name.compareTo(list.get(mid).getName()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private int binarySearch(List<AttributeSlot> list, Integer level) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (level.compareTo(list.get(mid).getLevel()) == 0) {
				return mid;
			}
			if (level.compareTo(list.get(mid).getLevel()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private int binarySearch(List<AttributeSlot> list, String name, Integer level) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (name.compareTo(list.get(mid).getName()) == 0 && level.compareTo(list.get(mid).getLevel()) == 0) {
				return mid;
			}
			if (name.compareTo(list.get(mid).getName()) < 0 || level.compareTo(list.get(mid).getLevel()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

//	private List<AttributeSlot> binaryResultDuplicate(int idx, String name, List<AttributeSlot> temp) {
//		int i = idx++;
//		if (idx != -1 && this.list.get(idx).getName().compareTo(name) == 0) {
//			while (i < list.size() - 1 && this.list.get(i).getName().compareTo(name) == 0) {
//				temp.add(list.get(i));
//				i++;
//			}
//		}
//		return temp;
//	}

//	private List<AttributeSlot> binaryResultDuplicate(int idx, Integer level, List<AttributeSlot> temp) {
//		int i = idx++;
//		if (idx != -1 && this.list.get(idx).getLevel().compareTo(level) == 0) {
//			while (i < list.size() - 1 && this.list.get(i).getLevel().compareTo(level) == 0) {
//				temp.add(list.get(i));
//				i++;
//			}
//		}
//		return temp;
//	}

}
