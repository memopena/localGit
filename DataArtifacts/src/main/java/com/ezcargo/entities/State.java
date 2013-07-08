package com.ezcargo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATE_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATE_ID_GENERATOR")
	private String id;

	@Column(name="country_id")
	private String countryId;

	private String name;

	private BigInteger version;

	//bi-directional many-to-one association to Consig
	@OneToMany(mappedBy="stateBean")
	private Set<Consig> consigs;

    public State() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public Set<Consig> getConsigs() {
		return this.consigs;
	}

	public void setConsigs(Set<Consig> consigs) {
		this.consigs = consigs;
	}
	
}