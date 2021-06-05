package com.anno.warriors.dw8.attributes.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.attributes.dao.AttributesDAOInterface;

@Service("attributeFacade")
public class AttributesFacade implements AttributesFacadeInterface {

	@Autowired
	private AttributesDAOInterface dao;

}
