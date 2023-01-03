package com.model;

	import java.io.Serializable;
	import java.math.BigDecimal;
        import java.util.HashSet;
        import javax.persistence.Basic;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
        import javax.persistence.JoinColumn;
        import javax.persistence.JoinTable;
        import javax.persistence.ManyToMany;
	import javax.persistence.OneToMany;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
	import javax.persistence.Table;
	import javax.persistence.Transient;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;
	import javax.xml.bind.annotation.XmlRootElement;

	/**
	 *
	 * @author HP
	 */
	@Entity
	@Table(name = "product")
	@XmlRootElement
	@NamedQueries({
	    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
	    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
	    , @NamedQuery(name = "Product.findByInternet", query = "SELECT p FROM Product p WHERE p.internet = :internet")
	    , @NamedQuery(name = "Product.findByTv", query = "SELECT p FROM Product p WHERE p.tv = :tv")
	    , @NamedQuery(name = "Product.findByTelephony", query = "SELECT p FROM Telephony p WHERE p.telephony = :telephony")
	    , @NamedQuery(name = "Product.findByMobile", query = "SELECT p FROM Mobile p WHERE p.mobile= :mobile")
	    , @NamedQuery(name = "Product.findByPackage_per_Prooduct", query = "SELECT p FROM Package_per_Prooduct p WHERE p.package_per_Prooduct = :package_per_Prooduct")})
	
   public class Product implements Serializable {
		
     
	     
	   @ManyToMany(targetEntity=Orders.class)  
	    @JoinTable(
		        name = "Order", 
		        joinColumns = { @JoinColumn(name = "customer_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "product_id") }
		    )  
	    @OneToMany(mappedBy = "package_per_Prooduct")       
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Size(max = 256)
	    @Column(name = "internet")
	    private Short internet;	  
	    @Column(name = "tv")
	    private Short tv;
	    @Column(name = "telephony")
	    private Short telephony;
	    @Column(name = "mobile")
	    private Short mobile;
	    @Column(name = "package_per_Product")
	    private String package_per_Product;
	 
	     
	     @Transient
	    public int quantity = 0;
	    public int getQuantity(){
	        return this.quantity;
	    }

	    public Product() {
	    }

	    public Product(Integer id) {
	        this.id = id;
	    }
	   
	    public Product(Integer id, Short internet, Short tv, Short telephony, Short Mobile, String Package_per_Product ) {
	        this.id = id;
	        this.internet = internet;
	        this.tv = tv;
	        this.telephony = telephony;
	        this.mobile = mobile;
	        this.package_per_Product = package_per_Product;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Short getInternet() {
	        return internet;
	    }

	    public void setInternet(Short internet) {
	        this.internet = internet;
	    }

	    public Short getTv() {
	        return tv;
	    }

	    public void setTv(Short tv) {
	        this.tv = tv;
	    }
	    public Short getTelephony() {
	        return tv;
	    }
	    public void setTelephony(Short telephony) {
	        this.telephony = telephony;
	    }
	   
	       public Short getMobile() {
	        return mobile;
	    }
	    public void setMobile(Short mobile) {
	        this.mobile = mobile;
	    }
	    public String getPackage_per_Product() {
	        return package_per_Product;
	    }

	    public void setPackage_per_Product(String package_per_Product) {
	        this.package_per_Product = package_per_Product;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Product)) {
	            return false;
	        }
	        Product other = (Product) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.model.Product[ id=" + id + " ]";
	   
	    }

		public Object getCustomer() {
			// TODO Auto-generated method stub
			return null;
		}
	   
	   
		}

	

