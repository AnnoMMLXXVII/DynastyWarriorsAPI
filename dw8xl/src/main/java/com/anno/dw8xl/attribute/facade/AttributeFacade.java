/**
 * 
 */
package com.anno.dw8xl.attribute.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.attribute.dao.AttributeDAOInterface;
import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.NullAttribute;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service
public class AttributeFacade implements AttributeFacadeInterface {
	private static final Logger log = LoggerFactory.getLogger(AttributeFacade.class);
	@Autowired
	private AttributeDAOInterface dao;
	private Collection<AttributeI> inValid;
	
	@Override
	public Collection<AttributeI> getAllAttributes() {
		return dao.getAll();
	}
	@Override
	public Collection<AttributeI> getNormalAttributes() {
		return dao.executeGetNormalAttributes();
	}
	@Override
	public Collection<AttributeI> getSpecialAttributes() {
		return dao.executeGetSpecialAttributes();
	}
	@Override
	public AttributeI getAttributeByName(String name) {
		if(name.equals("")) {
			log.debug("Attribute name is Empty!");
			return null;
		}
		String temp = formatParam(name);
		return dao.executeGetAttributeByName(temp);
	}
	
	@Override
	public AttributeI createAttribute(AttributeI attribute) {
		if(attribute.getName().equals("")) {
			log.debug("Error : Attribute name is empty...");
			return new NullAttribute();
		}
		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(attribute);
		}catch(JsonProcessingException e) {
			log.debug(String.format("%s", e.getMessage()));
		}
		return dao.executeCreateAttribute(json);
	}
	
	@Override
	public Collection<AttributeI> removeAttribute(List<AttributeI> attribute) {
		if(attribute.isEmpty()) {
			return new ArrayList<>();						
		}
		ObjectMapper mapper = new ObjectMapper();
		String json  = "";
		try {
			json = mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeRemoveAttribute(json); 
	}
	
	@Override
	public Collection<AttributeI> updateAttributes(List<AttributeI> attributes, String...names) {
		if(attributes.isEmpty() || attributes.size() != names.length) {
			return new ArrayList<>();
		}
		attributes = isValidUpdate(attributes);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(attributes);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeUpdateAttributes(json, names);
	}
	
	private String formatParam(String param) {
		return (param.substring(0, 1).toUpperCase() + param.substring(1)).trim();
	}
	
	private void logException(Exception e) {
		log.debug(String.format("%s", e.getMessage()));
	}
	
	private List<AttributeI> isValidUpdate(List<AttributeI> attributes) {
		List<AttributeI> valid = new ArrayList<>();
		List<AttributeI> database = (List<AttributeI>) dao.getAll();
		inValid = new ArrayList<>();
		for(AttributeI a : attributes) {
			if((a.getName().equalsIgnoreCase("") || a.getDescription().equalsIgnoreCase(""))){
				inValid.add(a);
				log.debug("Missing Attribute Name and/or Description...");
			}
			else {
				valid.add(a);
				log.debug("Valid Attribute...");
			}
		}
		for(AttributeI a: attributes) {
			if(!database.contains(a)) {
				inValid.add(a);
			}
		}
		setInValid(inValid);
		return valid;
	}
	
	private void setInValid(Collection<AttributeI> inValid) {
		this.inValid = inValid;
	}
	
	public Collection<AttributeI> getInValid() {
		return inValid;
	}
	
	

}
