package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezcargo.entities.Order;

/**
 * The Order Repository Interface
 * @author Memo Pena
 *
 */
public interface OrderRepository  extends JpaRepository<Order,Long>{

}
