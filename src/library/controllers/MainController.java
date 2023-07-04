package library.controllers;

import java.util.HashMap;
import java.util.List;

public class MainController {

    public HashMap<String, Controller> commands = new HashMap<>();

    public MainController() {
        this.start();
    }

    public void start() {


        commands.put("obs", new CmdObserver());
        commands.put("nft", new CmdNft());
        commands.put("emp", new CmdLoan());
        commands.put("dev", new CmdReturn());
        commands.put("sai", new CmdLogout());
        commands.put("usu", new CmdUser());
        commands.put("res", new CmdBooking());
        commands.put("liv", new CmdBook());
    }

    public void service(List<String> input, String toDo) {
        Controller command = commands.get(toDo);
        if (command != null) {
            command.execute(input);
        } else {
            System.out.println("Comando não encontrado: " + toDo);
        }
    }
}
