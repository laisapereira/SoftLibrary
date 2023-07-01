package library.services;

import library.users.User;

import java.awt.print.Book;

public interface IValidateLoan {
    public boolean validateLoan(User user, Book book);
}
