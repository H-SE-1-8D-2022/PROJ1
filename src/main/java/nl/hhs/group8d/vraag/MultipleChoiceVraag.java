package nl.hhs.group8d.vraag;

import java.util.List;

public class MultipleChoiceVraag extends Vraag {
    private List<String> opties;

    public MultipleChoiceVraag(String vraag, String antwoord, List<String> opties) {
        super(vraag, antwoord);
        this.opties = opties;
    }

    @Override
    boolean isCorrect(String antwoordGegeven) {
        return false;
    }
}
