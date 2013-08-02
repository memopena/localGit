package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Item;

/**
 * The Item Repository Interface
 * @author Memo Pena
 *
 */
public interface ItemRepository  extends JpaRepository<Item,Long>{

}