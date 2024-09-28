package com.anno.warriors.dw8.manager.weapons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.keys.WeaponName_TypesAttributesKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.utils.FileStreamHandler;
import com.anno.warriors.dw8.utils.WarriorsParingException;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;
import com.anno.warriors.dw8.weapons.slots.PowerAttribute;
import com.anno.warriors.dw8.weapons.slots.PowerlessAttribute;

public class WeaponAttributeParseManager implements DynastyWarriors8Object<WeaponAttributeParseManager> {

	private static Logger logger = LoggerFactory.getLogger(WeaponAttributeParseManager.class);
	private static Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> weapNameTypesKeyAttributesMap = new HashMap<>();

	public static Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> getWeapNameTypesKeyAttributesMap() {
		return weapNameTypesKeyAttributesMap;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	public static void readWeaponAttributesFile(String path) throws FileNotFoundException {
		logger.info("Parsing file " + path);
		try (BufferedReader br = new FileStreamHandler(path).getBufferedReader()) {
			String raw = "";
			while ((raw = br.readLine()) != null) {
				String[] line = raw.split(DW8Constants.Split.COMMA.getValue());
				parseWeaponAttributes(line);
			}

		} catch (IOException ex) {
			throw new WarriorsParingException(ex);
		}
	}

	private static void parseWeaponAttributes(String[] arr) {
		MappingObjectsWithReference<WeaponName_TypesAttributesKey, List<AttributeSlot>, AttributeSlot> attributeSlotMappingObject = new MappingObjectsWithReference<>(
				weapNameTypesKeyAttributesMap);
		WeaponName_TypesAttributesKey key;
		key = new WeaponName_TypesAttributesKey(arr[0].trim(), Types.returnCorrectEnum(arr[1].trim()));
		int fixedLength = arr.length;
		List<AttributeSlot> slots = new ArrayList<>(fixedLength);
		AttributeSlot temp = null;
		for (int i = 2; i < fixedLength; i++) {
			slots.add(temp = (AttributeSlot) parseAttributeSlot(arr[i]));
			attributeSlotMappingObject.mapKeyValueWithList(key, temp);
		}
	}

	private static DynastyWarriors8Object<AttributeSlot> parseAttributeSlot(String str) {
		if (str.contains(DW8Constants.Split.COLON.getValue())) {
			String[] splitByColon = str.split(DW8Constants.Split.COLON.getValue());
			return new PowerAttribute(NormalAttributes.returnCorrectEnum(splitByColon[0].trim()),
					Integer.parseInt(splitByColon[1].trim()));
		}
		return new PowerlessAttribute(SpecialAttributes.returnCorrectEnum(str.trim()));
	}

}
