package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DRIVER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DRIVER_ID_GENERATOR")
	private String id;

	private String address;

	private String city;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dob;

	private String fast;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	private String license;

	@Column(name="license_country")
	private String licenseCountry;

	@Column(name="license_state")
	private String licenseState;

	@Column(name="maz_mat")
	private String mazMat;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="passport_number")
	private String passportNumber;

	private String state;

	private String status;

	private BigInteger version;

	private String zip;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="driver")
	private Set<Trip> trips;

    public Driver() {
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

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFast() {
		return this.fast;
	}

	public void setFast(String fast) {
		this.fast = fast;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseCountry() {
		return this.licenseCountry;
	}

	public void setLicenseCountry(String licenseCountry) {
		this.licenseCountry = licenseCountry;
	}

	public String getLicenseState() {
		return this.licenseState;
	}

	public void setLicenseState(String licenseState) {
		this.licenseState = licenseState;
	}

	public String getMazMat() {
		return this.mazMat;
	}

	public void setMazMat(String mazMat) {
		this.mazMat = mazMat;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Set<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
}