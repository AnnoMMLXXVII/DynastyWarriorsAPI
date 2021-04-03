package com.anno.dw8xl.attribute.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Normal;
import com.anno.dw8xl.attribute.model.Special;
import com.anno.dw8xl.dao.PATH;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Haku Wei
 *
 */
@Service
public class AttributeDAO implements AttributeDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(AttributeDAO.class);
	private Map<String, AttributeI> attributes, temp;
	private static AttributeDAOInterface instance = null;

	/*
	 * Singleton to get AttrbuteDAOInterface Instance
	 */
	public static AttributeDAOInterface getInstance() {
		if (instance == null) {
			synchronized (AttributeDAOInterface.class) {
				if (instance == null) {
					log.info("AttributeDAO singleton instantiation...");
					return new AttributeDAO();
				}
			}
		}
		return instance;
	}

	private AttributeDAO() {
		attributes = new HashMap<>();
		log.info("Parsing normal attributes file...");
		parseFilesAndMap(true);
		log.info("Parsing special attributes file...");
		parseFilesAndMap(false);
	}

	@Override
	public Collection<AttributeI> getAll() {
		return new ArrayList<>(attributes.values());
	}

	@Override
	public Collection<AttributeI> executeGetNormalAttributes() {
		return attributes.values().stream().filter(a -> a instanceof Normal).collect(Collectors.toList());
	}

	@Override
	public Collection<AttributeI> executeGetSpecialAttributes() {
		return attributes.values().stream().filter(a -> a instanceof Special).collect(Collectors.toList());
	}

	@Override
	public AttributeI executeGetAttributeByName(String name) {
		return attributes.get(name);
	}

	@Override
	public Optional<AttributeI> getBy(Object criteria) {
		AttributeI resultTemp;
		if (criteria instanceof AttributeI) {
			resultTemp = (AttributeI) criteria;
			resultTemp = attributes.get(resultTemp.getName());
			return (resultTemp != null) ? Optional.of(resultTemp) : Optional.ofNullable(resultTemp);
		} else if ((resultTemp = attributes.get(criteria)) != null) {
			return Optional.of(resultTemp);
		} else {
			return Optional.ofNullable(resultTemp);
		}
	}

	@Override
	public void add(AttributeI entity) {
		if (!AttributeDAOInterface.isValidToAdd(entity)) {
			return;
		}
		if (attributes.containsKey(entity.getName())) {
			log.info("Cannot add Attribute due to duplicate...");
			return;
		}
		attributes.put(entity.getName(), entity);
	}

	@Override
	public void remove(AttributeI entity) {
		if (!AttributeDAOInterface.isValidToRemove(entity)) {
			return;
		}
		if (!attributes.containsKey(entity.getName())) {
			log.info("Cannot find Attribute to remove...");
			return;
		}
		if (attributes.remove(entity.getName(), entity)) {
			log.debug(String.format("Removed : %s", entity.getName()));
		}
	}

	@Override
	public AttributeI executeCreateAttribute(String json) {
		ObjectMapper mapper = new ObjectMapper();
		AttributeI attribute = null;
		try {
			attribute = mapper.readValue(json, AttributeI.class);
		} catch (JsonProcessingException e) {
			log.debug(String.format("%s", e.getMessage()));
		}
		if (attribute != null) {
			add(attribute);
		}
		return attribute;
	}

	@Override
	public Collection<AttributeI> executeRemoveAttribute(String json) {
		AttributeI[] result = deserializeList(json);
		return mapArrayToRemove(result);
	}

	@Override
	public Collection<AttributeI> executeUpdateAttributes(String json, String... param) {
		AttributeI[] paramAttributes = deserializeList(json);
		int i = 0;
		for (AttributeI a : paramAttributes) {
			updateAttribute(attributes.get(param[i]), a);
			i++;
		}
		if (temp.isEmpty()) {
			return new ArrayList<>();
		}
		return new ArrayList<>(temp.values());
	}

	private AttributeI[] deserializeList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		AttributeI[] attributeAsArray = null;
		try {
			attributeAsArray = mapper.readValue(json, AttributeI[].class);
		} catch (JsonProcessingException e) {
			log.debug("Could not Parse!");
		}
		return attributeAsArray;
	}

	private Collection<AttributeI> mapArrayToRemove(AttributeI[] attributeArr) {
		for (AttributeI a : attributeArr) {
			remove(a);
		}
		return new ArrayList<>(attributes.values());
	}

	private boolean updateAttribute(AttributeI old, AttributeI attribute) {
		temp = attributes;
		temp.replace(old.getName(), attribute);
		return attributes.containsKey(attribute.getName());
	}

	private void parseFilesAndMap(boolean isNormal) {
		AttributeI temp;
		File file = new File(
				(isNormal) ? PATH.NORMAL_ATTRIBUTE_PATH.getStringUrl() : PATH.SPECIAL_ATTRIBUTE_PATH.getStringUrl());
		String line;
		String[] lineArr = null;
		try (Scanner z = new Scanner(new FileReader(file.getAbsolutePath()))) {
			while (z.hasNextLine()) {
				line = z.nextLine();
				lineArr = line.split(",");
				temp = (isNormal) ? new Normal(lineArr[0].trim(), lineArr[1].trim())
						: new Special(lineArr[0].trim(), lineArr[1].trim());
				attributes.put(temp.getName(), temp);
			}

		} catch (FileNotFoundException e) {
			log.debug(String.format("File Exception... Cannot Locate File: %s...", e.getMessage()));
			e.getMessage();
		}
	}
}
