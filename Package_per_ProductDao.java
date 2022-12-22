package com.model;



	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public class Package_per_ProductDao {
	    @Autowired
	    SessionFactory sessionFactory;
	    
	    public void save(Package_per_Product package_per_Product){
	       Session session = sessionFactory.getCurrentSession();
	       //session.beginTransaction(); 
	       session.save(package_per_Product); 
	       //session.getTransaction commit();
	    } 
	}


