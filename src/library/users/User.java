package library.users;


import library.services.Booking;
import library.services.IValidateLoan;
import library.services.Loan;

import java.util.List;

public class User {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IValidateLoan getTypeLoan() {
        return typeLoan;
    }

    public int getMaxBooking() {
        return maxBooking;
    }

    public int getMaxLoan() {
        return maxLoan;
    }

    public int getMaxTimeLoan() {
        return maxTimeLoan;
    }

    public List<Loan> getAmountLoan() {
        return amountLoan;
    }

    public List<Booking> getAmountBooking() {
        return amountBooking;
    }

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
