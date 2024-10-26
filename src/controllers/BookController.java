package controllers;

import errors.BusinessLogicException;
import interfaces.IController;
import models.Book;
import services.BookService;

import java.sql.SQLException;
import java.util.ArrayList;


public class BookController implements IController<Book> {
    private final ArrayList<Book> books;
    private BookService bookService;

    public BookController(BookService bookService) throws SQLException {
        this.bookService = bookService;
        books = bookService.findAll();
    }

    @Override
    public void display() {
        System.out.printf(Book.toStringHeader());
        for (Book book : this.books) {
            System.out.printf(book.toString());
        }
    }

    private Book findbookById(long id) {
        Book book = null;
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getid() == id) {
                book = this.books.get(i);
                break;
            }
        }
        return book;
    }

    private int findIndexBybookId(long id) {
        int index = -1;
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getid() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void removeItem(long id) throws SQLException {
        Book book = this.findbookById(id);
        if (book == null) {
            throw new BusinessLogicException(this.getClass(), "Không tìm thấy sách với id đã cho");
        }
        this.books.remove(book);
        this.bookService.remove(id);
    }

    @Override
    public void update(Book book) throws SQLException {
        int index = this.findIndexBybookId(book.getid());
        if (index == -1) {
            throw new BusinessLogicException(this.getClass(), "Không tìm thấy sách với id đã cho");
        }
        this.books.add(index, book);
        this.bookService.update(book);
    }

    @Override
    public void insert(Book book) throws SQLException {
        this.books.add(book);
        this.bookService.save(book);
    }
}
