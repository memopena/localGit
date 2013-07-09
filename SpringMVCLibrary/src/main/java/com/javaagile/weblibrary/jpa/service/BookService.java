package com.javaagile.weblibrary.jpa.service;

import java.util.List;

import com.javaagile.weblibrary.exception.BookNotFoundException;
import com.javaagile.weblibrary.jpa.entity.Book;

public interface BookService {
	
	 /**
     * Adds a new Book.
     * @param added The information of the added Book.
     * @return  The added Book.
     */
    public Book add(Book added);

    /**
     * Deletes a Book.
     * @param id    The id of the deleted Book.
     * @return  The deleted Book.
     * @throws NotFoundException    if a Book is not found with the given id.
     */
    public Book deleteById(Long id) throws BookNotFoundException;

    /**
     * Finds all Books.
     * @return  A list of Books. If no Books is found this method returns an empty list.
     */
    public List<Book> findAll();

    /**
     * Finds a Book.
     * @param id    The id of the wanted Book.
     * @return  The found Book.
     * @throws NotFoundException    if no Book is found with the given id.
     */
    public Book findById(Long id) throws BookNotFoundException;

    /**
     * Updates the information of a Book.
     * @param updated   The new information of a Book.
     * @return  The updated Book.
     * @throws NotFoundException    if no Book is found with the provided id.
     */
    public Book update(Book updated) throws BookNotFoundException;

}
