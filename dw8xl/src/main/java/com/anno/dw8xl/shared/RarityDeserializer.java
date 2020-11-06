/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */

public class RarityDeserializer extends JsonDeserializer<RarityI> {
	private static String id = "state";

	@Override
	public RarityI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends RarityI> instanceClass = null;
//		System.out.printf("RDez --> %s\n", root.toPrettyString());
		if (root.get(id) != null) {
			instanceClass = Rarity.class;
		} else {
			instanceClass = NullRarity.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}
