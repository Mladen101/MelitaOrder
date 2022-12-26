package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@RunWith(SpringRunner.class)
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	public class SecuredControllerRestTemplateIntegrationTest {

	    @Autowired
	    private TestRestTemplate template;

	    // ... other methods

	    @Test
	    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
	        ResponseEntity<String> result = template.withBasicAuth("spring", "secret")
	          .getForEntity("/private/hello", String.class);
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	    }
	}


