package springboottest1;



import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;

import com.springboot.test.app.MockMvc;
import com.springboot.test.app.WithMockUser;
import com.springboottest.Autowired;
import com.springboottest.MockMvcBuilders;

public class SecuredControllerSpringBootIntegrationTest {

    @Autowired
    private WebApplicationContext context;
public void apply() {};
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = ( MockMvcBuilders
          .webAppContextSetup(context))
          .apply(springSecurity())
          .build();
    }

    // ... other methods

    private Object springSecurity() {
		// TODO Auto-generated method stub
		return null;
	}

	@WithMockUser("spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(( get("/private/hello")).contentType(MediaType.APPLICATION_JSON))
          .andExpect((status()).isOk());
    }

	private Object get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object status() {
		// TODO Auto-generated method stub
		return null;
	}
}