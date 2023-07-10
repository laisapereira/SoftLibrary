package library;

import library.services.books.Book;
import library.services.books.BookCopy;
import library.controllers.observers.IObserver;
import library.services.Booking;
import library.services.Loan;

import library.services.users.User;


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

    public User getUserById(int id){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void aboutUser(int userId){
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

    public void aboutBook(int bookId){
        Book book = getBookById(bookId);
        System.out.println(book.toString());
        book.aboutAvailability();
        book.aboutBooking();
        book.aboutLoan();
    }

    // ações usuário-livro

    public void Booking(int userId, int bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);


        if (user.allowedBooking()) {
            if (book.getAmountCopiesAvailableStudent() > 0) {
                Booking booking = new Booking(user, book);
                user.addBooking(booking);

                System.out.println("Reserva realizada de " + book.getTitle() + "  para  " + user.getName());
            } else {
                System.out.println("Reserva não realizada de " + book.getTitle() + "  para  " + user.getName()
                        + " pois as cópias já estão todas reservadas.");
            }
        }

    }

    public void Loan(int userId, int bookId){
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        if (user.allowedLoan(book)) {
            if (book.isAvailable()) {
                Booking booking = user.getActiveBookingByUser(book);
                if (booking != null || (book.getActiveBookings() != null && !user.activeBookingByUser(book))) {
                    assert booking != null;
                    booking.cancelBooking();
                }
            }
        }
        BookCopy bookCopy = book.getBookCopyLoanable();
        Loan loan = new Loan(user, bookCopy);
        bookCopy.setLoan(loan);
        user.addLoan(loan);
        System.out.println("Empréstimo realizado de " + book.getTitle() + " para " + user.getName());

    }


    public void returnBook(int userId, int bookId){
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        Loan loan = user.getLoanByUser(book);

        if (loan != null) {
            loan.cancelLoan();
            System.out.println("Livro " + book.getTitle() + " devolvido com sucesso de " + user.getName());
        } else {
            System.out.println("Livro " + book.getTitle() + " não foi devolvido de " + user.getName() +
                    " pois não há empréstimo ativo.");
        }
    }

    // interacao classe observador

    public void addObserver(int userId, int bookId){
        getBookById(bookId).addObserver((IObserver) getUserById(userId));

        System.out.println("Uma notificação será enviada para o usuário de id: " + userId);
    }

    public void nftObserver(int userId){
        IObserver observer = (IObserver) getUserById(userId);
        System.out.println("Número de vezes que o usuario de id " + userId + " foi notificado: "
                + observer.sumNotifications());
    }


}
