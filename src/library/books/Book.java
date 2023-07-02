package library.books;

import library.services.Booking;

import java.util.ArrayList;

public class Book {

    private int id;
    private String title;
    private String publishers;
    private String authors;
    private String edition;
    private String yearPublication;

    private int amountCopies;

    ArrayList<BookCopy> bookCopies;
    ArrayList <Booking> bookings;


    public Book(int id, String title, String publishers, String authors, String edition, String yearPublication, int amountCopies) {
        this.id = id;
        this.title = title;
        this.publishers = publishers;
        this.authors = authors;
        this.edition = edition;
        this.yearPublication = yearPublication;

        for (int i = 0; i < amountCopies; i++) {
            BookCopy bookCopy = new BookCopy(i, this);
            bookCopies.add(bookCopy);
        }

        this.bookings = new ArrayList<Booking>();
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
                if (bookCopy.isAvailable()) {
                bookCopiesAvaliable.add(bookCopy);
            }
        }

            return bookCopiesAvaliable;
    }


   public ArrayList<BookCopy> getBookCopiesUnavaliable() {

        ArrayList<BookCopy> bookCopiesUnavaliable = new ArrayList<BookCopy>();

        for (BookCopy bookCopy : bookCopies) {
            if (!bookCopy.isAvailable()) {
                bookCopiesUnavaliable.add(bookCopy);
            }
        }
        return bookCopiesUnavaliable;
    }

    public void addBooking(Booking bookingBook) {
        bookings.add(bookingBook);

        // notificar pela quantidade de reserva
    }

    public int getAmountBookings() {
        return bookings.size();
    }

    public boolean isAvailable() {
        return getBookCopiesAvaliable().size() > 0;
    }

















}








