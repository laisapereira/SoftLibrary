package library.services.users;

import library.services.Booking;
import library.services.Loan;
import library.services.users.loan.users.LoanGraduateStudent;

import java.util.ArrayList;


public class GraduateStudent extends User {

    public GraduateStudent(String name, int id) {
        this.typeLoan = new LoanGraduateStudent();
        this.maxBooking = 3;
        this.maxLoan = 3;
        this.maxTimeLoan = 3;
        this.name = name;
        this.id = id;
        this.amountLoan = new ArrayList<Loan>();
        this.amountBooking = new ArrayList<Booking>();
    }
}




