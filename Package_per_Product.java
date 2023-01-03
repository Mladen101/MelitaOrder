package com.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "package_per_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package_per_product.findAll", query = "SELECT r FROM Package_per_product r")
    , @NamedQuery(name = "Package_per_product.findById", query = "SELECT r FROM Package_per_product r WHERE r.id = :id")
    , @NamedQuery(name = "Package_per_product.findByInternet_1_GBs", query = "SELECT r FROM  Package_per_product r WHERE r.Internet_1_GBs = :Internet_1_GB/s")
    , @NamedQuery(name = "Package_per_product.findByInternet_250MBs", query = "SELECT r FROM  Package_per_product r WHERE r.Internet_250MBs = :Internet_250MB/s")
    , @NamedQuery(name = "Package_per_product.findByTv_with_90_channels", query = "SELECT r FROM  Package_per_product r WHERE r.Tv_with_90_channels = :Tv_with_90_channels")
    , @NamedQuery(name = "Package_per_product.findByTv_with_150_channels", query = "SELECT r FROM  Package_per_product r WHERE r.Tv_with_150_channels = :Tv_with_150_channels")
    , @NamedQuery(name = "Package_per_product.findByTelephony_with_free_calls", query = "SELECT r FROM  Package_per_product r WHERE r.Telephony_with_free_calls = :Telephony_with_free_calls")
    , @NamedQuery(name = "Package_per_product.findByMobileprepaid", query = "SELECT r FROM  Package_per_product r WHERE r.Mobileprepaid = :Mobileprepaid")
    , @NamedQuery(name = "Package_per_product.findByMobilepostpaid", query = "SELECT r FROM  Package_per_product r WHERE r.Mobilepostpaid = :Mobilepostpaid")
    , @NamedQuery(name = "Package_per_product.findByProducts", query = "SELECT r FROM Package_per_product r WHERE r.products = :products")})
public class  Package_per_Product implements Serializable {
	
	  @ManyToOne()

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Internet_1_GBs")
    private String Internet_1_GBs;
    @Size(min = 1, max = 45)
    @Column(name = "Internet_250MBs")
    private String Internet_250MBs;                            
    @Size(min = 1, max = 45)
    @Column(name = "Tv_with_90_channels")
    private String Tv_with_90_channels;
    @Size(min = 1, max = 45)
    @Column(name = "Tv_with_150_channels")
    private String Tv_with_150_channels;
    @Column(name = "Telephony_with_free_calls")
    private Integer Telephony_with_free_calls;
    @Column(name = " Mobileprepaid")
    private Integer  Mobileprepaid;
    @Column(name = "  Mobilepostpaid")
    private Integer   Mobilepostpaid;
    @Column(name = "products")
    private String products;
	private String internet;
	private Object Internet_1_GBs;
	private Object Internet_250_MBs;

    public Package_per_Product() {
    }

    public Package_per_Product(Integer id) {
        this.id = id;
    
    }
  
   public Package_per_Product(Integer id, String Internet_1_GBs, String Internet_250MBs, String Tv_with_90_channels, String Tv_with_150_channels, Integer Telephony_with_free_calls, Integer  Mobileprepaid, Integer Mobilepostpaid){
   {
  

        this.id = id;
        this.Internet_1_GBs1 = Internet_1_GBs;
        this.Internet_250_MBs= Internet_250_MBs;
        this.Tv_with_90_channels= Tv_with_90_channels;
        this.Tv_with_150_channels= Tv_with_150_channels;
        this.Tv_with_150_channels= Tv_with_150_channels;
        this.Tv_with_150_channels= Tv_with_150_channels;
        this.Telephony_with_free_calls=Telephony_with_free_calls ;
        this.Mobileprepaid=Mobileprepaid;
        this.Mobilepostpaid=Mobilepostpaid;}
        
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternet() {
        return getInternet();
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String  getTv_with_90_channels() {
        return Tv_with_90_channels;
    }

    public void setTv_with_90_channels(String Tv_with_90_channels) {
        this.Tv_with_90_channels = Tv_with_90_channels;
    }

    public String  getTv_with_150_channels() {
        return Tv_with_150_channels;
   
    }
    
    public void setTv_with_150_channels(String Tv_with_150_channels) {
        this.Tv_with_150_channels = Tv_with_150_channels;
    }   
    public Integer  getTelephony_with_free_calls() {
        return Telephony_with_free_calls;
   
    }
    public void setTelephony_with_free_calls( Integer Telephony_with_free_calls) {
        this.Telephony_with_free_calls = Telephony_with_free_calls;
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
        if (!(object instanceof Package_per_Product)) {
            return false;
        }
        Package_per_Product other = (Package_per_Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Package_per_Product[ id=" + id + " ]";
    }

	public Object getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
    
}

