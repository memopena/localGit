package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezcargo.entities.Shipper;

/**
 * The Shipper Repository Interface
 * @author Memo Pena
 *
 */
public interface ShipperRepository  extends JpaRepository<Shipper,Long>{

}