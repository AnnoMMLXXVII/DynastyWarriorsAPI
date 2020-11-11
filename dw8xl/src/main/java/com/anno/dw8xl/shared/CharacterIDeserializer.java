/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.character.model.Character;
import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Haku Wei
 *
 */
public class CharacterIDeserializer extends JsonDeserializer<CharacterI> {

	private static String id = "state";
		
	@Override
	public CharacterI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends Character> instanceClass = null;
		String res = root.get(id).toString();
//		System.out.printf("CharDez --> %s\n TYPE --> %s\n", root.toPrettyString(), res.toString());
		if (res.equals("\"officer\"".toLowerCase().trim())) {
			instanceClass = Officer.class;
		} else {
			instanceClass = SubOfficer.class;
		}
		return mapper.treeToValue(root, instanceClass);
	}

}
