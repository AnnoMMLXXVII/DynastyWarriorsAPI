package com.anno.warriors.dw8.shared;

import java.util.ArrayList;
import java.util.List;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public class WeaponSearcher {

	private List<WeaponInterface<Weapon>> list;

	public WeaponSearcher(List<WeaponInterface<Weapon>> list) {
		this.list = list;
	}

	private int binarySearch(List<WeaponInterface<Weapon>> list, WeaponInterface<Weapon> keyObj) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (keyObj.compareTo((Weapon) list.get(mid)) == 0) {
				return mid;
			}
			if (keyObj.compareTo((Weapon) list.get(mid)) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public WeaponInterface<Weapon> search(WeaponInterface<Weapon> object) {
		int idx = binarySearch(this.list, object);
		return (idx == -1) ? null : list.get(idx);
	}

	private int binarySearch(List<WeaponInterface<Weapon>> list, String keyObj) {
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

	public List<WeaponInterface<Weapon>> search(String object) {
		List<WeaponInterface<Weapon>> temp = new ArrayList<>();
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

	private List<WeaponInterface<Weapon>> binaryResultDuplicate(int idx, String object,
			List<WeaponInterface<Weapon>> temp) {
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

	private int binarySearchByAttackPower(List<WeaponInterface<Weapon>> list, Integer power) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (list.get(mid).compareToByPower(power) == 0) {
				return mid;
			}
			if (list.get(mid).compareToByPower(power) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public List<WeaponInterface<Weapon>> searchByAttackPower(Integer power) {
		List<WeaponInterface<Weapon>> temp = new ArrayList<>();
		int idx = binarySearchByAttackPower(this.list, power);
		if (idx < 0) {
			return new ArrayList<>();
		}
		temp.add(list.get(idx));
		return binaryAttackPowerResultDuplicate(idx, power, temp);
	}

	private List<WeaponInterface<Weapon>> binaryAttackPowerResultDuplicate(int idx, Integer power,
			List<WeaponInterface<Weapon>> temp) {
		int i = idx++;
		if (idx != -1 && this.list.get(idx).compareToByPower(power) == 0) {
			temp = new ArrayList<>();
			while (i < list.size() - 1 && this.list.get(i).compareToByPower(power) == 0) {
				temp.add(list.get(i));
				i++;
			}
		}
		return temp;
	}

	private int binarySearchByAffinity(List<WeaponInterface<Weapon>> list, Affinity affinity) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (list.get(mid).compareToByAffinity(affinity) == 0) {
				return mid;
			}
			if (list.get(mid).compareToByAffinity(affinity) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public List<WeaponInterface<Weapon>> searchByAffinity(Affinity affinity) {
		List<WeaponInterface<Weapon>> temp = new ArrayList<>();
		int idx = binarySearchByAffinity(this.list, affinity);
		if (idx < 0) {
			return new ArrayList<>();
		}
		temp.add(list.get(idx));
		return binaryAffinityResultDuplicate(idx, affinity, temp);
	}

	private List<WeaponInterface<Weapon>> binaryAffinityResultDuplicate(int idx, Affinity affinity,
			List<WeaponInterface<Weapon>> temp) {
		int i = idx++;
		if (idx != -1 && this.list.get(idx).compareToByAffinity(affinity) == 0) {
			temp = new ArrayList<>();
			while (i < list.size() - 1 && this.list.get(i).compareToByAffinity(affinity) == 0) {
				temp.add(list.get(i));
				i++;
			}
		}
		return temp;
	}

	private int binarySearchByStar(List<WeaponInterface<Weapon>> list, Integer star) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (list.get(mid).compareToByStar(star) == 0) {
				return mid;
			}
			if (list.get(mid).compareToByStar(star) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public List<WeaponInterface<Weapon>> searchByStar(Integer star) {
		List<WeaponInterface<Weapon>> temp = new ArrayList<>();
		int idx = binarySearchByStar(this.list, star);
		if (idx < 0) {
			return new ArrayList<>();
		}
		temp.add(list.get(idx));
		return binaryStarResultDuplicate(idx, star, temp);
	}

	private List<WeaponInterface<Weapon>> binaryStarResultDuplicate(int idx, Integer star,
			List<WeaponInterface<Weapon>> temp) {
		int i = idx++;
		if (idx != -1 && this.list.get(idx).compareToByStar(star) == 0) {
			temp = new ArrayList<>();
			while (i < list.size() - 1 && this.list.get(i).compareToByStar(star) == 0) {
				temp.add(list.get(i));
				i++;
			}
		}
		return temp;
	}

}
