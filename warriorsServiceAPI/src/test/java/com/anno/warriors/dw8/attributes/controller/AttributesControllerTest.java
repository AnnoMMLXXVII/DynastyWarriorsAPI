package com.anno.warriors.dw8.attributes.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.anno.warriors.dw8.attributes.dao.AttributesDAOInterface;
import com.anno.warriors.dw8.attributes.facade.AttributesFacadeInterface;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.manager.files.ParsingFiles;

@WebMvcTest(AttributesController.class)
@ExtendWith(MockitoExtension.class)
//@Import(DynastyWarriorsVIIIConfigurations.class)
class AttributesControllerTest {
	private static final String PREFIX_URL = "/dw8/attributes";

	@InjectMocks
	private AttributesController controller;

	@MockBean
	private AttributesFacadeInterface mockFacade;

	@MockBean
	private AttributesDAOInterface mockDao;

	@Autowired
	private MockMvc mockMvc;

	private List<AttributeInterface> list;
	private DW8Structures structures;

	@BeforeEach
	void setUp() throws Exception {
		list = ParsingFiles.getAllAttributes();
		mockMvc = setupCORSConfig();
	}

//	@Test
	void testGetAllAttributesCall() throws Exception {
		when(mockFacade.callingGetAllAttributes()).thenReturn(list);
		mockMvc.perform(get(PREFIX_URL + "/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testGetAttributeCall() throws Exception {
		String attribute = "Conflagration";
		List<AttributeInterface> tempList = list.parallelStream().filter(e -> e.getName().equalsIgnoreCase(attribute))
				.collect(Collectors.toList());
		when(mockFacade.callingGetAllAttributes(attribute)).thenReturn(tempList);
		MvcResult response = mockMvc
				.perform(get(PREFIX_URL + "/attribute/{name}", attribute).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
//				.andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value(tempList.get(0).getName()))
//				.andExpect(jsonPath("$[0].description").value(tempList.get(0).getDescription()))
//				.andExpect(jsonPath("$[0].type").value(tempList.get(0).getType()));
	}

	private MockMvc setupCORSConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return MockMvcBuilders.standaloneSetup(controller).addFilters(bean.getFilter()).build();
	}

}
