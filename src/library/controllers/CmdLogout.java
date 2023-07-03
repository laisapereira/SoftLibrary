package library.controllers;

import library.Library;

import java.util.List;

public class CmdLogout implements Controller {
    @Override
    public void execute(List<String> args) {
        System.exit(0);
    }
}
