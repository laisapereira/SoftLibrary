package library.controllers.observers;

import library.services.books.Book;

public interface Notify {


    void notifyObserver(Book book);

    void addObserver(IObserver observer);


}

