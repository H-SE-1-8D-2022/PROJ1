package nl.hhs.group8d.vraag;

public abstract class Vraag {
    private String vraag;
    private String antwoord;

    protected Vraag(String vraag, String antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    abstract boolean isCorrect(String antwoordGegeven);
}
