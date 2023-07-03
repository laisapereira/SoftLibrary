package library.services;

import library.services.books.Book;
import library.services.users.User;



public interface ILoan {
    public boolean validateLoan(User user, Book book);
}
