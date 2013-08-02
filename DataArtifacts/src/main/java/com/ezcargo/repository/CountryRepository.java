package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Country;

/**
 * The Country Repository Interface
 * @author Memo Pena
 *
 */
public interface CountryRepository extends JpaRepository<Country,Long>{

}
