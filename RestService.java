package service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import domain_classes.User;


@Path("RestService")
public class RestService {

	private static final Logger logger = Logger.getLogger(RestService.class);

	@GET
	@Path("/RestService")
	@Consumes("text/xml")
	
	public class UserId {
		private ArrayList users = new ArrayList();
		
		public User findUser(String id) {
			
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
		}
	
	@GET
	@Path("/RestService")
	@Consumes("text/xml")
	
	public class AllUserDetails {

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
	}
	}


	public String getSomething(@QueryParam("request") String request ,
			 @DefaultValue("1") @QueryParam("version") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start getSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}

		String response = null;

        try{			
            switch(version){
	            case 1:
	                if(logger.isDebugEnabled()) logger.debug("in version 1");

	                response = "Response from Jersey Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("result: '"+response+"'");
            logger.debug("End getSomething");
        }
        return response;	
	}

	@POST
	@Path("/RestService")
    @Produces("text/xml"))
	
	public class User1 {
		public  User1 (){}
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
		
		}
		users.add(u);
		}
	 String postSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start postSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}

		String response = null;

        try{			
            switch(version){
	            case 1:
	                if(logger.isDebugEnabled()) logger.debug("in version 1");

	                response = "Response from Jersey Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("result: '"+response+"'");
            logger.debug("End postSomething");
        }
        return response;	
	}
	
	
