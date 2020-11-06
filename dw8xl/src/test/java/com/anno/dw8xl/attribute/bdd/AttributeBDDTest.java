package com.anno.dw8xl.attribute.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "src/test/resources/features/attributes/attribute.feature"
		 ,glue={"stepDefinition"}
		 )
public class AttributeBDDTest {

}
