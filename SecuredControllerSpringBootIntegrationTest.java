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
        mvc = ((SecuredControllerSpringBootIntegrationTest) ( (SecuredControllerSpringBootIntegrationTest) MockMvcBuilders
          .webAppContextSetup(context))
          .apply(springSecurity()))
          .build();
    }

    private MockMvc build() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object apply(Object springSecurity) {
		// TODO Auto-generated method stub
		return null;
	}

	// ... other methods

    private Object springSecurity() {
		// TODO Auto-generated method stub
		return null;
	}

	@WithMockUser("spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ((SecuredControllerSpringBootIntegrationTest) ((MockMvc) mvc).perform(( (SecuredControllerSpringBootIntegrationTest) get("/private/hello")).contentType(MediaType.APPLICATION_JSON)))
          .andExpect(((SecuredControllerSpringBootIntegrationTest) status()).isOk());
    }

	private void andExpect(Object ok) {
		// TODO Auto-generated method stub
		
	}

	private Object isOk() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object contentType(MediaType applicationJson) {
		// TODO Auto-generated method stub
		return null;
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