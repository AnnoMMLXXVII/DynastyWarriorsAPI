/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class TypeDeserializer extends JsonDeserializer<TypeI> {
	private static String id = "state";

	@Override
	public TypeI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends TypeI> instanceClass = null;
//		System.out.printf("TDez --> %s\n", root.toPrettyString());
		if (root.get(id) != null) {
			instanceClass = Type.class;
		} else {
			instanceClass = NullType.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}
