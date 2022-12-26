package manytomanytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.model.Customer;
import com.model.Product;

public class ManyToManyIntegrationTest {
	private static SessionFactory sessionFactory;
	private Session session;

	//...

	@Test
        public void givenSession_whenRead_thenReturnsMtoMdata() {
	    prepareData();
       	    @SuppressWarnings("unchecked")
	    List<Customer> customerList = session.createQuery("FROM Customer").list();
            @SuppressWarnings("unchecked")
	    List<Product> projectList = session.createQuery("FROM Product").list();
            assertNotNull(customerList);
            Object productList;
			assertNotNull(productList);
            assertEquals(2, customerList.size());
            assertEquals(2, ((List<Customer>) productList).size());
        
            for(Customer customer : customerList) {
               assertNotNull(customer.getProduct());
               assertEquals(2, ((List<Customer>) customer.getProduct()).size());
            }
            for(Product product : productList) {
               assertNotNull(product.getCustomer());
               assertEquals(2, ((List<Customer>) product.getCustomer()).size());
            }
        }

	private void prepareData() {
	    String[] customerData = { "Peter Jackson", "Steave Norman" };
	    String[] productData = { "Tv channels", "Discavery" };
	    Set<Product> product = new HashSet<Product>();

	    for (String proj : productData) {
		product.add(new Product());
	    }

	    for (String emp : customerData) {
		Customer customer = new Customer(null, emp.split(" ")[0], emp.split(" ")[1], emp);
		customer.setProduct(product);
			
	        for (Product proj : product) {
		    ((List<Customer>) proj.getCustomer()).add(customer);
		}
			
		session.persist(customer);
	    }
	}
}
	