package library.controllers;

import library.Library;

import java.util.List;

public class CmdObserver implements Controller {

    @Override
    public void execute(List<String> args) {
        Library library = Library.getInstance();
        int idUser = Integer.parseInt(args.get(1));
        int idBook = Integer.parseInt(args.get(2));

        library.addObserver(idUser, idBook);
    }
}
