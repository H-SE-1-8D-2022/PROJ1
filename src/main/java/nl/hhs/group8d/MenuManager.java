package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.*;
import nl.hhs.group8d.menuCode.menus.StartMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

    private Scanner scanner = new Scanner(System.in);


    //Arraylist houd de huidige menu opties bij
    private Menu currentMenu;

    //Arraylist die houd alle vorige menuopties bij voor backtracking
    private ArrayList<Menu> listOfPreviousMenus = new ArrayList<>();

    public void start(){
        this.currentMenu = new StartMenu();
        printMenuAndAskInput();
    }

    public void printMenuAndAskInput(){
        printMenu();
        processUserInput(getUserInput());
    }

    private void processUserInput(int userInput){

        //Als de 0: exit menu is gekozen
        if(userInput == 0){
            //Kijken of we in de main menu zitten en zowel gwn weg gaan
            if(listOfPreviousMenus.size() == 0){
                return;
            }

            //De huidige menu options terug zetten naar de vorige menu opties
            currentMenu = listOfPreviousMenus.get(listOfPreviousMenus.size() -1);
            //de vorige menu opties die zijn gecloned verwijderen omdat we ze niet meer nodig hebben
            listOfPreviousMenus.remove(listOfPreviousMenus.size()-1);

            printMenuAndAskInput();
            return;
        }

        //Een array begint met 0, maar de menu opties beginnen met 1, dus we willen de index met 1 verminderen
        userInput-=1;

        //Voer de code uit van de gekozen menu en sla de volgende submenu op in een variable
        currentMenu.getMenuOptions().get(userInput).executeMenuOption();

        Menu nextMenu = currentMenu.getMenuOptions().get(userInput).getNextSubMenu();

        //Als er geen volgende menu opties zijn checken we voor nieuwe input
        if(nextMenu == null){
            printMenuAndAskInput();
            return;
        }

        //het huidige menu opslaan voor backtracking
        listOfPreviousMenus.add(currentMenu);

        //het huidige menu updaten met de nieuwe submenu
        currentMenu = nextMenu;
        printMenuAndAskInput()     ;
    }

    private int getUserInput(){
        boolean noValidAnswer = true;
        while(noValidAnswer) {
            try {
                int answer = scanner.nextInt();

                //See if the answer is inbetween the actual posible answers.
                if (answer > currentMenu.getMenuOptions().size() || answer < 0) {
                    System.out.println("Please enter a valid number.");
                } else {
                    //Return statement haalt ons uit de while loop
                    return answer;
                }
            } catch (InputMismatchException e) {
                //input mismatch exception means they put text in the input but we're looking for ints so the input mismatches the expected outcome.
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
        //Mandatory return statement, actually does nothing
        return 0;
    }

    private void printMenu(){

        //Ga langs elke submenu optie en print de naam
        for(int i = 0; i < currentMenu.getMenuOptions().size(); i++){
            System.out.println(i+1 + ": "+ currentMenu.getMenuOptions().get(i).getTitle());
        }
        System.out.println("0: Exit");
    }
}
