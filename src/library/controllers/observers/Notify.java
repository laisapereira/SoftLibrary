package library.controllers.observers;

import library.services.books.Book;

public interface Notify {


    public void notifyObserver(Book book);

    public void addObserver(IObserver observer);


}

