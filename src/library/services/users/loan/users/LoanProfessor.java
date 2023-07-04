package library.services.users.loan.users;


import library.services.books.Book;
import library.services.ILoan;
import library.services.users.User;


public class LoanProfessor implements ILoan {

    public boolean validateLoan(User user, Book book) {

        if (!book.isAvailable()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois não há exemplares disponíveis.");
            return false;
        }

        if (user.isDebtor()) {
            System.out.println("Não foi possível realizar o empréstimo do livro: " + book.getTitle() +
                    " para o usuário: " + user.getName() + ", pois o usuário está em débito.");
            return false;
        }


        return true;

    }

}
