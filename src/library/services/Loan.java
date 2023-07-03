package library.services;

import library.services.books.BookCopy;
import library.services.users.User;

import java.time.LocalDate;

public class Loan {

    private User user;
    private BookCopy bookCopy;

    boolean isActive;

    LocalDate dateEndingLoan;
    LocalDate dateStartLoan;

    public Loan(User user, BookCopy bookCopy) {
        this.user = user;
        this.bookCopy = bookCopy;
        this.dateStartLoan = LocalDate.now();
        this.isActive = true;
    }

    public User getUser() {
        return user;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public LocalDate getDateEndingLoan() {
        return dateEndingLoan;
    }

    public LocalDate getDateStartLoan() {
        return dateStartLoan;
    }

    public boolean isActive() {
        return isActive;
    }

    public void cancelLoan() {
        dateEndingLoan = LocalDate.now();
        isActive = false;

    }

    public LocalDate dateExpectedReturn() {
        return dateStartLoan.plusDays(user.getMaxTimeLoan());
    }





}
