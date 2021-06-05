package com.anno.warriors.dw8.attributes.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.attributes.dao.AttributesDAOInterface;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

@Service("attributeFacade")
public class AttributesFacade implements AttributesFacadeInterface {

	@Autowired
	private AttributesDAOInterface dao;

	@Override
	public List<AttributeInterface> callingGetAllAttributes() {
		return dao.getAllAttributes();
	}

	@Override
	public List<AttributeInterface> callingGetNormalAttributes() {
		return dao.getNormalAttributes();
	}

	@Override
	public List<AttributeInterface> callingGetSpecialAttributes() {
		return dao.getSpecialAttributes();
	}

	@Override
	public List<AttributeInterface> callingGetNormalAttributesByNames(String... names) {
		return dao.getNormalAttributesByNames(names);
	}

	@Override
	public List<AttributeInterface> callingGetSpecialAttributesByNames(String... names) {
		return dao.getSpecialAttributesByNames(names);
	}

}
