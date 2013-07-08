package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the conveyance database table.
 * 
 */
@Entity
public class Conveyance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONVEYANCE_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONVEYANCE_ID_GENERATOR")
	private String id;

	private String country;

	private String insurer;

	@Column(name="license_plate")
	private String licensePlate;

	private String make;

	private String model;

	@Column(name="policy_amount")
	private String policyAmount;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="policy_date")
	private Date policyDate;

	@Column(name="policy_number")
	private String policyNumber;

	private String state;

	private String transponder;

	private String type;

	@Column(name="vehicle_identification_number")
	private String vehicleIdentificationNumber;

	private BigInteger version;

    public Conveyance() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getInsurer() {
		return this.insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPolicyAmount() {
		return this.policyAmount;
	}

	public void setPolicyAmount(String policyAmount) {
		this.policyAmount = policyAmount;
	}

	public Date getPolicyDate() {
		return this.policyDate;
	}

	public void setPolicyDate(Date policyDate) {
		this.policyDate = policyDate;
	}

	public String getPolicyNumber() {
		return this.policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTransponder() {
		return this.transponder;
	}

	public void setTransponder(String transponder) {
		this.transponder = transponder;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicleIdentificationNumber() {
		return this.vehicleIdentificationNumber;
	}

	public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

}