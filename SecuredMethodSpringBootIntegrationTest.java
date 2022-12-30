package springboottest1;



import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;


import com.springboottest.Autowired;
import com.test.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecuredMethodSpringBootIntegrationTest {

    @Autowired
    private SecuredService service;

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void givenUnauthenticated_whenCallService_thenThrowsException() {
        service.sayHelloSecured();
    }

    @WithMockUser(username="spring"")
    @Test
    public void givenAuthenticated_whenCallServiceWithSecured_thenOk() {
        assertThat(service.sayHelloSecured()).isNotBlank();
    }

	private Object assertThat(Object sayHelloSecured) {
		// TODO Auto-generated method stub
		return null;
	}

	

}