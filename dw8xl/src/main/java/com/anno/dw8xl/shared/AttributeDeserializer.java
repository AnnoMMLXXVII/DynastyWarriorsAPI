/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.attribute.model.Attribute;
import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Haku Wei
 *
 */
public class AttributeDeserializer extends JsonDeserializer<AttributeI> {
	private static String id = "state";

	@Override
	public AttributeI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends Attribute> instanceClass = null;
		String res = root.get(id).toString();
//		System.out.printf("AttriDez --> %s\n TYPE --> %s\n", root.toPrettyString(), res.toString());
		if (res.equals("\"normal\"".toLowerCase().trim())) {
			instanceClass = Normal.class;
		} else {
			instanceClass = Special.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}

}
