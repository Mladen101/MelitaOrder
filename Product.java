package com.model;

	import java.io.Serializable;
	import java.math.BigDecimal;
	import javax.persistence.Basic;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
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
	    , @NamedQuery(name = "Product.findByCustomer", query = "SELECT p FROM Product p WHERE p.customer = :customer")})
	
   public class Product implements Serializable {
		
	    @Column(name = "customer")
	    private Integer customer;

	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Size(max = 256)
	    @Column(name = "internet")
	    private Short internet;
	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	    @Column(name = "tv")
	    private Short tv;
	    @Column(name = "telephony")
	    private Short telephony;
	    @Column(name = "mobile")
	    private Short mobile;
	 
	     
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

	    public Integer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Integer customr) {
	        this.customer = customer;
	    }
	    

}



