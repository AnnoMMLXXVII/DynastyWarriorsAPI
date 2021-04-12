package com.anno.warriors.shared;

import java.util.List;

public class WarriorSearcher<T extends Comparable<T>> {
	private List<T> list;

	public WarriorSearcher(List<T> list) {
		this.list = list;
	}

	private int binarySearch(List<T> list, T keyObj) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (keyObj.compareTo(list.get(mid)) == 0) {
				return mid;
			}
			if (keyObj.compareTo(list.get(mid)) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public T search(T object) {
		int idx = binarySearch(this.list, object);
		return (idx == -1) ? null : list.get(idx);
	}

}
