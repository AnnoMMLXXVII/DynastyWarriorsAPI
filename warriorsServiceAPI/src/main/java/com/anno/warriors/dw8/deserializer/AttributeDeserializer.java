package com.anno.warriors.dw8.deserializer;

import java.io.IOException;

import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AttributeDeserializer extends JsonDeserializer<AttributeInterface> {

	@Override
	public AttributeInterface deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
//		Class<? extends AttributeInterface> instanceClass = null;
//		String res = root.get("name").toString();
//		instanceClass = Attribute.class;
		return mapper.treeToValue(root, Attribute.class);
	}
}
