package com.anno.warriors.dw8.shared;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public class WeaponSorter {

	private List<WeaponInterface<Weapon>> list;
	private static Logger logger = LogManager.getLogger();

	public WeaponSorter(List<WeaponInterface<Weapon>> list, DW8Constants.SortBy sortBy, DW8Constants.OrderBy orderBy) {
		this.list = list;
		if (sortBy.equals(DW8Constants.SortBy.ATTACK_POWER)) {
			quickSortByPower(this.list, 0, this.list.size() - 1);
		} else if (sortBy.equals(DW8Constants.SortBy.AFFINITY)) {
			quickSortByAffinity(this.list, 0, this.list.size() - 1);
		} else if (sortBy.equals(DW8Constants.SortBy.STAR)) {
			quickSortByStar(this.list, 0, this.list.size() - 1);
		} else if (sortBy.equals(DW8Constants.SortBy.TYPES)) {
			quickSortByType(this.list, 0, this.list.size() - 1);
		} else {
			quickSort(this.list, 0, this.list.size() - 1);
		}
	}

	public List<WeaponInterface<Weapon>> getSortedList() {
		return list;
	}

	private int partition(List<WeaponInterface<Weapon>> list, int low, int high) {
		WeaponInterface<Weapon> pivot = list.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (list.get(j).compareTo((Weapon) pivot) < 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, high);
		return i + 1;
	}

	private int partitionByStar(List<WeaponInterface<Weapon>> list, int low, int high) {
		int pivot = list.get(high).getStar();
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

	private int partitionByAffinity(List<WeaponInterface<Weapon>> list, int low, int high) {
		Affinity pivot = list.get(high).getAffinity();
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

	private int partitionByPower(List<WeaponInterface<Weapon>> list, int low, int high) {
		Integer pivot = list.get(high).getPower();
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

	private int partitionByType(List<WeaponInterface<Weapon>> list, int low, int high) {
		Types pivot = list.get(high).getType();
		logger.info("Pivot --> {}", pivot);
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

	private void quickSort(List<WeaponInterface<Weapon>> list, int low, int high) {
		if (low < high) {
			int pi = partition(list, low, high);
			quickSort(list, low, pi - 1);
			quickSort(list, pi + 1, high);
		}
	}

	private void quickSortByPower(List<WeaponInterface<Weapon>> list, int low, int high) {
		if (low < high) {
			int pi = partitionByPower(list, low, high);
			quickSortByPower(list, low, pi - 1);
			quickSortByPower(list, pi + 1, high);
		}
	}

	private void quickSortByAffinity(List<WeaponInterface<Weapon>> list, int low, int high) {
		if (low < high) {
			int pi = partitionByAffinity(list, low, high);
			quickSortByAffinity(list, low, pi - 1);
			quickSortByAffinity(list, pi + 1, high);
		}
	}

	private void quickSortByStar(List<WeaponInterface<Weapon>> list, int low, int high) {
		if (low < high) {
			int pi = partitionByStar(list, low, high);
			quickSortByStar(list, low, pi - 1);
			quickSortByStar(list, pi + 1, high);
		}
	}

	private void quickSortByType(List<WeaponInterface<Weapon>> list, int low, int high) {
		if (low < high) {
			int pi = partitionByType(list, low, high);
			quickSortByType(list, low, pi - 1);
			quickSortByType(list, pi + 1, high);
		}
	}

	private void swap(List<WeaponInterface<Weapon>> list, int first, int second) {
		WeaponInterface<Weapon> temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}

}
