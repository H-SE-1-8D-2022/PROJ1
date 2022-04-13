package nl.hhs.group8d;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        new Examen("test examen", 2, Arrays.asList(
                new MultipleChoiceVraag("test vraag", "abc", Arrays.asList("abc", "def", "ghi")),
                new MultipleChoiceVraag("test vraag 2", "ghi", Arrays.asList("abc", "def", "ghi")),
                new OpenVraag("test vraag 3", "qwerty")
        ));

        MenuManager menuManager = new MenuManager();
        menuManager.start();
    }

}
