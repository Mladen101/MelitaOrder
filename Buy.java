package com.model;



import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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
@Table(name = "Buy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buy.findAll", query = "SELECT b FROM Buy b")
    , @NamedQuery(name = "Buy.findById", query = "SELECT o FROM Buy b WHERE b.id = :id")
    , @NamedQuery(name = "Buy.findByNumber", query = "SELECT b FROM Buy b WHERE b.number = :number")
    , @NamedQuery(name = "Buy.findByTime", query = "SELECT b FROM Buy b WHERE b.time = :time")
    , @NamedQuery(name = "Buy.findByCustomers", query = "SELECT b FROM Buy b WHERE b.customers = :customers")
    , @NamedQuery(name = "Buy.findByProducts", query = "SELECT b FROM Buy b WHERE b.products = :products")
})
public class Buy implements Serializable {
	
	   @ManyToMany
	   @JoinTable(
	        name = "Buy", 
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
    @Size(min = 1, max = 45)
    @Column(name = "number")
    private String number;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @NotNull
  
    public Buy() {
    }

    public Buy(Integer id) {
        this.id = id;
    }

    public Buy(Integer id, String customerdata, String products) {
        this.id = id;
        this.number = number;
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        if (!(object instanceof Buy)) {
            return false;
        }
        Buy other = (Buy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Buy[ id=" + id + " ]";
    }
    
}



