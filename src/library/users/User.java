package library.users;


import library.services.Booking;
import library.services.IValidateLoan;
import library.services.Loan;

import java.util.List;

public class User {

    protected int id;
    protected String name;

    protected IValidateLoan typeLoan;
    protected int maxBooking;
    protected int maxLoan;
    protected int maxTimeLoan;

    protected List<Loan> amountLoan;
    protected List<Booking> amountBooking;

    public User() {

    }



}
