package springboottest1;







import org.junit.Test;
import org.springframework.http.MediaType;

import com.springboot.test.app.MockMvc;
import com.springboot.test.app.SecuredController;
import com.springboot.test.app.WebMvcTest;
import com.springboot.test.app.WithMockUser;
import com.springboottest.Autowired;
import com.test.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(SecuredController.class)
public class SecuredControllerWebMvcIntegrationTest {

    @Autowired
    private MockMvc mvc;

    // ... other methods

    @WithMockUser(value = "spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ((SecuredControllerWebMvcIntegrationTest) mvc.perform(((SecuredControllerWebMvcIntegrationTest) get("/private/hello")).contentType(MediaType.APPLICATION_JSON)))
          .andExpect(((SecuredControllerWebMvcIntegrationTest) status()).isOk());
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

	private Object status() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}