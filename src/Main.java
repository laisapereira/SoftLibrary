import library.controllers.MainController;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {

        MainController mainController = new MainController();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String line = scanner.nextLine();
                String[] arguments = line.split(" ");
                List<String> input = Arrays.asList(arguments);

                String toDo = input.get(0);

                mainController.service(input, toDo);
            }
        }
    }

}
