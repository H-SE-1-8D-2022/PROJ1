package nl.hhs.group8d.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuOption {

    private final Scanner scanner = new Scanner(System.in);

    public abstract String getTitle();

    public abstract void executeMenuOption();

    public Menu getNextSubMenu() {
        return null;
    }

    protected Scanner getScanner() {
        return this.scanner;
    }

    protected int getUserIntInput() {
        return getUserIntInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    protected int getUserIntInput(int min, int max) {
        boolean noValidInput = true;
        int input = -1;

        while (noValidInput) {
            try {
                input = scanner.nextInt();

                if (input >= min && input <= max) {
                    noValidInput = false;
                } else {
                    System.out.println("Vul alstublieft een geldig getal in.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vul alstublieft een geldig getal in.");
                scanner.nextLine();
            }
        }

        return input;
    }

    protected String getUserStringInput() {
        String text = getScanner().nextLine();

        while (text.equals("")) {
            text = getScanner().nextLine();
        }

        return text;
    }

}
