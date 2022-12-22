package com.model;




	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;  
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public class CustomerDao {
	    
	    @Autowired
	    SessionFactory sessionFactory;
	    
	    public Customer geById(int id){
	        return (Customer)sessionFactory.getCurrentSession().get(Customer.class, id);
	    }
	    
	    public void update(Customer cat){
	        sessionFactory.getCurrentSession().update(cat);
	    }
	    
	    
	    public List<Customer> find(){
	        Session session= sessionFactory.getCurrentSession();
	        
	        List<Customer> result =  session.createCriteria(Customer.class).list();
	   return result;
	    
	    }
	}



