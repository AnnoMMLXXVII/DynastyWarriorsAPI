package com.anno.warriors.dw8.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DW8MappingObjects<K, V, E> {

	private Map<K, V> mapObject;

	public DW8MappingObjects(Map<K, V> mapObject) {
		this.mapObject = mapObject;
	}

	public Map<K, V> getMapObject() {
		return mapObject;
	}

	@SuppressWarnings("unchecked")
	public void mapKeyValueWithList(K key, E value) {
		List<E> tempList;
		if (mapObject.containsKey(key)) {
			tempList = (List<E>) mapObject.get(key);
			tempList.add(value);
			mapObject.put(key, (V) tempList);
		} else {
			tempList = new ArrayList<>();
			tempList.add(value);
			mapObject.put(key, (V) tempList);
		}
	}

	@SuppressWarnings("unchecked")
	public void mapKeyValueWithMap(K key, E value, E value2) {
		Map<E, E> tempMap;
		if (mapObject.containsKey(key)) {
			tempMap = (Map<E, E>) mapObject.get(key);
			tempMap.put(value, value2);
			mapObject.put(key, (V) tempMap);

		} else {
			tempMap = new HashMap<>();
			tempMap.put(value, value2);
			mapObject.put(key, (V) tempMap);
		}
	}

}
