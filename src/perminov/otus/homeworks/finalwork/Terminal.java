package perminov.otus.homeworks.finalwork;

import java.util.Scanner;

public class Terminal implements ReadConsole {
    @Override
    public Integer readConsole() {
        Integer number = null;
        try (Scanner scanner = new Scanner(System.in)) {
            number = scanner.nextInt();
        } catch (NullPointerException e){System.out.println(e.getMessage());}
        return number;
    }
}
