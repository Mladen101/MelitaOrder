package com.model;




	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public class ProductDao {
	    @Autowired
		static
	    SessionFactory sessionFactory;
	    
	    public  Product geById(int id){
	        return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
	    }
	    
	    public void update(Product p){
	        sessionFactory.getCurrentSession().update(p);
	    }
	   /* 
	    public Long pages(){
	       return ((Double)Math.ceil((Long)sessionFactory.getCurrentSession().createQuery("select count(id) from Product").uniqueResult()/3)).longValue();
	    }
	    
	    public List<> findByPage(int page){
	        int perpage =3 ;
	        Session session = sessionFactory.getCurrentSession();
	        List<Product> result = session.createQuery("from Product").setFirstResult(page*perpage).setMaxResults(perpage).list();
	        return result;
	    }
	    */
	    public List<Product> findByPackage(int id){
	        Session session = sessionFactory.getCurrentSession();
	        List<Product> result = session.getNamedQuery("Product.findByPackage").setInteger("package", id).list();
	        return result;
	    }
	    
	    public List<Product> find(){ 
	        Session session = sessionFactory.getCurrentSession(); 
	        List<Product> result = session.createCriteria(Product.class).list(); 
	        return result;
	    }

		public List<Product> findByCustomer(int id) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	 
	    
	    



