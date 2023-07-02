package library.users;

import library.services.Booking;
import library.services.Loan;
import library.users.loan.users.LoanProfessor;

import java.util.ArrayList;

public class Professor extends User {

    public Professor(String name, int id) {
        this.typeLoan = new LoanProfessor();
        this.maxBooking = Integer.MAX_VALUE;
        this.maxLoan = Integer.MAX_VALUE;
        this.maxTimeLoan = 7;
        this.name = name;
        this.id = id;
        this.amountLoan = new ArrayList<Loan>();
        this.amountBooking = new ArrayList<Booking>();
    }
}
