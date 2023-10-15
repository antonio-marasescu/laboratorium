package stc.laboratoriumapi.integration.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTestBase {
	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	protected ObjectMapper objectMapper;

	protected <T> T get(
			String url, MultiValueMap<String, String> params, TypeReference<T> reference
	) throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).params(params);
		MvcResult result = this.mockMvc.perform(requestBuilder)
		                               .andExpect(MockMvcResultMatchers.status().isOk())
		                               .andReturn();
		return this.deserialize(result.getResponse().getContentAsString(), reference);
	}


	protected <T> T post(
			String url, Object body, HttpStatus requestStatus, TypeReference<T> reference
	) throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		if (body != null) {
			requestBuilder = requestBuilder.contentType(MediaType.APPLICATION_JSON).content(this.serialize(body));
		}
		MvcResult result = this.mockMvc.perform(requestBuilder).andExpect(
				MockMvcResultMatchers.status().is(requestStatus.value())).andReturn();
		return this.deserialize(result.getResponse().getContentAsString(), reference);
	}

	protected String serialize(Object data) throws JsonProcessingException {
		return this.objectMapper.writeValueAsString(data);
	}

	protected <T> T deserialize(String data, TypeReference<T> reference) throws JsonProcessingException {
		return this.objectMapper.readValue(data, reference);
	}
}
