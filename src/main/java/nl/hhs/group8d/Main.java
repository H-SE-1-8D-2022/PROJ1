package nl.hhs.group8d;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import nl.hhs.group8d.vraag.TrueFalseVraag;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Deze eerste 3 vragen worden gemaakt omdat we geen database hebben om de examens op te slaan.
        //Wel kan je in de app zelf nieuwe examens aanmaken, maar door gebrek aan database
        //slaan we deze nieuwe gemaakte examens niet op.
        new Examen("Wiskunde Examen", 4, Arrays.asList(
                new MultipleChoiceVraag("3 + 3 =", "6", Arrays.asList("3", "6", "12", "18")),
                new MultipleChoiceVraag("9 * 12 =", "108", Arrays.asList("121", "96", "120", "108","104")),
                new OpenVraag("12 + 12 = ", "24"),
                new TrueFalseVraag("7 * 7 = 56", "False"),
                new TrueFalseVraag("3 * 3 = 9", "True"),
                new MultipleChoiceVraag("7^3 =","343", Arrays.asList("251","343","421","21","49","72")),
                new OpenVraag("sqrt(25) = ", "5")
        ));

        new Examen("Engels Examen", 3, Arrays.asList(
                new MultipleChoiceVraag("Vertaal het volgende woord: 'Hond'", "Dog", Arrays.asList("Dog", "Shepherd", "Cow", "Cat")),
                new MultipleChoiceVraag("Vertaal het volgende woord: 'Koffie'", "Coffee", Arrays.asList("Coffee", "Addiction", "Drug","Cappuchino", "Whisky")),
                new OpenVraag("Vertaal het volgende woord: 'Stinkdier'", "skunk"),
                new TrueFalseVraag("'Children' in het nederlands vertaald is 'Kleinkinderen'", "False")
        ));

        new Examen("Scheikunde Examen", 2, Arrays.asList(
                new MultipleChoiceVraag("Welke PH waardes zijn basisch?", "Van 7 tot 14", Arrays.asList("Van 1 tot 7", "Van 7 tot 14", "van 0 tot 14","Van 4 tot 12")),
                new MultipleChoiceVraag("Wat is het element van Stikstof?", "N", Arrays.asList("St", "S", "N","H","O","Staat er niet tussen.")),
                new MultipleChoiceVraag("Wat is de moleculaire formule van Zout?","NaCl", Arrays.asList("NaCl","NaCl","Z","Bestaat niet.","Cl", "NaB","AhCl")),
                new OpenVraag("Wat is de moleculaire formule van water?", "H2O")
        ));


        MenuManager menuManager = new MenuManager();
        menuManager.start();
    }

}
