package org.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.proj.model.User;

public class UserIdTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindUser() {}
		

 
	private ArrayList users = new ArrayList();
	
	public User findUserById(String id) {
		
		Iterator i=users.iterator();
		boolean ind=false;
		User u=null;
		while (i.hasNext()&&(!ind)) {
			u=(User)(i.next());
				if (u.getId()==id) ind=true;}
		if(ind) return u;
		//with object u I can get user's details 
		else throw new RuntimeException("User with that Id not exist");
			
		}
	{

		
		
		
		fail("Not yet implemented");
	}

}
