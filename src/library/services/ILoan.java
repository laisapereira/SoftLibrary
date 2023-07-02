package library.services;

import library.books.Book;
import library.users.User;



public interface ILoan {
    public boolean validateLoan(User user, Book book);
}
