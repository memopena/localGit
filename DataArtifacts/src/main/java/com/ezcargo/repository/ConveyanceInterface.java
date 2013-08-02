package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Conveyance;


/**
 * The Conveyance Repository Interface
 * @author Memo Pena
 *
 */
public interface ConveyanceInterface extends JpaRepository<Conveyance,Long>{

}
