package library.services;

import library.services.books.Book;
import library.services.users.User;

import java.time.LocalDate;

public class Booking {

    private int id;
    private User user;
    private Book book;

    LocalDate dateEndingBooking;
    LocalDate dateStartBooking;


    public Booking(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dateEndingBooking = null;
        this.dateStartBooking = LocalDate.now();
        this.book.addBooking(this);
    }

    public Booking(int id, User user, Book book) {
        this(user, book);
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDateEndingBooking() {
        return dateEndingBooking;
    }

    public LocalDate getDateStartBooking() {
        return dateStartBooking;
    }

    public boolean isActive() {
        return dateEndingBooking == null;
    }

    public void cancelBooking() {
        dateEndingBooking = LocalDate.now();
    }


}

