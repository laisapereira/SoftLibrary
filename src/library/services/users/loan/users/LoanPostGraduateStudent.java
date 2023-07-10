package library.services.users.loan.users;

import library.services.books.Book;
import library.services.ILoan;
import library.services.users.User;


public class LoanPostGraduateStudent implements ILoan {

    @Override

    public boolean validateLoan(User user, Book book) {
        if (!user.isDebtor()) {
            if (user.getAmountActiveLoan() < user.getMaxTimeLoan()) {
                if (!user.activeLoanByUser(book)) {
                    if (book.getAmountCopiesAvailableStudent() > book.getAmountBookings()) {
                        return true;
                    } else {
                        if (user.activeLoanByUser(book) || user.activeBookingByUser(book)) {
                            return true;
                        } else {
                            System.out.println("Não foi possível emprestar " + book.getTitle() + " para " + user.getName() + " pois todos os exemplares já estão reservados.");
                            return false;
                        }
                    }
                } else {
                    System.out.println("Não foi possível emprestar o livro " + book.getTitle() + " para " + user.getName() + ", pois este usuário já pegou esse livro emprestado");
                    return false;
                }
            } else {
                System.out.println("Não foi possível emprestar" + book.getTitle() + " para " + user.getName() + " , porque ele execeu o limite de empréstimos.");
                return false;
            }
        } else {
            System.out.println("Não foi possível emprestar " + book.getTitle() + " PARA O: " + user.getName() +
                    " , pois o usuário está em débito.");
            return false;
        }
    }

}




