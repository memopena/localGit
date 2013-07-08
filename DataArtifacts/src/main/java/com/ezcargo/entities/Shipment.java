package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the shipment database table.
 * 
 */
@Entity
public class Shipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIPMENT_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIPMENT_ID_GENERATOR")
	private int id;

	private String commodity;

	@Column(name="control_number")
	private String controlNumber;

	@Column(name="country_of_origin")
	private String countryOfOrigin;

	private String description;

	@Column(name="entry_number")
	private String entryNumber;

	@Column(name="landing_port")
	private String landingPort;

	private String measure;

	private float quantity;

	private String type;

	private BigInteger version;

	private float weight;

	//bi-directional many-to-one association to Shipper
    //@ManyToOne
	//@JoinColumn(name="shipper")
	private Shipper shipperBean;

	//bi-directional one-to-one association to Consig
	@OneToOne
	@JoinColumn(name="consignee")
	private Consig consig;

    public Shipment() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodity() {
		return this.commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getControlNumber() {
		return this.controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getCountryOfOrigin() {
		return this.countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntryNumber() {
		return this.entryNumber;
	}

	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}

	public String getLandingPort() {
		return this.landingPort;
	}

	public void setLandingPort(String landingPort) {
		this.landingPort = landingPort;
	}

	public String getMeasure() {
		return this.measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Shipper getShipperBean() {
		return this.shipperBean;
	}

	public void setShipperBean(Shipper shipperBean) {
		this.shipperBean = shipperBean;
	}
	
	public Consig getConsig() {
		return this.consig;
	}

	public void setConsig(Consig consig) {
		this.consig = consig;
	}
	
}