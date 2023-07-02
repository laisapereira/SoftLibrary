package library.users;

import library.services.Booking;
import library.services.Loan;
import library.users.loan.users.LoanGraduateStudent;

import java.util.ArrayList;


public class GraduateStudent extends User {

    public GraduateStudent(String name, int id) {
        this.typeLoan = new LoanGraduateStudent();
        this.maxBooking = Integer.MAX_VALUE;
        this.maxLoan = 3;
        this.maxTimeLoan = 3;
        this.name = name;
        this.id = id;
        this.amountLoan = new ArrayList<Loan>();
        this.amountBooking = new ArrayList<Booking>();
    }
}




