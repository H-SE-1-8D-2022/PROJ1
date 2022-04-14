package nl.hhs.group8d;

import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestVanIsCorrect {
    @Test
    /**
     * de variable 'index' in isCorrect representeert het antwoord van de student 'A t/m Z' en
     * in de if statement wordt er gekeken of het antwoord minder dan 0 is 'dus valt niet in de list alfabet'
     * en of het antwoord niet bestaat in de gegeven opties
     * als dat het geval is wordt de student gevraagd om een geldig antwoord in te voeren
     */
    public void isCorrect() {
        ArrayList<String> opties = new ArrayList<>();
        opties.add("Drie");
        opties.add("twee");
        opties.add("Acht");
        MultipleChoiceVraag m1 = new MultipleChoiceVraag("Hoeveel hoeken heeft een kubus?", "Acht", opties);
        m1.printVraag();
        String antwoord = "C";
        assertTrue(m1.isCorrect(antwoord));
    }
}
