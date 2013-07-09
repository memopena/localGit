
package com.javaagile.weblibrary.exception;


/** This application exception indicates that a book
 *  has not been found.
 */
public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
    }

    public BookNotFoundException(String msg) {
        super(msg);
    }
}
