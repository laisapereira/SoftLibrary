package library.controllers;

import library.Library;

import java.util.List;

public class CmdUser implements Controller {
    @Override
    public void execute(List<String> args) {
        Library library = Library.getInstance();
        int idUser = Integer.parseInt(args.get(1));

        library.aboutUser(idUser);
    }
}
