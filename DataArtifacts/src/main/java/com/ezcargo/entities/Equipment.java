package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EQUIPMENT_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EQUIPMENT_ID_GENERATOR")
	private String id;

	private String country;

	@Column(name="license_plate")
	private String licensePlate;

	private String make;

	private String model;

	private String state;

	private String type;

	@Column(name="vehicle_identifaction_number")
	private String vehicleIdentifactionNumber;

	private BigInteger version;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="equipmentBean")
	private Set<Trip> trips;

    public Equipment() {
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicleIdentifactionNumber() {
		return this.vehicleIdentifactionNumber;
	}

	public void setVehicleIdentifactionNumber(String vehicleIdentifactionNumber) {
		this.vehicleIdentifactionNumber = vehicleIdentifactionNumber;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public Set<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
}