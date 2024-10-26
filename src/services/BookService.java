package services;

import conf.Database;
import interfaces.IService;
import models.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookService implements IService<Book> {
    public BookService() {}

    @Override
    public ArrayList<Book> findAll() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from books");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Book book = new Book(
                    rs.getLong("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getInt("quanlity")
            );
            books.add(book);
        }
        return books;
    }

    @Override
    public boolean save(Book book) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement("insert into books(title) values (?)");
        stmt.setString(1, book.getTitle());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement("DELETE FROM books WHERE id = ?");
        stmt.setLong(1, id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement("UPDATE books set name = ? where id = ?");
        stmt.setString(1, book.getTitle());
        stmt.setLong(2, book.getid());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public Book findById(long id) throws SQLException {
        Book book = null;
        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from books where id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            book = new Book(
                    rs.getLong("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getInt("quanlity")
            );
        }
        return book;
    }
}
