package library;

import library.users.User;

import java.awt.print.Book;
import java.util.ArrayList;

public class Library {

    private static Library instance;

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    private Library() {

        this.users = new ArrayList<User>();
    }
}
