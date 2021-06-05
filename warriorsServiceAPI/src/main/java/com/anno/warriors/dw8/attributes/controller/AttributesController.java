package com.anno.warriors.dw8.attributes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.attributes.facade.AttributesFacadeInterface;

@RestController
@RequestMapping(value = "dw8/attributes")
public class AttributesController {

	@Autowired
	private AttributesFacadeInterface facade;
}
