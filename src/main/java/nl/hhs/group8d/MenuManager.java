package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.*;
import nl.hhs.group8d.menuCode.menus.ExamenMenuOption;
import nl.hhs.group8d.menuCode.menus.StudentMenuOption;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

    private Scanner scanner = new Scanner(System.in);


    //Arraylist houd de huidige menu opties bij
    private Submenu menuOptions;

    //Arraylist die houd alle vorige menuopties bij voor backtracking
    private ArrayList<Submenu> previousMenu = new ArrayList<>();

    public void start(){

        this.menuOptions = getDefaultMenuOptions();
        print();

    }

    public void print(){
        printMenu();
        processUserInput(getUserInput());

    }

    public void reCheckUserInput(){
        printMenu();
        processUserInput(getUserInput());
    }

    private void processUserInput(int index){

        //Als de 0: exit menu is gekozen
        if(index == 0){
            //Kijken of we in de main menu zitten en zowel gwn weg gaan
            if(previousMenu.size() == 0){
                return;
            }

            //De huidige menu options terug zetten naar de vorige menu opties
            menuOptions = previousMenu.get(previousMenu.size() -1);
            //de vorige menu opties die zijn gecloned verwijderen omdat we ze niet meer nodig hebben
            previousMenu.remove(previousMenu.size()-1);

            print();
            return;
        }

        //Een array begint met 0, maar de menu opties beginnen met 1, dus we willen de index met 1 verminderen
        index--;

        //Voer de code uit van de gekozen menu en sla de volgende submenu op in een variable
        menuOptions.getMenuOptions().get(index).executeMenuOption();
        var newMenuOptions = menuOptions.getMenuOptions().get(index).getNextSubMenu();

        //Als er geen volgende menu opties zijn checken we voor nieuwe input
        if(newMenuOptions == null){
            reCheckUserInput();
            return;
        }

        //het huidige menu opslaan voor backtracking
        previousMenu.add(menuOptions);

        //het huidige menu updaten met de nieuwe submenu
        menuOptions = newMenuOptions;
        print()     ;
    }

    private int getUserInput(){

        boolean noValidAnswer = true;
        while(noValidAnswer) {
            try {
                int answer = scanner.nextInt();

                //See if the answer is inbetween the actual posible answers.
                if (answer > menuOptions.getMenuOptions().size() || answer < 0) {
                    System.out.println("Please enter a valid number.");
                } else {
                    //Return statement haalt ons uit de while loop
                    return answer;
                }
            } catch (InputMismatchException e) {
                //input mismatch exception means they put text in the input but we're looking for ints so the input mismatches the expected outcome.
                System.out.println("Please enter a valid number.");
            }
        }

        //Mandatory return statement, actually does nothing
        return 0;
    }

    private void printMenu(){

        //Ga langs elke submenu optie en print de naam
        for(int i = 0; i < menuOptions.getMenuOptions().size(); i++){
            System.out.println(i+1 + ": "+menuOptions.getMenuOptions().get(i).getTitle());
        }
        System.out.println("0: Exit");
    }

    private Submenu getDefaultMenuOptions(){

        //Dit is het startmenu
        ArrayList<iMenuOption> menuOptions = new ArrayList<>();
        menuOptions.add(new StudentMenuOption());
        menuOptions.add(new ExamenMenuOption());

        Submenu submenu = new Submenu();
        submenu.setMenuOptions(menuOptions);

        return submenu;
    }
}
