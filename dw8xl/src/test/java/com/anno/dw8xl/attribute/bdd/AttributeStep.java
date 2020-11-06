package com.anno.dw8xl.attribute.bdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import com.anno.dw8xl.attribute.dao.AttributeDAO;
import com.anno.dw8xl.attribute.dao.AttributeDAOInterface;
import com.anno.dw8xl.attribute.model.AttributeI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AttributeStep {
	private Collection<AttributeI> attributes;
	private AttributeDAOInterface dao;
	@Given("All Attributes exist in a list")
	public void all_attributes_exist_in_a_list() {
		dao = AttributeDAO.getInstance();
	}

	@When("I want to retrieve the {collection}")
	public void i_want_to_retrieve_the_list(Collection<AttributeI> attributes) {
		attributes = dao.getAll();
	}

	@Then("I should have a {collection} of Attributes")
	public void i_should_have_a_list_of_attributes(Collection<AttributeI> expected) {
		assertThat(attributes).isEqualTo(expected);
	}
}
