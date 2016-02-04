package id.durkin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import id.durkin.model.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.Map;

@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestPersonController {

	final String BASE_URL = "http://localhost:8080/";
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testListPeople() throws Exception {
		// First check page renders and the view People exists and the model
		// people exists, and then  return the model people
		Object peopleModel = this.mockMvc
				.perform(get("/people").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("people")).andExpect(model().attributeExists("people"))
				.andReturn().getModelAndView().getModel().get("people");

		// next check the model People contains a list of people
		// and for convenience place the people in a HashMap indexed by name.
		Map<String, Person> map = new HashMap<String, Person>();
		if (peopleModel instanceof Iterable) {
			@SuppressWarnings("rawtypes")
			Iterable iterable = (Iterable) peopleModel;
			int i = 0;
			for (Object o : iterable) {
				assertEquals("Invalid item in Model People at index " + i, Person.class, o.getClass());
				map.put(((Person) o).getName(), (Person) o);
				i++;
			}
		} else {
			assertEquals("Invalid class for model People", Iterable.class, peopleModel.getClass());
		}

		// Now check the list of people is correct
		assertEquals("Incorrect number of people", 4, map.size());
		assertTrue("Brendan is not in the list of people", map.containsKey("Brendan Durkin"));

	}
}