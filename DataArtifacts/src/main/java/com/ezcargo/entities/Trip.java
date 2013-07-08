package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the trip database table.
 * 
 */
@Entity
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRIP_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRIP_ID_GENERATOR")
	private String id;

	private String consignee;

    @Temporal( TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="entry_number")
	private String entryNumber;

	@Column(name="entry_port")
	private String entryPort;

	private String number;

	private String origin;

	@Column(name="shipment_type")
	private String shipmentType;

	private String state;

	private String status;

	private String truck;

	private String type;

	private BigInteger version;

	//bi-directional many-to-one association to Driver
    @ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;

	//bi-directional many-to-one association to Equipment
    @ManyToOne
	@JoinColumn(name="equipment")
	private Equipment equipmentBean;

	//bi-directional many-to-one association to Shipper
	@OneToMany(mappedBy="trip")
	private Set<Shipper> shippers;

    public Trip() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEntryNumber() {
		return this.entryNumber;
	}

	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}

	public String getEntryPort() {
		return this.entryPort;
	}

	public void setEntryPort(String entryPort) {
		this.entryPort = entryPort;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getShipmentType() {
		return this.shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
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

	public String getTruck() {
		return this.truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
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

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Equipment getEquipmentBean() {
		return this.equipmentBean;
	}

	public void setEquipmentBean(Equipment equipmentBean) {
		this.equipmentBean = equipmentBean;
	}
	
	public Set<Shipper> getShippers() {
		return this.shippers;
	}

	public void setShippers(Set<Shipper> shippers) {
		this.shippers = shippers;
	}
	
}