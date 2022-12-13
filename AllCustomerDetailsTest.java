package org.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.proj.model.User;

public class AllUserDetailsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturnUsersByDateOfBirthDay() {}


		private ArrayList users= new ArrayList ();
		
	public Collection returnUsersByDateOfBirthDay(Calendar c) {
		Collection cr=new ArrayList();
		Iterator i= users.iterator();
		while (i.hasNext()) {
			User u=(User)(i.next());
		   Calendar c2=u.getYear_of_birthday();
			if ((c2.get(Calendar.YEAR)==c.get(Calendar.YEAR))&&
	         (c2.get(Calendar.MONTH)==c.get(Calendar.MONTH))&&
	         (c2.get(Calendar.DAY_OF_MONTH)==c.get(Calendar.DAY_OF_MONTH)))
		cr.add(u);
		}
		return cr;
		//with object cr I can get user's details, by date of birth
	}

	}


