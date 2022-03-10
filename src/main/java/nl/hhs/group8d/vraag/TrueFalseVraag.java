package nl.hhs.group8d.vraag;

import java.util.ArrayList;
import java.util.List;

public class TrueFalseVraag extends MultipleChoiceVraag {
    public TrueFalseVraag(String vraag, String antwoord) {
        super(vraag, antwoord, List.of("waar", "false"));
    }
}
