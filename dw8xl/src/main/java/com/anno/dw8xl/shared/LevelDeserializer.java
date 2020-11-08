/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.level.model.Level;
import com.anno.dw8xl.level.model.LevelI;
import com.anno.dw8xl.level.model.NullLevel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Haku Wei
 *
 */
public class LevelDeserializer extends JsonDeserializer<LevelI> {
	private static String id = "state";

	@Override
	public LevelI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends LevelI> instanceClass = null;
		String res = root.get(id).toString();
//		System.out.printf("LvlDez --> %s\n%s\n", root.toPrettyString(),res);
		if (res.equals("level".toLowerCase().trim())) {
			instanceClass = Level.class;
		} else {
			instanceClass = NullLevel.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}

	
}
