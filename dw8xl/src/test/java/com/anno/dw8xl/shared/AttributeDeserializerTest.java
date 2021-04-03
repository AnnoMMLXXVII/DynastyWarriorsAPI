package com.anno.dw8xl.shared;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;
import com.anno.dw8xl.level.model.Level;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class AttributeDeserializerTest {

	private AttributeI normal, special;
	private ObjectMapper mapper;
	@BeforeEach
	void setUp() throws Exception {
		normal = new Normal("Velocity", "Raises overall attack speed");
		special = new Special("Awareness", "Can block attacks from the rear");
		mapper = new ObjectMapper();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreationUsingObjectMapper_Normal() {
		Normal attribute = (Normal) normal;
		try {
			attribute.setLevel(new Level(6));
			String json = mapper.writeValueAsString(attribute);
			AttributeI temp = mapper.readValue(json, AttributeI.class);
			json = mapper.writeValueAsString(temp);
			System.out.println("--> \n" + json.toString());
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(attribute);	
	}

	@Test
	void testCreationUsingObjectMapper_Special() {
		AttributeI attribute = null;
		try {
			System.out.println(special.toString());
			String json = mapper.writeValueAsString(special);
			attribute= mapper.readValue(json, AttributeI.class);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(attribute);	
	}
}
