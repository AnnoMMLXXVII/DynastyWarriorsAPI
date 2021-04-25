package com.anno.warriors.shared;

import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("unchecked")
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

	private int binarySearch(List<T> list, String keyObj) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (keyObj.compareTo(parseToStringObjectToString(mid)) == 0) {
				return mid;
			}
			if (keyObj.compareTo(parseToStringObjectToString(mid)) < 0) {
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

	public List<T> search(String object) {
		List<T> temp = new ArrayList<>();
		int idx = binarySearch(list, object);
		if (idx < 0) {
			return new ArrayList<>();
		}
		temp.add(list.get(idx));
		return binaryResultDuplicate(idx, object, temp);
	}

	private String parseToStringObjectToString(int idx) {
		String[] parsedStr = list.get(idx).toString().split(",");
		String[] parsedEquals = parsedStr[0].split("=");
		return parsedEquals[1];
	}

	private List<T> binaryResultDuplicate(int idx, String object, List<T> temp) {
		int i = idx++;
		if (idx != -1 && parseToStringObjectToString(i).compareTo(object) == 0) {
			temp = new ArrayList<>();
			while (i < list.size() - 1 && parseToStringObjectToString(i).compareTo(object) == 0) {
				temp.add(list.get(i));
				i++;
			}
		}
		return temp;
	}
}
