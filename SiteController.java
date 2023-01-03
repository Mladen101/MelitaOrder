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
	
	/*I created a customer class and a product class, and associated them with a many-to-many relatioons in order class,
	 and order class and package_per_product class connected with relations one to many  */

	private String customerdata;
    
    @RequestMapping("/confirm")
    public String confirmOrder(@RequestParam(required = false) String customerdata, HttpServletRequest request, ModelMap model){
        List<Product> product = ProductDao.find(); 
        model.addAttribute("product", product);
        
        if(customerdata==null){
             
             
        } else {
            
            StringBuilder sb = new StringBuilder();
            
                    
            HttpSession session= request.getSession();
            HashMap<Integer,Package_per_Product> sessionPackage_per_Product = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");        
            sb.append("[");
            for(Map.Entry<Integer,Package_per_Product> p : sessionPackage_per_Product.entrySet()){ 
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
            order.setProduct(substr);        
			order.setCustomerdata(customerdata); 
            ordersDao.save(order);
            
            session.removeAttribute("cart");
            return "confirmsuccess";   
        }
        return "confirm";
    }
    



    @RequestMapping("/remove")
    public String remove(@RequestParam(required = true) int id, HttpServletRequest request, ModelMap model){ 
        List<Product> product = productDao.find(); 
        model.addAttribute("product", product);
        
        HttpSession session = request.getSession();
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Package_per_Product> package_per_Product = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");
            if(package_per_Product.containsKey(id)){
            	package_per_Product.remove(id);
            }
        }
        
        return "remove";
    }
    
    
    @RequestMapping("/cart")
    public String cart(HttpServletRequest request, ModelMap model){
        
        List<Product> product = productDao.find(); 
        model.addAttribute("product", product);
        
     
        List<Package_per_Product> package_per_Product = new ArrayList<Package_per_Product>();
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("cart")!=null){
            HashMap<Integer,Package_per_Product> sessionPackage_per_Product = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");
            for(Map.Entry<Integer,Package_per_Product> p : sessionPackage_per_Product.entrySet()){
            	package_per_Product.add(p.getValue());
            }
        }
         
        model.addAttribute("package_per_Product", package_per_Product);
        
        return "cart";
    }
    
    @RequestMapping("/addtobasket")
    public String addToBasket(ModelMap model, HttpServletRequest request, @RequestParam(required = true) Integer id,@RequestParam(required = true) Integer quantity){
        
        HttpSession session = request.getSession();
        HashMap<Integer, Package_per_Product> cart;
        if(session.getAttribute("cart")==null){
            session.setAttribute("cart", new HashMap<Integer,Package_per_Product>()); 
        }
        cart = (HashMap<Integer,Package_per_Product>)session.getAttribute("cart");
        
        if(!cart.containsKey(id)){ 
        	Package_per_Product package_per_Product = package_per_ProductDao.geById(id);
        	package_per_Product.quantity = quantity;
            cart.put(id,package_per_Product);
        } else {
        	Package_per_Product package_per_ProductFromCart = cart.get(id);
        	package_per_ProductFromCart.quantity+=quantity;
        }
        
        List<Product> product = productDao.find(); 
        model.addAttribute("product ", product ); 
        
        return "addedtobasket";
    }
    
    @RequestMapping("/tobasket/{id}")
    public String toBasket(@PathVariable int id, ModelMap model){
        List<Product > product  = productDao.find(); 
        model.addAttribute("product ", product ); 
        Package_per_Product package_per_Product = package_per_ProductDao.geById(id);
        model.addAttribute("package_per_Product", package_per_Product);
        return "tobasket";
    }
    

    
    @RequestMapping("/")
    public String index(ModelMap model){ 
        List<Product> product  = productDao.find(); 
        model.addAttribute("product", product ); 
        return byProduct (1, model);
    }
    
    

    
    @RequestMapping("/{id}")
    public String byProduct(@PathVariable int id, ModelMap model){ 
        List<Product> product  = productDao.find(); 
        List<Package_per_Product> package_per_Product = package_per_ProductDao.findByProduct(id);
        model.addAttribute("product", product); 
        model.addAttribute("package_per_Product", package_per_Product); 
        return "index";
    }
}






    








    

