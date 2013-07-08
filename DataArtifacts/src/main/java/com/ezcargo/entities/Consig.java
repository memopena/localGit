package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consig database table.
 * 
 */
@Entity
public class Consig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONSIG_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSIG_ID_GENERATOR")
	private int id;

	private String address;

	private String city;

	@Column(name="consig_email")
	private String consigEmail;

	@Column(name="contact_name")
	private String contactName;

	private String fax;

	private String name;

	private String phone;

	private String taxid;

	private String zip;

	//bi-directional one-to-one association to Shipment
	@OneToOne(mappedBy="consig")
	private Shipment shipment;

	//bi-directional many-to-one association to Country
    //@ManyToOne
	//@JoinColumn(name="country")
	private Country countryBean;

	//bi-directional many-to-one association to State
    //@ManyToOne
	//@JoinColumn(name="state")
	private State stateBean;

    public Consig() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getConsigEmail() {
		return this.consigEmail;
	}

	public void setConsigEmail(String consigEmail) {
		this.consigEmail = consigEmail;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((taxid == null) ? 0 : taxid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consig other = (Consig) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taxid == null) {
			if (other.taxid != null)
				return false;
		} else if (!taxid.equals(other.taxid))
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTaxid() {
		return this.taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Shipment getShipment() {
		return this.shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	public Country getCountryBean() {
		return this.countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}
	
	public State getStateBean() {
		return this.stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}
	
}