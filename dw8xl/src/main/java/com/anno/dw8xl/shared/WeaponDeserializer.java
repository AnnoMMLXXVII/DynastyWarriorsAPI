/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.weapon.model.AbNormal;
import com.anno.dw8xl.weapon.model.Normal;
import com.anno.dw8xl.weapon.model.Weapon;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class WeaponDeserializer extends JsonDeserializer<WeaponI> {
	private static String id = "state";

	@Override
	public WeaponI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends Weapon> instanceClass = null;
		String res = root.get(id).toString();
//		System.out.printf("WDez --> %s\n%s\n", root.toPrettyString(),res);
		if (res.equals("normal".toLowerCase().trim())) {
			instanceClass = Normal.class;
		} else {
			instanceClass = AbNormal.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}
