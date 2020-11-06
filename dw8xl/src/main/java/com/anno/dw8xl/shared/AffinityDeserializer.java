package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */

public class AffinityDeserializer extends JsonDeserializer<AffinityI> {
	private static String id = "state";
	@Override
	public AffinityI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends AffinityI> instanceClass = null;
//		System.out.println(String.format("ADez --> %s%n", root.toPrettyString()));
		if (root.get(id) != null) {
			instanceClass = Affinity.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}