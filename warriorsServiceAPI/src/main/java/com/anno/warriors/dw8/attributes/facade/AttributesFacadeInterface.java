package com.anno.warriors.dw8.attributes.facade;

import java.util.List;

import com.anno.warriors.dw8.attributes.model.AttributeInterface;

public interface AttributesFacadeInterface {

	public List<AttributeInterface> callingGetAllAttributes();

	public List<AttributeInterface> callingGetNormalAttributes();

	public List<AttributeInterface> callingGetSpecialAttributes();

	public List<AttributeInterface> callingGetNormalAttributesByNames(String... names);

	public List<AttributeInterface> callingGetSpecialAttributesByNames(String... names);

}
