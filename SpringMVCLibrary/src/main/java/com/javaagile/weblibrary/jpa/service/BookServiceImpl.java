package com.javaagile.weblibrary.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaagile.weblibrary.exception.BookNotFoundException;
import com.javaagile.weblibrary.jpa.entity.Book;
import com.javaagile.weblibrary.jpa.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
	
	
	@Resource
	private BookRepository repository;

	
	@Transactional
	public Book add(Book added) {
		
		LOGGER.debug("Adding new book with information: {}", added);
		
		//Creates an instance of a book by using the builder pattern
        Book book = Book.getBuilder(added.getTitle(), added.getAuthorFirstName(), added.getAuthorLastName())
                .price(added.getPrice())
                .onSale(added.isOnSale())
                .year(added.getYear())
                .description(added.getDescription())
                .build();
        
        return repository.save(book);
	}
	
	@Transactional(rollbackFor = BookNotFoundException.class)
	public Book deleteById(Long id) throws BookNotFoundException {
		
		LOGGER.debug("Deleting book by id: {}", id);

        Book deleted = findById(id);
        repository.delete(deleted);

        LOGGER.debug("Deleted book: {}", deleted);

        return deleted;
		
	}
	
	
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		
		LOGGER.debug("Finding all books");
        return repository.findAll();
        
	}
	
	@Transactional(readOnly = true)
	public Book findById(Long id) throws BookNotFoundException {
		
		LOGGER.debug("Finding book by id: {}", id);

        Book found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No book found with id: {}", id);
            throw new BookNotFoundException("No book found with id: " + id);
        }

        LOGGER.debug("Found book: {}", found);

        return found;
	}

	@Transactional(rollbackFor = BookNotFoundException.class)
	public Book update(Book updated) throws BookNotFoundException {
		LOGGER.debug("Updating contact with information: {}", updated);
		
		Book found = findById(updated.getId());
		found.update(updated.getPrice(), updated.isOnSale(), updated.getYear(), updated.getDescription());
		
		return found;
	}

}
