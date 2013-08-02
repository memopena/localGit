package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Trip;

/**
 * The Trip Repository Interface
 * @author Memo Pena
 *
 */
public interface TripRepository  extends JpaRepository<Trip,Long>{

}
