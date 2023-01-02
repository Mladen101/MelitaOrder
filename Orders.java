
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
//import javax.validation.constOrdering Fulfilment systemraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByCustomerdata", query = "SELECT o FROM Orders o WHERE o.customerdata = :customerdata")
    , @NamedQuery(name = "Orders.findByOrdertime", query = "SELECT o FROM Orders o WHERE o.ordertime = :ordertime")
    , @NamedQuery(name = "Orders.findByPackage_per_Products", query = "SELECT o FROM Orders o WHERE o.products = :products")
    , @NamedQuery(name = "Orders.findByCustomers", query = "SELECT o FROM Orders o WHERE o.customers = :customers")})
 

public class Orders implements Serializable {
	
	
		   @ManyToMany
		   @JoinTable(
		        name = "Orders", 
		        joinColumns = { @JoinColumn(name = "customer_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "product_id") })


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "customererdata")
    private String customerdata;
    @Column(name = "ordertime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordertime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "products")
    private String products;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, String customerdata, String products) {
        this.id = id;
        this.customerdata = customerdata;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerdata() {
        return customerdata;
    }

    public void setCustomerdata(String customerdata) {
        this.customerdata = customerdata;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Orders[ id=" + id + " ]";
    }

	public void setPackage_per_Products(String substr) {
		// TODO Auto-generated method stub
		
	}
    
}

