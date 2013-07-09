
package com.javaagile.weblibrary.controller;

import javax.servlet.http.*;
import com.javaagile.weblibrary.cart.ShoppingCart;
import com.javaagile.weblibrary.database.*;
import com.javaagile.weblibrary.exception.*;


public class Dispatcher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String bookId = null;
        String clear = null;
        BookDetails book = null;
        BookDBAO bookDBAO =
            (BookDBAO) getServletContext()
                           .getAttribute("bookDBAO");
        HttpSession session = request.getSession();
        
        // Retrieve ServletPath from the request object.
        String selectedScreen = request.getServletPath();
        
        // Retrieve ShoppingCart session attribute.
        // If this is the first time, ShoppingCart object needs to be
        // created and saved as a session scope attribute called "cart'.
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        // Handle "/bookcatalog" request
        if (selectedScreen.equals("/bookcatalog")) {
            bookId = request.getParameter("Add");

            if (!bookId.equals("")) {
                try {
                    book = bookDBAO.getBookDetails(bookId);
                    cart.add(bookId, book);
                } catch (BookNotFoundException ex) {
                    // not possible
                }
            }
        } else if (selectedScreen.equals("/bookshowcart")) {
            bookId = request.getParameter("Remove");

            if (bookId != null) {
                cart.remove(bookId);
            }

            clear = request.getParameter("Clear");

            if ((clear != null) && clear.equals("clear")) {
                cart.clear();
            }
        } else if (selectedScreen.equals("/bookreceipt")) {
            // Update the inventory
            try {
                bookDBAO.buyBooks(cart);
            } catch (OrderException ex) {
                selectedScreen = "/bookordererror";
            }
        }

        // Determine the destination jsp for forwarding
        String screen = selectedScreen + ".jsp";

        // Perform the forwarding
        try {
            request.getRequestDispatcher(screen)
                   .forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String screen = request.getServletPath() + ".jsp";

        try {
            request.getRequestDispatcher(screen)
                   .forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
