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

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;

/**
 * @author Haku Wei
 *
 */
public class AttributeDAO implements AttributeDAO_I{
	private static final String URL = "C:\\Users\\Haku Wei\\Documents\\git\\DynastyWarriors8XL\\Text-Files\\attributes\\";
	private static final String NORMAL= "normal\\normal";
	private static final String SPECIAL= "special\\special";
	private Map<String, AttributeI> mapAttributes;
	private static AttributeDAO_I instance = null;
	
	/*
	 * Singleton to get AttrbuteDAO_I Instance
	 */
	public static AttributeDAO_I getInstance() {
		if(instance == null) {
			synchronized(AttributeDAO_I.class) {
				if(instance == null) {
					return new AttributeDAO();
				}
			}
		}
		return instance;
	}
	
	private AttributeDAO() {
		mapAttributes = new HashMap<>();
		try {
			listNormalAttributesFromFile();
			listSpecialAttributesFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AttributeI> getAllAttributes() {
		return new ArrayList<>(mapAttributes.values());	
	}

	@Override
	public List<AttributeI> getNormalAttributes() {
			return mapAttributes.values().stream().filter(a -> a.getType().toString().equals("NORMAL")).collect(Collectors.toList());		 
	}

	@Override
	public List<AttributeI> getSpecialAttributes() {
		return mapAttributes.values().stream().filter(a -> a.getType().toString().equals("SPECIAL")).collect(Collectors.toList());
	}

	@Override
	public AttributeI getAttributeByName(String name) {
		return mapAttributes.get(name);
	}
	
	@Override
	public void createAttribute(AttributeI attribute) {
		if(!validateAttributeFields(attribute)) {
			return;
		}
		mapAttributes.put(attribute.getName(), attribute);
	}

	@Override
	public void removeAttribute(AttributeI attribute) {
		mapAttributes.remove(attribute.getName());
	}

	@Override
	public void updateAttribute(AttributeI old, AttributeI attribute) {
		if(!validateAttributeFields(attribute)) {
			return;
		}
		mapAttributes.replace(old.getName(), attribute);
	}
	
	private boolean validateAttributeFields(AttributeI attribute) {
		boolean isValid = false;
		 return (attribute == null || attribute.getName().equals("") || attribute.getDescription().equals("")) ? 
				 isValid : !isValid; 
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
