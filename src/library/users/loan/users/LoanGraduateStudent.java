package library.users.loan.users;

import library.books.Book;
import library.services.ILoan;
import library.users.User;


public class LoanGraduateStudent implements ILoan {
    @Override
    public boolean validateLoan(User user, Book book) {
        if (book.isAvailable()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois não há exemplares disponíveis.");
            return false;
        }

        if (user.isDebtor()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois o usuário está em débito.");
            return false;
        }

        if (user.getAmountActiveLoan() >= user.getMaxLoan()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois o usuário atingiu o limite máximo de empréstimos.");
            return false;
        }

        if (book.getBookCopiesAvaliable().size() < book.getAmountBookings()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois todas as cópias disponíveis estão reservadas.");
            return false;
        }

        if (user.activeLoanByUser(book)) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois o usuário já possui um empréstimo em andamento do mesmo livro.");
            return false;

        }


        return true;
    }
}






