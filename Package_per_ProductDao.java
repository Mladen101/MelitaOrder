package com.model;



	import java.util.List;

import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public class Package_per_ProductDao {
	    @Autowired
	    SessionFactory sessionFactory;
	    

	    
	    public  Package_per_Product geById(int id){
	        return ( Package_per_Product)sessionFactory.getCurrentSession().get( Package_per_Product.class, id);
	    }
	    
	    public void update( Package_per_Product r){
	        sessionFactory.getCurrentSession().update(r);
	    }
	
	    public List< Package_per_Product> findByPackage(int id){
	        Session session = sessionFactory.getCurrentSession();
	        List< Package_per_Product> result = session.getNamedQuery("Product.findByPackage").setInteger("package", id).list();
	        return result;
	    }
	    
	    public List< Package_per_Product> find(){ 
	        Session session = sessionFactory.getCurrentSession(); 
	        List< Package_per_Product> result = session.createCriteria( Package_per_Product.class).list(); 
	        return result;
	    }

		public List< Package_per_Product> findByCustomers(int id) {
			// TODO Auto-generated method stub
			return null;
		}
	}