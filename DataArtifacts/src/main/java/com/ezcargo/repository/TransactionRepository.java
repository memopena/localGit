package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.Transaction;

/**
 * The Transaction Repository Interface
 * @author Memo Pena
 *
 */
public interface TransactionRepository  extends JpaRepository<Transaction,Long>{

}
