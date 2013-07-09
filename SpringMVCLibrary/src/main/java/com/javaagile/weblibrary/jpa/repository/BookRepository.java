package com.javaagile.weblibrary.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaagile.weblibrary.jpa.entity.Book;

/**
 * Provides the repository methods for books.
 * @author Memo Pena
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
}
