package com.ezcargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ezcargo.entities.User;

/**
 * The User Repository Interface
 * @author Memo Pena
 *
 */
public interface UserRepository  extends JpaRepository<User,Long>{

}