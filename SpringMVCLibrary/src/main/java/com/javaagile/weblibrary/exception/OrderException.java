
package com.javaagile.weblibrary.exception;


/** This application exception indicates that an order cannot be completed.
 */
public class OrderException extends Exception {
    public OrderException() {
    }

    public OrderException(String msg) {
        super(msg);
    }
}
