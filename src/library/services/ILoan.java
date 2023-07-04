package library.services;

import library.services.books.Book;
import library.services.users.User;



public interface ILoan {
    boolean validateLoan(User user, Book book);
}
