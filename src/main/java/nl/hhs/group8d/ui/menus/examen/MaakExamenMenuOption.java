package nl.hhs.group8d.ui.menus.examen;

import nl.hhs.group8d.ui.MenuOption;
import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import nl.hhs.group8d.vraag.TrueFalseVraag;
import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;

public class MaakExamenMenuOption extends MenuOption {

    private ArrayList<Vraag> vragen = new ArrayList<>();

    @Override
    public String getTitle() {
        return "Maak een examen.";
    }

    @Override
    public void executeMenuOption() {
        System.out.println("Wat is de naam van de examen?");
        String name = getUserStringInput();

        System.out.println("Hoeveel vragen?");
        int aantalVragen = getUserIntInput();
        System.out.println("Hoeveel moeten er correct zijn?");
        int correct = getUserIntInput(0, aantalVragen);

        for(int i = 0; i < aantalVragen; i++){
            System.out.println("Wat voor vraag is het?");
            System.out.println("1. Meerkeuzevraag");
            System.out.println("2. True/False vraag");
            System.out.println("3. open vraag");
            System.out.println("0. exit.");

             int answer = getUserIntInput(0, 3);

            switch(answer){
                case 0: {
                    System.out.println("Examen aanmaken geannuleerd. \n0. exit");
                    getUserStringInput();
                    return;
                }
                case 1: {
                    createMeerkeuzevraag();
                    break;
                }
                case 2: {
                    createTrueFalseVraag();
                    break;
                }
                case 3: {
                    createOpenVraag();
                    break;
                }
            }
        }

        new Examen(name, correct, vragen);
        System.out.println("Examen is aangemaakt! \n0. exit");
        getUserStringInput();

    }

    private void createMeerkeuzevraag(){
        ArrayList<String> opties = new ArrayList<>();

        System.out.println("Wat is de naam van de meerkeuze vraag");
        String naam = getUserStringInput();
        System.out.println("Wat is het juiste antwoord?");
        String antwoord = getUserStringInput();

        System.out.println("Hoeveel mogelijke antwoorden?");
        int possiblities = getUserIntInput();

        for(int i = 0; i < possiblities; i++){
            System.out.println("Wat is een optie?");
            opties.add(getUserStringInput());
        }

        vragen.add(new MultipleChoiceVraag(naam, antwoord, opties));
    }

    private void createTrueFalseVraag(){
        System.out.println("Wat is de naam van de true / false vraag?");
        String naam = getUserStringInput();
        System.out.println("Is het true of false? \n1. True \n2. False");
        int answer = getUserIntInput(1,2);
        if(answer == 1){
            vragen.add(new TrueFalseVraag(naam, "True"));
        } else {
            vragen.add(new TrueFalseVraag(naam, "False"));
        }


    }

    private void createOpenVraag(){
        System.out.println("Wat is de naam van de open vraag?");
        String naam = getUserStringInput();
        System.out.println("Wat is het juiste antwoord?");
        String antwoord = getUserStringInput();

        vragen.add(new OpenVraag(naam, antwoord));
    }

}
