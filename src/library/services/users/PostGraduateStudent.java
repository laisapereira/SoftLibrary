package library.services.users;

import library.services.Booking;
import library.services.Loan;
import library.services.users.loan.users.LoanPostGraduateStudent;

import java.util.ArrayList;

public class PostGraduateStudent extends User {

    public PostGraduateStudent(String name, int id) {
        this.typeLoan = new LoanPostGraduateStudent();
        this.maxBooking = Integer.MAX_VALUE;
        this.maxLoan = 4;
        this.maxTimeLoan = 4;
        this.name = name;
        this.id = id;
        this.amountLoan = new ArrayList<Loan>();
        this.amountBooking = new ArrayList<Booking>();
    }
}
