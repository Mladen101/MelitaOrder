package com.model;




	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public class BuyDao {
	    @Autowired
	    SessionFactory sessionFactory;
	    
	    public Buy geById(int id){
	        return (Buy)sessionFactory.getCurrentSession().get(Buy.class, id);
	    }
	    
	    public void update(Buy b){
	        sessionFactory.getCurrentSession().update(b);
	    }
	    public List<Buy> findByCustomer(int id){
	        Session session = sessionFactory.getCurrentSession();
	        List<Buy> result = session.getNamedQuery("Buy.findByCustomer").setInteger("customer", id).list();
	        return result;
	    }
	
	    
	    public List<Buy> findByProduct(int id){
	        Session session = sessionFactory.getCurrentSession();
	        List<Buy> result = session.getNamedQuery("Buy.findByProduct").setInteger("product", id).list();
	        return result;
	    }
	    public List<Buy> find(){ 
	        Session session = sessionFactory.getCurrentSession(); 
	        List<Buy> result = session.createCriteria(Buy.class).list(); 
	        return result;
	    }
	}

