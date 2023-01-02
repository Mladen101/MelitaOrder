package com.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.model.Buy;
//import com.model.BuyDao;
import com.model.Customer;
import com.model.CustomerDao;
import com.model.Orders;
import com.model.OrdersDao;
import com.model.Package_per_Product;
import com.model.Package_per_ProductDao;
import com.model.Product;
import com.model.ProductDao;

@Controller
public class SiteController {
     
    @Autowired
    CustomerDao customerDao;
    
    @Autowired
    ProductDao productDao;
    
    @Autowired
    Package_per_ProductDao  package_per_ProductDao;
    
    @Autowired
    OrdersDao ordersDao;
    
   // @Autowired
   // BuyDao buyDao;

	private String customerdata;
    
    @RequestMapping("/confirm")
    public String confirmOrder(@RequestParam(required = false) String customerdata, HttpServletRequest request, ModelMap model){
        List<Customer> customer = customerDao.find(); 
        model.addAttribute("customer", customer);
        
        if(customerdata==null){
             
             
        } else {
            
            StringBuilder sb = new StringBuilder();
            
                    
            HttpSession session= request.getSession();
            HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");        
            sb.append("[");
            for(Map.Entry<Integer,Product> p : sessionProducts.entrySet()){ 
                sb.append("{\"id\":");
                sb.append(p.getValue().getId());
                sb.append(",\"q\":");
                sb.append(p.getValue().getQuantity());
                sb.append("},");
            }
            String substr = sb.substring(0, sb.length()-1);
            substr += "]";
            Orders order = new Orders();
            order.setOrdertime(new Date(new java.util.Date().getTime()));
            order.setProducts(substr);        
			order.setCustomerdata(customerdata); 
            ordersDao.save(order);
            
            session.removeAttribute("cart");
            return "confirmsuccess";   
        }
        return "confirm";
    }
    
    
    @RequestMapping("/confirmPackage_per_Product")
    public String confirmPackage_per_Product(@RequestParam(required = false) String customerdata, HttpServletRequest request, ModelMap model){
        List<Customer> customer = customerDao.find(); 
        model.addAttribute("customer", customer);
		

        
        if(customerdata==null){
             
             
        } else {
            
            StringBuilder sb = new StringBuilder();
            
                    
            HttpSession session= request.getSession();
            HashMap<Integer,Package_per_Product> sessionPackage_per_Product = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");        
            sb.append("[");
            for(Map.Entry<Integer,Package_per_Product> r : sessionPackage_per_Product.entrySet()){ 
                sb.append("{\"id\":");
                sb.append(r.getValue().getId());
                sb.append(",\"q\":");
                sb.append(r.getValue().getQuantity());
                sb.append("},");
            }
            String substr = sb.substring(0, sb.length()-1);
            substr += "]";
            Orders order = new Orders();
            order.setOrdertime(new Date(new java.util.Date().getTime()));
            order.setPackage_per_Products(substr);        
			order.setCustomerdata(customerdata); 
            ordersDao.save(order);
            
            session.removeAttribute("cart");
            return "confirmsuccess";   
        }
        return "confirmPackage_per_Product";
    }


    @RequestMapping("/remove")
    public String remove(@RequestParam(required = true) int id, HttpServletRequest request, ModelMap model){ 
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers);
        
        HttpSession session = request.getSession();
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Package_per_Product> package_per_Product = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");
            if(package_per_Product.containsKey(id)){
            	package_per_Product.remove(id);
            }
        }
        
        return "remove";
    }
    
    
    
    @RequestMapping("/remove")
    public String removeProduct(@RequestParam(required = true) int id, HttpServletRequest request, ModelMap model){ 
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers);
        
        HttpSession session = request.getSession();
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Product> product = (HashMap<Integer,Product>)session.getAttribute("cart");
            if(product.containsKey(id)){
            	product.remove(id);
            }
        }
        
        return "remove";
    }
    
    @RequestMapping("/cart")
    public String cart(HttpServletRequest request, ModelMap model){
        
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers);
        
        List<Product> products = new ArrayList<Product>(); 
        List<Package_per_Product> package_per_Product = new ArrayList<Package_per_Product>();
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
            for(Map.Entry<Integer,Product> p : sessionProducts.entrySet()){
                products.add(p.getValue());
            }
        }
         
        model.addAttribute("products", products);
        
        return "cart";
    }
    
    @RequestMapping("/addtobasket")
    public String addToBasket(ModelMap model, HttpServletRequest request, @RequestParam(required = true) Integer id,@RequestParam(required = true) Integer quantity){
        
        HttpSession session = request.getSession();
        HashMap<Integer, Product> cart;
        if(session.getAttribute("cart")==null){
            session.setAttribute("cart", new HashMap<Integer,Customer>()); 
        }
        cart = (HashMap<Integer,Product>)session.getAttribute("cart");
        
        if(!cart.containsKey(id)){ 
            Product product = productDao.geById(id);
            product.quantity = quantity;
            cart.put(id,product);
        } else {
           Product productFromCart = cart.get(id);
            productFromCart.quantity+=quantity;
        }
        
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers); 
        
        return "addedtobasket";
    }
    
    @RequestMapping("/tobasket/{id}")
    public String toBasket(@PathVariable int id, ModelMap model){
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers); 
        Package_per_Product package_per_Product = package_per_ProductDao.geById(id);
        model.addAttribute("package_per_Product", package_per_Product);
        return "tobasket";
    }
    

    
    @RequestMapping("/")
    public String index(ModelMap model){ 
        List<Customer> customers = customerDao.find(); 
        model.addAttribute("customers", customers); 
        return byCustomer(1, model);
    }
    
    
    @RequestMapping("/{id}")
    public String byCustomer(@PathVariable int id, ModelMap model){ 
        List<Customer> customer = customerDao.find(); 
        List<Product> products = productDao.findByCustomer(id);
        model.addAttribute("customer", customer); 
        model.addAttribute("products", products); 
        return "index";
    }

    
    @RequestMapping("/{id}")
    public String byCustomers(@PathVariable int id, ModelMap model){ 
        List<Customer> customers = customerDao.find(); 
        List<Package_per_Product> package_per_Products = package_per_ProductDao.findByCustomers(id);
        model.addAttribute("customers", customers); 
        model.addAttribute("package_per_Products", package_per_Products); 
        return "index";
    }
}






    

