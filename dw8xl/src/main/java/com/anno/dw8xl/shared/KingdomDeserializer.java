/**
 * 
 */
package com.anno.dw8xl.shared;

import java.io.IOException;

import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Haku Wei
 *
 */
public class KingdomDeserializer extends JsonDeserializer<KingdomI> {

	private String id = "state";
	
	@Override
	public KingdomI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = (ObjectNode) mapper.readTree(p);
		Class<? extends KingdomI> instance = null;
		String res = root.get(id).toString();
		System.out.printf("KDez --> %s\n%s\n", root.toPrettyString(), res.equalsIgnoreCase("\"kingdom\""));
		if(res.equals("\"kingdom\"")) {
			instance = Kingdom.class;
		}
		else {
			instance = NullKingdom.class;
		}
		return mapper.treeToValue(root, instance);
	}
	
	

}
