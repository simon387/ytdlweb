import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ytdlweb.rest.YtdlwebRestController;
import ytdlweb.service.IYtdlwebService;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IYtdlwebService ytdlwebService;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new YtdlwebRestController()).build();
	}

//	@Test
//	public void testYtdlwebRestController() throws Exception {
//
//		String json = "{\"url\": \"https://www.youtube.com/watch?v=oHNKTlz1lps\",\"type\": \"mp3\"}";
//		this.mockMvc.perform(post("/ytdl").accept(MediaType.parseMediaType("application/json;charset=UTF-8")).)
//				;
//	}

	@Test
	public void testYtdlwebRestController() throws Exception {

		String json = "{\"url\": \"https://www.youtube.com/watch?v=oHNKTlz1lps\",\"type\": \"mp3\"}";

		this.mockMvc.perform(post("/ytdl")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isCreated());
	}
}
