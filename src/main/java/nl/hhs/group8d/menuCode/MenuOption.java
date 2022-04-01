package nl.hhs.group8d.menuCode;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuOption {

    private final Scanner scanner = new Scanner(System.in);

    public abstract String getTitle();

    public Menu getNextSubMenu() {
        return null;
    }

    public void executeMenuOption() {
        //todo: override
    }

    protected Scanner getScanner(){
        return this.scanner;
    }

    protected int getUserIntInput(){
        return getUserIntInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    protected int getUserIntInput(int min, int max){
        boolean noValidInput = true;
        while (noValidInput) {
            try {
                int input = scanner.nextInt();

                if(input >= min && input < max){
                    return input;
                } else {
                    System.out.println("Vul alstublieft een geldig getal in.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vul alstublieft een geldig getal in.");
                scanner.nextLine();
            }
        }

        return 0;
    }

    protected String getUserStringInput(){
        String text = getScanner().nextLine();

        if(text.equals("")){
            return getScanner().nextLine();
        } else {
            return text;
        }
    }

}
