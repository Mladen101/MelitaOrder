package org.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.proj.model.User;

public class User1Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser1() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {}
		
		
			
			private ArrayList users= new ArrayList();
			
			public User[] returnAllUsers(){
				User[] u = new User[users.size()];
				users.toArray(u);
				return u;
			}
			public void addUser(User u) {
				Iterator i =users.iterator();
				
			while (i.hasNext()) {
				User u2=(User)(i.next());
				
				if(u2.getId()==u.getId())
					 throw new RuntimeException("User with that Id exist");
			/*		
			 We can put also if  conditional for surname and name
			 
					if(u2.getname().equals(u.getname()))
		         throw new RuntimeException("User with that Name exist");	
					
					if(u2.getsurname().equals(u.getsurname()))	
					    throw new RuntimeException("User with that Surname exist");*/
			}
			users.add(u);
			// with object u I'm adding new user
			}
}


