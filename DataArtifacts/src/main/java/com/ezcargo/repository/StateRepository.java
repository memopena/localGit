package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.State;

/**
 * The State Repository Interface
 * @author Memo Pena
 *
 */
public interface StateRepository  extends JpaRepository<State,Long>{

}