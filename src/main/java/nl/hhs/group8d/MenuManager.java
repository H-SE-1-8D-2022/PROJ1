package nl.hhs.group8d;

import nl.hhs.group8d.ui.Menu;
import nl.hhs.group8d.ui.menus.StartMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

    private final Scanner scanner = new Scanner(System.in);
    //Arraylist die houd alle vorige menuopties bij voor backtracking
    private final ArrayList<Menu> listOfPreviousMenus = new ArrayList<>();
    //Arraylist houd de huidige menu opties bij
    private Menu currentMenu;

    public void start() {
        this.currentMenu = new StartMenu();
        printMenuAndAskInput();
    }

    public void printMenuAndAskInput() {
        boolean repeat = true;

        while (repeat) {
            printMenu();
            repeat = processUserInput(getUserInput());
        }
    }

    private boolean processUserInput(int userInput) {

        //Als de 0: exit menu is gekozen
        if (userInput == 0) {
            //Kijken of we in de main menu zitten en zowel gwn weg gaan
            if (listOfPreviousMenus.isEmpty()) {
                return false;
            }

            //De huidige menu options terug zetten naar de vorige menu opties
            currentMenu = listOfPreviousMenus.get(listOfPreviousMenus.size() - 1);
            //de vorige menu opties die zijn gecloned verwijderen omdat we ze niet meer nodig hebben
            listOfPreviousMenus.remove(listOfPreviousMenus.size() - 1);
            return true;
        }

        //Een array begint met 0, maar de menu opties beginnen met 1, dus we willen de index met 1 verminderen
        userInput -= 1;

        //Voer de code uit van de gekozen menu en sla de volgende submenu op in een variable
        currentMenu.getMenuOptions().get(userInput).executeMenuOption();

        Menu nextMenu = currentMenu.getMenuOptions().get(userInput).getNextSubMenu();

        //Als er geen volgende menu opties zijn checken we voor nieuwe input
        if (nextMenu == null) {
            return true;
        }

        //het huidige menu opslaan voor backtracking
        listOfPreviousMenus.add(currentMenu);

        //het huidige menu updaten met de nieuwe submenu
        currentMenu = nextMenu;

        return true;
    }

    private int getUserInput() {
        boolean noValidAnswer = true;
        int answer = -1;

        while (noValidAnswer) {
            try {
                answer = scanner.nextInt();

                //See if the answer is inbetween the actual posible answers.
                if (answer > currentMenu.getMenuOptions().size() || answer < 0) {
                    System.out.println("Please enter a valid number.");
                } else {
                    // Stop de loop
                    noValidAnswer = false;
                }
            } catch (InputMismatchException e) {
                //input mismatch exception means they put text in the input but we're looking for ints so the input mismatches the expected outcome.
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        // Return de waarde
        return answer;
    }

    private void printMenu() {

        //Ga langs elke submenu optie en print de naam
        for (int i = 0; i < currentMenu.getMenuOptions().size(); i++) {
            System.out.println(i + 1 + ": " + currentMenu.getMenuOptions().get(i).getTitle());
        }
        System.out.println("0: Exit");
    }
}
