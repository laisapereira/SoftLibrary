package library;

import library.books.Book;
import library.books.BookCopy;
import library.services.Booking;
import library.services.Loan;
import library.users.User;


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
        this.books = new ArrayList<Book>();

        Mocks mocks = new Mocks();
        mocks.setMockBooks();
        mocks.setMockUsers();

        books.addAll(mocks.getBooks());
        users.addAll(mocks.getUsers());
    }

    // sobre os usuários

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void aboutUser(int userId) {
        User user = getUserById(userId);
        System.out.println(user.toString());
        user.aboutBookings();
        user.aboutLoans();
    }

    // sobre os livros


    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void aboutBook(int bookId) {
        Book book = getBookById(bookId);
        System.out.println(book.toString());
        book.aboutAvailability();
        book.aboutLoan();
    }

    // ações usuário-livro

    public void Booking(int userId, int bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        if (user.allowedBooking()) {
            Booking booking = new Booking(user, book);
            user.addBooking(booking);
            book.addBooking(booking);
            System.out.println("Reserva realizada de " + book.getTitle() + "para" + user.getName());

        }


    }

    public void Loan(int userId, int bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        if (user.allowedLoan(book)) {
            if (book.isAvailable()) {
                Loan loan = user.getLoanByUser(book);
                if (loan != null) {
                    loan.cancelLoan();
                }
            }
            BookCopy bookCopy = book.getBookCopyLoanable();
            Loan loan = new Loan(user, bookCopy);
            bookCopy.setLoan(loan);
            user.addLoan(loan);
            System.out.println("Empréstimo realizado de " + book.getTitle() + "para" + user.getName());


            System.out.println("Empréstimo realizado de " + book.getTitle() + "para" + user.getName());

        }
    }


    public void returnBook(int userId, int bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        Loan loan = user.getLoanByUser(book);

        loan.cancelLoan();
        System.out.println("Livro " + book.getTitle() + "devolvido com sucesso de" + user.getName());


    }


    // add observador

}
