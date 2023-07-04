package library.services.books;

import library.controllers.observers.Notify;
import library.controllers.observers.IObserver;
import library.services.Booking;
import library.services.Loan;
import library.services.users.User;


import java.util.ArrayList;
import java.util.List;

public class Book implements Notify {

    private int id;
    private String title;
    private String publishers;
    private String authors;
    private String edition;
    private String yearPublication;

    private User user;


    private List<IObserver> notifyList;

    ArrayList<BookCopy> bookCopies;
    ArrayList<Booking> bookings;


    public Book(int id, String title, String publishers, String authors, String edition, String yearPublication,
                int amountCopies) {
        this.id = id;
        this.title = title;
        this.publishers = publishers;
        this.authors = authors;
        this.edition = edition;
        this.yearPublication = yearPublication;

        this.bookings = new ArrayList<>();
        this.notifyList = new ArrayList<IObserver>();
        this.bookCopies = new ArrayList<BookCopy>();

        for (int i = 0; i < amountCopies; i++) {
            BookCopy bookCopy = new BookCopy(i, this);
            this.bookCopies.add(bookCopy);
        }

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public ArrayList<BookCopy> getBookCopiesAvaliable() {

        ArrayList<BookCopy> bookCopiesAvaliable = new ArrayList<BookCopy>();

        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getLoan() == null ) {
                bookCopiesAvaliable.add(bookCopy);
            } else if (!bookCopy.getLoan().isActive()) {
                bookCopiesAvaliable.add(bookCopy);
            }
        }

        return bookCopiesAvaliable;
    }


    public ArrayList<BookCopy> getBookCopiesUnavailable() {
        ArrayList<BookCopy> bookCopiesUnavaliable = new ArrayList<BookCopy>();

        for (BookCopy bookCopy : bookCopies) {
            if (bookCopy.getLoan() != null ) {
                if (bookCopy.getLoan().isActive()) {
                    bookCopiesUnavaliable.add(bookCopy);
                }
            }
        }
        return bookCopiesUnavaliable;
    }

    public void addBooking(Booking bookingBook) {
        bookings.add(bookingBook);

        if (getActiveBookings().size() > 1) {
            notifyObserver(this);
        }
    }

    public int getAmountBookings() {
        return bookings.size();
    }

    public boolean isAvailable() {
        return getAmountCopiesAvailable() > 0;
    }


    public int getAmountCopiesAvailable() {

        return getBookCopiesAvaliable().size();
    }

    // para o usuário

    public int getAmountCopiesToUser() {
        return bookCopies.size() - getBookCopiesUnavailable().size() - bookings.size();
    }


    public BookCopy getBookCopyLoanable() {
        return getBookCopiesAvaliable().get(0);
    }

    public ArrayList<Booking> getActiveBookings() {
        ArrayList<Booking> activeBookings = new ArrayList<Booking>();

        for (Booking booking : bookings) {
            if (booking.isActive()) {
                activeBookings.add(booking);
            }
        }
        return activeBookings;
    }

    public void aboutBooking() {
        int amountActiveBookings = getActiveBookings().size();

        System.out.println("Título do livro: " + this.getTitle());
        System.out.println("Quantidade de reservas: " + amountActiveBookings);

        if (amountActiveBookings > 0) {
            for (Booking booking : this.getActiveBookings()) {
                System.out.println("Reserva realizada com sucesso por: " + booking.getUser().getName());

            }
        }
    }

    public void aboutAvailability() {
        System.out.println("Cópias disponíveis (número): " + this.getAmountCopiesToUser());
    }

    public void aboutLoan() {
        System.out.println("Empréstimos realizados: " + this.getBookCopiesUnavailable().size());
        for (BookCopy bookCopy : this.getBookCopiesUnavailable()) {
            Loan loan = bookCopy.getLoan();
            User userLoan = loan.getUser();
            System.out.println(bookCopy.getId() + " Para: " + userLoan.getName() +
                    "\n Data do empréstimo: " + loan.getDateStartLoan() + "\n Data esperada para devolução: " +
                    loan.dateExpectedReturn());
        }
    }

    @Override
    public String toString() {
        return "Informações sobre o Livro pedido: " +
                "\n  ID: " + id +
                "\n  Título: '" + title + '\'' +
                "\n  Editora: '" + publishers + '\'' +
                "\n  Autores: '" + authors + '\'' +
                "\n  Edição: '" + edition + '\'' +
                "\n  Ano de Publicação: '" + yearPublication + '\'' +
                "\n  Cópias do Livro: " + bookCopies.size()
                ;
    }


    @Override
    public void notifyObserver(Book book) {
        notifyList.forEach(observer -> observer.update());
    }

    @Override
    public void addObserver(IObserver observer) {
        notifyList.add(observer);
    }
}












