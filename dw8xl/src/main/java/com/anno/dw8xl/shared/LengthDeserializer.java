package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.length.model.LengthI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class LengthDeserializer extends JsonDeserializer<LengthI> {
	private static String id = "state";
	@Override
	public LengthI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends Length> instanceClass = null;
//		System.out.printf("LDez --> %s\n", root.toPrettyString());
		if (root.get(id) != null) {
			instanceClass = Length.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}
