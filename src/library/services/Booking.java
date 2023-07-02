package library.services;

import library.books.Book;
import library.users.User;

import java.time.LocalDate;

public class Booking {

    private int id;
    private User user;
    private Book book;

    LocalDate dateEndingBooking;
    LocalDate dateStartBooking;


    public Booking(int id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dateEndingBooking = null;
        this.dateStartBooking = LocalDate.now();
        this.book.addBooking(this);
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

