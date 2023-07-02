package library.users;


import library.books.Book;
import library.services.Booking;
import library.services.ILoan;
import library.services.Loan;

import java.time.LocalDate;
import java.util.List;

public abstract class User {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getMaxLoan() {
        return maxLoan;
    }

    public int getMaxTimeLoan() {
        return maxTimeLoan;
    }


    public int getAmountBooking() {
        return amountBooking.size();
    }

    protected int id;
    protected String name;


    protected int maxBooking;
    protected int maxLoan;
    protected int maxTimeLoan;

    protected List<Loan> amountLoan;
    protected List<Booking> amountBooking;

    protected ILoan typeLoan;


    public boolean isBookedBook(Book book) {
        return false;
    }

    public boolean isDebtor() {
        for (Loan loan : amountLoan) {
            if (!loan.isActive()) {
                if (LocalDate.now().isAfter(loan.getDateEndingLoan())) {
                    return true;
                }
            }
        }

        return false;
    }
    // verificar se o usuário pode pegar um livro emprestado, parametro lvro

    public boolean allowedLoan(Book book) {
        return this.typeLoan.validateLoan(this, book);
    }

    public boolean allowedBooking() {
        if (getAmountBooking() < maxBooking) {
            return true;
        }
        System.out.println("Não foi possível realizar o agendamento, pois o usuário: " + this.getName() + " já possui " + maxBooking + " reservas.");
        return false;

    }

    public void addLoan(Loan loan) {
        amountLoan.add(loan);
    }

    public Loan getLoanByUser(Book book) {
        for (Loan loan : amountLoan) {
            if (loan.isActive() && (loan.getBookCopy().getBook() == book)) {
                return loan;
            }
        }
        return null;
    }

    public void addBooking(Booking booking) {
        amountBooking.add(booking);
    }

    public Booking getActiveBookingByUser(Book book) {
        for (Booking booking : amountBooking) {
            if (booking.isActive() && (booking.getBook() == book)) {
                return booking;
            }
        }
        return null;
    }

    public boolean activeLoanByUser(Book book) {
        for (Loan loan : amountLoan) {
            if (loan.isActive() && (loan.getBookCopy().getBook() == book)) {
                return true;
            }
        }
        return false;
    }

    public int getAmountActiveLoan() {
        int amount = 0;
        for (Loan loan : amountLoan) {
            if (loan.isActive()) {
                amount++;
            }
        }
        return amount;
    }

    public void aboutLoans() {
        System.out.println("Quantidade de emprestimos: " + amountLoan.size());
        System.out.println("Informação sobre os emprestimos:");

        for (Loan loan: amountLoan) {
            String statusMessage = loan.isActive() ? "Aberto" : "Fechado";
            String returnedMessage;
            LocalDate returnedDate = loan.getDateEndingLoan();

            if (returnedDate != null) {
                returnedMessage = " - Data de devolução: " + returnedDate.toString();
            } else
                returnedMessage = " - Data experada para devolução: " + returnedDate.toString();

            System.out.println("Título do livro: " + loan.getBookCopy().getBook().getTitle() +
                    " - Status do emprestimo: " + statusMessage +
                    " - Data do emprestimo: " + loan.getDateStartLoan() + returnedMessage);
        }
    }

    public void aboutBookings() {
        System.out.println("Informação sobre as reservas:");

        if (amountBooking.size() > 0) {
            for(Booking booking: amountBooking) {
                String endingBookingMessage = "";

                if (booking.getDateEndingBooking() != null) {
                    endingBookingMessage = booking.getDateEndingBooking().toString();
                }

                System.out.println("Título do livro: " + booking.getBook().getTitle() +
                        " - Data de solicitação da reserva: " + booking.getDateStartBooking() +
                        " - Data de finalização da reserva: " + endingBookingMessage);
            }
        }
    }


    public String toString() {
        return "Nome: " + this.name +
                " - Quantidade de emprestimos: " + amountLoan.size() +
                " - Quantidade de reservas: " + amountBooking.size()
                ;
    }
}


