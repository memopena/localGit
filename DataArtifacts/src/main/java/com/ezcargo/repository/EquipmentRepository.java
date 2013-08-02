package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Equipment;

/**
 * The Equipment Repository Interface
 * @author Memo Pena
 *
 */
public interface EquipmentRepository  extends JpaRepository<Equipment,Long>{

}
