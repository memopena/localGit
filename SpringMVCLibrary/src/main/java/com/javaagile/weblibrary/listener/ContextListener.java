
package com.javaagile.weblibrary.listener;

import com.javaagile.weblibrary.database.BookDBAO;
import javax.servlet.*;


public final class ContextListener implements ServletContextListener {
    private ServletContext context = null;

    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();

        try {
            BookDBAO bookDBAO = new BookDBAO();
            context.setAttribute("bookDBAO", bookDBAO);
        } catch (Exception ex) {
            System.out.println("Couldn't create bookstore database bean: " +
                ex.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();

        BookDBAO bookDBAO = (BookDBAO) context.getAttribute("bookDBAO");

        if (bookDBAO != null) {
            bookDBAO.remove();
        }

        context.removeAttribute("bookDBAO");
    }
}
