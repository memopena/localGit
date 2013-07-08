package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the shipper database table.
 * 
 */
@Entity
public class Shipper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIPPER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIPPER_ID_GENERATOR")
	private String id;

	private String address;

	private String city;

	@Column(name="contact_name")
	private String contactName;

	private String country;

	private String email;

	private String name;

	private String phone;

	private String state;

	private BigInteger version;

	private String zip;

	//bi-directional many-to-one association to Shipment
	@OneToMany(mappedBy="shipperBean")
	private Set<Shipment> shipments;

	//bi-directional many-to-one association to Trip
    @ManyToOne
	@JoinColumn(name="id", referencedColumnName="id",  updatable=false, insertable=false)
	private Trip trip;

    public Shipper() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<Shipment> getShipments() {
		return this.shipments;
	}

	public void setShipments(Set<Shipment> shipments) {
		this.shipments = shipments;
	}
	
	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
}