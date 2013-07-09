
package com.javaagile.weblibrary.exception;


/** This application exception indicates that books
 *  have not been found.
 */
public class BooksNotFoundException extends Exception {
    public BooksNotFoundException() {
    }

    public BooksNotFoundException(String msg) {
        super(msg);
    }
}
