package nl.hhs.group8d.vraag;

import java.util.Locale;

public class OpenVraag extends Vraag {


    public OpenVraag(String vraag, String correcteAntwoord) {
        super(vraag, correcteAntwoord);
    }


    @Override
    public void printVraag() {
        System.out.println(super.getVraag());
    }

    @Override
    public boolean isCorrect(String antwoord) {
        return antwoord.toLowerCase(Locale.ROOT).equals(getCorrecteAntwoord().toLowerCase(Locale.ROOT));
    }
}
