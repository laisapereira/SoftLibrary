package library.services.users;

import library.controllers.observers.IObserver;
import library.services.Booking;
import library.services.Loan;
import library.services.users.loan.users.LoanProfessor;

import java.util.ArrayList;

public class Professor extends User implements IObserver {
    private int contador;

    public Professor(String name, int id) {
        this.typeLoan = new LoanProfessor();
        this.maxBooking = 3;
        this.maxLoan = Integer.MAX_VALUE;
        this.maxTimeLoan = 7;
        this.name = name;
        this.id = id;
        this.amountLoan = new ArrayList<Loan>();
        this.amountBooking = new ArrayList<Booking>();
    }

    @Override
    public void update() {
        contador = contador + 1;
        System.out.println("Há uma reserva simultânea para esse livro");

    }

    @Override
    public int sumNotifications() {
        return contador;
    }
}
