package library;

import library.services.books.Book;
import library.services.users.GraduateStudent;
import library.services.users.PostGraduateStudent;
import library.services.users.Professor;
import library.services.users.User;


import java.util.ArrayList;

public class Mocks {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Mocks() {
        this.books = new ArrayList<Book>();
        this.users = new ArrayList<User>();
    }


    public void setMockBooks() {
        Book b1 = new Book(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile",
                "6ª", "2000", 2);
        books.add(b1);


        Book b2 = new Book(101, "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson",
                "7ª", "2000", 1);
        books.add(b2);


        Book b3 = new Book(200, "Code Complete", "Microsoft Press", "Steve McConnell",
                "2ª", "2014", 1);
        books.add(b3);


        Book b4 = new Book(201, "Agile Software Development, Principles, Patterns", "Prentice Hall", "Robert Martin",
                "1ª", "2002", 1);
        books.add(b4);


        Book b5 = new Book(300, "Refactoring: Improving the Design of Existing Code", "AddisonWesley Professional", "Martin Fowler",
                "1ª", "1999", 2);
        books.add(b5);


        Book b6 = new Book(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman",
                "3ª", "2014", 1);
        books.add(b6);


        Book b7 = new Book(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "AddisonWesley Professional",
                "Erich Gamma, Richard Helm, RalphJohnson, JohnVlissides", "1ª", "1994", 2);
        books.add(b7);


        Book b8 = new Book(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "AddisonWesley Professional",
                "Martin Fowler", "3ª", "2003", 0);
        books.add(b8);


    }

    public void setMockUsers() {
        User professor = new Professor("Carlos Lucena", 100);
        users.add(professor);

        User graduateStudent1 = new GraduateStudent("João da Silva", 123);
        users.add(graduateStudent1);

        User graduateStudent2 = new GraduateStudent("Pedro Paulo", 789);
        users.add(graduateStudent2);

        User postGraduateStudent = new PostGraduateStudent("Luiz Fernando Rodrigues", 456);
        users.add(postGraduateStudent);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }



}
