package nl.hhs.group8d.vraag;

public class OpenVraag extends Vraag {
    public OpenVraag(String vraag, String antwoord) {
        super(vraag, antwoord);
    }

    @Override
    boolean isCorrect(String antwoordGegeven) {
        return false;
    }
}
