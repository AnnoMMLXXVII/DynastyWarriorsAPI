/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class CategoryDeserializer extends JsonDeserializer<CategoryI> {
	private static String id = "state";
	@Override
	public CategoryI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends CategoryI> instanceClass = null;
//		System.out.printf("CDez --> %s\n", root.toPrettyString());
		if (root.get(id) != null) {
			instanceClass = Category.class;
		} else {
			instanceClass = NullCategory.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}
}