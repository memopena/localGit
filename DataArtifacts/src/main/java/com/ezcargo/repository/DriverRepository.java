package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Driver;

/**
 * The Driver Repository Interface
 * @author Memo Pena
 *
 */
public interface DriverRepository  extends JpaRepository<Driver,Long>{

}
