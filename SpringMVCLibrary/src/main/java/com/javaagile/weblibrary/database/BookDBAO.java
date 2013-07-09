
package com.javaagile.weblibrary.database;

import java.sql.*;
import java.util.*;
import com.javaagile.weblibrary.exception.*;
import com.javaagile.weblibrary.cart.*;


public class BookDBAO {
    private ArrayList books;
    Connection con;
    
    // Database configuration
    public static String url = "jdbc:derby://localhost:1527/sample";
    public static String dbdriver = "org.apache.derby.jdbc.ClientDriver";
    public static String username = "app";
    public static String password = "app";
    
    
    public BookDBAO() throws Exception {
        try {
            /*
            InitialContext ic = new InitialContext();
            Context envCtx = (Context) ic.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/BookDB");
            con = ds.getConnection();
             */
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("Exception in BookDBAO: " + ex);
            throw new Exception("Couldn't open connection to database: " +
                    ex.getMessage());
        }
    }
    
    public void remove() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List getBooks() throws BooksNotFoundException {
        books = new ArrayList();
        
        try {
            String selectStatement = "select * " + "from books";
            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            
            while (rs.next()) {
                BookDetails bd =
                        new BookDetails(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getFloat(5),
                        rs.getBoolean(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9));
                
                if (rs.getInt(9) > 0) {
                    books.add(bd);
                }
            }
            
            prepStmt.close();
        } catch (SQLException ex) {
            throw new BooksNotFoundException(ex.getMessage());
        }
        
        Collections.sort(books);
        
        return books;
    }
    
    public BookDetails getBookDetails(String bookId)
    throws BookNotFoundException {
        try {
            String selectStatement = "select * " + "from books where id = ? ";
            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, bookId);
            
            ResultSet rs = prepStmt.executeQuery();
            
            if (rs.next()) {
                BookDetails bd =
                        new BookDetails(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getFloat(5),
                        rs.getBoolean(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9));
                prepStmt.close();
                
                return bd;
            } else {
                prepStmt.close();
                throw new BookNotFoundException("Couldn't find book: " +
                        bookId);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new BookNotFoundException("Couldn't find book: " + bookId +
                    " " + ex.getMessage());
        }
    }
    
    public void buyBooks(ShoppingCart cart) throws OrderException {
        Collection items = cart.getItems();
        Iterator i = items.iterator();
        
        try {
            con.setAutoCommit(false);
            
            while (i.hasNext()) {
                ShoppingCartItem sci = (ShoppingCartItem) i.next();
                BookDetails bd = (BookDetails) sci.getItem();
                String id = bd.getBookId();
                int quantity = sci.getQuantity();
                buyBook(id, quantity);
            }
            
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception ex) {
            try {
                con.rollback();
                throw new OrderException("Transaction failed: " +
                        ex.getMessage());
            } catch (SQLException sqx) {
                throw new OrderException("Rollback failed: " +
                        sqx.getMessage());
            }
        }
    }
    
    public void buyBook(String bookId, int quantity) throws OrderException {
        try {
            String selectStatement = "select * " + "from books where id = ? ";
            PreparedStatement prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1, bookId);
            
            ResultSet rs = prepStmt.executeQuery();
            
            if (rs.next()) {
                int inventory = rs.getInt(9);
                prepStmt.close();
                
                if ((inventory - quantity) >= 0) {
                    String updateStatement =
                            "update books set inventory = inventory - ? where id = ?";
                    prepStmt = con.prepareStatement(updateStatement);
                    prepStmt.setInt(1, quantity);
                    prepStmt.setString(2, bookId);
                    prepStmt.executeUpdate();
                    prepStmt.close();
                } else {
                    throw new OrderException("Not enough of " + bookId +
                            " in stock to complete order.");
                }
            }
        } catch (Exception ex) {
            throw new OrderException("Couldn't purchase book: " + bookId +
                    ex.getMessage());
        }
    }
}
