package com.anno.warriors.dw8.enums.attribute;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public interface AttributeInterface extends DW8Enumeration<AttributeInterface> {

	abstract String getType();

	abstract String getName();

	abstract void setDescription(String description);

	abstract String getDescription();

}
