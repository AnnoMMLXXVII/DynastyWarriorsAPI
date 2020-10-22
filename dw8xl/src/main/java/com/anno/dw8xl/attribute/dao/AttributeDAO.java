package com.anno.dw8xl.attribute.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;

/**
 * @author Haku Wei
 *
 */
@Service
public class AttributeDAO implements AttributeDAO_I{
	
	private static final String URL = "src/main/resources/Text-Files/attributes";
	private static final String NORMAL= "/normal/normal";
	private static final String SPECIAL= "/special/special";
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeDAO.class);
	private Map<String, AttributeI> mapAttributes;
	private static AttributeDAO instance = null;
	
	/*
	 * Singleton to get AttrbuteDAO_I Instance
	 */
	public static AttributeDAO getInstance() {
		if(instance == null) {
			synchronized(AttributeDAO.class) {
				if(instance == null) {
					LOGGER.debug("Instantiaing AttributeDAO");
					return new AttributeDAO();
				}
			}
		}
		return instance;
	}
	
	private AttributeDAO() {
		mapAttributes = new HashMap<>();
		try {
			LOGGER.debug("Reading Files");
			listNormalAttributesFromFile();
			listSpecialAttributesFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AttributeI> executeGetAllAttributes() {
		return new ArrayList<>(mapAttributes.values());	
	}

	@Override
	public List<AttributeI> executeGetNormalAttributes() {
			return mapAttributes.values().stream().filter(a -> a.getType().toString().equals("NORMAL")).collect(Collectors.toList());		 
	}

	@Override
	public List<AttributeI> executeGetSpecialAttributes() {
		return mapAttributes.values().stream().filter(a -> a.getType().toString().equals("SPECIAL")).collect(Collectors.toList());
	}

	@Override
	public AttributeI executeGetAttributeByName(String name) {
		return mapAttributes.get(name);
	}
	
	@Override
	public AttributeI executeCreateAttribute(AttributeI attribute) {
		mapAttributes.put(attribute.getName(), attribute);
		return mapAttributes.get(attribute.getName());
	}

	@Override
	public List<AttributeI> executeRemoveAttribute(List<AttributeI> attribute) {
		for(AttributeI a : attribute) {
			mapAttributes.remove(a.getName(), a);			
		}
		return attribute;
	}

	@Override
	public List<AttributeI> executeUpdateAttributes(List<AttributeI> old, List<AttributeI> attribute) {
		int i = 0;
		for(AttributeI o : old) {
			executeUpdateAttribute(o, attribute.get(i));
			i++;
			old.removeIf(d -> d.getName().equals(o.getName()));
			System.out.println(o.toString());
		}
		return (old.size() == attribute.size()) ? attribute : old ;
	}
	
	private boolean executeUpdateAttribute(AttributeI old, AttributeI attribute) {
		mapAttributes.replace(old.getName(), attribute);
		return mapAttributes.containsKey(attribute.getName());
	}

	private void listNormalAttributesFromFile() throws FileNotFoundException {
		File file = new File((URL+NORMAL));
		if(!file.exists()) {
			throw new FileNotFoundException("Cannot Locate File!");
		}
		AttributeI temp;
		String line;
		String[] lineArr = null;
		try (Scanner z  = new Scanner(new FileReader(file.getAbsolutePath()))) {
			while (z.hasNextLine()) {
				line = z.nextLine();
				lineArr = line.split(",");
				temp = new Normal(lineArr[0].trim(), lineArr[1].trim());
				mapAttributes.put(temp.getName(), temp);
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	private void listSpecialAttributesFromFile() throws FileNotFoundException {
		File file = new File((URL+SPECIAL));
		if(!file.exists()) {
			throw new FileNotFoundException("Cannot Locate File!");
		}
		AttributeI temp;
		String line;
		String[] lineArr = null;
		try (Scanner z  = new Scanner(new FileReader(file.getAbsolutePath()))){
			while (z.hasNextLine()) {
				line = z.nextLine();
				lineArr = line.split(",");
				temp = new Special(lineArr[0].trim(), lineArr[1].trim());
				mapAttributes.put(temp.getName(), temp);
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
