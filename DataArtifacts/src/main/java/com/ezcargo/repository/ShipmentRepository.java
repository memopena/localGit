package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Shipment;

/**
 * The Shipment Repository Interface
 * @author Memo Pena
 *
 */
public interface ShipmentRepository  extends JpaRepository<Shipment,Long>{

}
