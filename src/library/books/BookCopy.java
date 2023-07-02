package library.books;

import library.services.Loan;

public class BookCopy {

    private int id;
    private Book book;


    private boolean available = true;

    /* private Loan loan;*/
    public BookCopy(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    /*   public Loan getLoan() {
           return loan;
       }

       public void setLoan(Loan loan) {
           this.loan = loan;
       }
   */
    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
