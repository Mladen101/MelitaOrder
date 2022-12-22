package com.model;


	import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
	import javax.persistence.Table;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;
	import javax.xml.bind.annotation.XmlRootElement;

	/**
	 *
	 * @author HP
	 */
	@Entity
	@Table(name = "categories")
	@XmlRootElement
	@NamedQueries({
	    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Category c")
	    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
	    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Name c WHERE c.name = :name")
	    , @NamedQuery(name = "Customer.findByfindBySurname", query = "SELECT c FROM Surname c WHERE c.surname = :surname")
	    , @NamedQuery(name = "Customer.findByInstalation_address", query = "SELECT c FROM Instalation_address c WHERE c.instalation_address = :instalation_address")
        , @NamedQuery(name = "Customer.findByInstalation_date", query = "SELECT c FROM Instalation_date c WHERE c.instalation_date = :instalation_date")})
	public class Customer implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "id")
	    private Integer id;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "name")
	    private String name;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "surname")
	    private String surname;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name= "instalation_address")
	    private String instalation_address;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "instalation_date")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date installation_date;
	 
	 
	    public Customer() {
	    }

	    public Customer(Integer id) {
	        this.id = id;
	    }

	    public Customer(Integer id, String name, String surname, String instalation_address) {
	        this.id = id;
	        this.name = name;
	        this.name = surname;
	        this.instalation_address= instalation_address;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    }
	    
	    public String getInstalation_address() {
	        return surname;
	    }

	    public void setInstalation_address(String instalation_address) {
	        this.instalation_address = instalation_address;
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
	        if (!(object instanceof Customer)) {
	            return false;
	        }
	        Customer other = (Customer) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.model.Customer[ id=" + id + " ]";
	    }
	    
	}


