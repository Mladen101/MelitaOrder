package com.proj.controller;

public class CustomerController {
	package com.proj.controller;



	import java.util.*;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.proj.model.User;

	import userservice.AllUserDetailsService;
	import userservice.User1Service;
	import userservice.UserIdService;


	@RestController
	public class CustomerController {
		
		@Autowired 
		private UserIdService userIdService;
		@Autowired 
		private AllUserDetailsService allUserDetailsService;
		@Autowired
		private User1Service user1Service;
			
			@RequestMapping("/get")
	        public List<User> getUser(@RequestParam int Id, @RequestParam(required = false) String userdata, HttpServletRequest request) {
		    HttpSession session= request.getSession();
			List<User> getById = null;
			return (List<User>) getById;
		}
			
			@RequestMapping("/getAll")
		    public List <User> getAll(@RequestParam int Id, @RequestParam(required = false) String userdata, HttpServletRequest request) {
			HttpSession session= request.getSession(); {
		    return getAll(Id, userdata, request);}
	}
			
			@RequestMapping("/create")
			public List<User> create (@RequestParam int Id,@RequestParam String Name,@RequestParam String Surname, @RequestParam Calendar year_of_birthday ,  @RequestParam(required = false) String userdata, HttpServletRequest request) {
			HttpSession session= request.getSession(); {
			User u = (User) createByName(Id, Name, Surname, year_of_birthday);
			return setUser();
			/*return u.toString();*/}
	}

			private List<User> setUser() {
				// TODO Auto-generated method stub
				return setUser();
			}

			private User createByName(int id, String name, String surname, Calendar year_of_birthday) {
				// TODO Auto-generated method stub
				return createByName(id, name, surname, year_of_birthday);
			}
	}


}
