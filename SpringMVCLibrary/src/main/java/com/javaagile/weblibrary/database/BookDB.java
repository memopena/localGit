
package com.javaagile.weblibrary.database;

import com.javaagile.weblibrary.exception.*;
import java.util.List;
import com.javaagile.weblibrary.cart.*;


public class BookDB {
    private String bookId = "0";
    private BookDBAO database = null;

    public BookDB() {
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setDatabase(BookDBAO database) {
        this.database = database;
    }

    public BookDetails getBookDetails() throws BookNotFoundException {
        return (BookDetails) database.getBookDetails(bookId);
    }

    public List getBooks() throws BooksNotFoundException {
        return database.getBooks();
    }

    public void buyBooks(ShoppingCart cart) throws OrderException {
        database.buyBooks(cart);
    }
}
