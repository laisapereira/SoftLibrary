package library.services.books;

import library.services.Booking;
import library.services.Loan;

public class BookCopy {

    private int id;

    private Book book;

    private Loan loan;

    private Booking booking;

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public BookCopy(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Loan getLoan() {
        return loan;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Booking getBooking() {
        return booking;
    }



}
