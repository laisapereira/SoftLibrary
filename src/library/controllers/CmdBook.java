package library.controllers;

import library.Library;

import java.util.List;

public class CmdBook implements Controller {
    @Override
    public void execute(List<String> args) {
        Library library = Library.getInstance();
        int idBook = Integer.parseInt(args.get(1));

        library.aboutBook(idBook);
    }
}
