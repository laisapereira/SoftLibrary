package library;

import library.users.User;

import java.util.ArrayList;

public class Library {

    private static Library instance;


    private Library() {

        this.users = new ArrayList<User>();
    }
}
