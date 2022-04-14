package nl.hhs.group8d.vraag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoiceVraag extends Vraag {
    private final List<String> alfabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    private List<String> opties;

    public MultipleChoiceVraag(String vraag, String correctAntwoord, List<String> opties) {
        super(vraag, correctAntwoord);
        this.opties = opties;
    }

    public void setOpties(ArrayList<String> opties) {
        this.opties = opties;
    }

    @Override
    public void printVraag() {
        System.out.println(super.getVraag());
        for (int i = 0; i < opties.size(); i++) {
            System.out.println(alfabet.get(i).toUpperCase() + ")- " + opties.get(i));
        }
        System.out.print("Antwoord: ");
    }

    @Override
    public boolean isCorrect(String antwoord) {
        int index = alfabet.indexOf(antwoord.toLowerCase());
        if (index < 0 || index >= opties.size()) {
            // Geen valide antwoord
            return false;
        }

        return getCorrecteAntwoord().equals(opties.get(index));
    }
}
