package nl.hhs.group8d;

import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class testVanIsCorrect {
    @Test
    public void isCorrect()
    {
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
