package nl.hhs.group8d.ui.menus.examen;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.ui.MenuOption;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import nl.hhs.group8d.vraag.TrueFalseVraag;
import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;

public class MaakExamenMenuOption extends MenuOption {

    private final ArrayList<Vraag> vragen = new ArrayList<>();

    @Override
    public String getTitle() {
        return "Maak een examen.";
    }

    @Override
    public void executeMenuOption() {
        System.out.println("Wat is de naam van de examen?");
        System.out.print("Naam: ");
        String name = getUserStringInput();

        System.out.println("Hoeveel vragen?");
        System.out.print("Aantal: ");
        int aantalVragen = getUserIntInput();
        System.out.println("Hoeveel moeten er correct zijn?");
        System.out.print("Aantal: ");
        int correct = getUserIntInput(0, aantalVragen);

        for (int i = 0; i < aantalVragen; i++) {
            System.out.println("Wat voor vraag is het?");
            System.out.println("1. Meerkeuzevraag");
            System.out.println("2. True/False vraag");
            System.out.println("3. open vraag");
            System.out.println("0. exit.");
            System.out.print("Keuze: ");

            int answer = getUserIntInput(0, 3);

            switch (answer) {
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

    private void createMeerkeuzevraag() {
        ArrayList<String> opties = new ArrayList<>();

        System.out.println("Wat is de naam van de meerkeuze vraag");
        System.out.print("Naam: ");
        String naam = getUserStringInput();
        System.out.println("Wat is het juiste antwoord?");
        System.out.print("Antwoord: ");
        String antwoord = getUserStringInput();

        System.out.println("Hoeveel mogelijke antwoorden? (Maximaal 26)");
        System.out.print("Aantal: ");
        int possiblities = getUserIntInput(1,26);

        for (int i = 0; i < possiblities; i++) {
            System.out.println("Wat is een antwoord optie? (Het juiste antwoord moet ook worden ingezet.)");
            System.out.print("Antwoord: ");
            opties.add(getUserStringInput());
        }

        vragen.add(new MultipleChoiceVraag(naam, antwoord, opties));
    }

    private void createTrueFalseVraag() {
        System.out.println("Wat is de naam van de true / false vraag?");
        System.out.print("Naam: ");
        String naam = getUserStringInput();
        System.out.println("Is het true of false? \n1. True \n2. False");
        System.out.print("Keuze: ");
        int answer = getUserIntInput(1, 2);
        if (answer == 1) {
            vragen.add(new TrueFalseVraag(naam, "True"));
        } else {
            vragen.add(new TrueFalseVraag(naam, "False"));
        }


    }

    private void createOpenVraag() {
        System.out.println("Wat is de naam van de open vraag?");
        System.out.print("Naam: ");
        String naam = getUserStringInput();
        System.out.println("Wat is het juiste antwoord?");
        System.out.print("Antwoord: ");
        String antwoord = getUserStringInput();

        vragen.add(new OpenVraag(naam, antwoord));
    }

}
