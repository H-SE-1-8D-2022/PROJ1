package nl.hhs.group8d.vraag;

import java.util.ArrayList;

public class TrueEnFalseVragen extends MultipleChoiceVraag
{
    public TrueEnFalseVragen(String vraag, String correctAntwoord) {
        super(vraag, correctAntwoord, null);

        ArrayList<String> a = new ArrayList<>();
        a.add("True");
        a.add("False");

      super.setOpties(a);
    }

}

