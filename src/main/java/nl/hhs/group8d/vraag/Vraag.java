package nl.hhs.group8d.vraag;

public class Vraag {

    private String vraag;
    private String correcteAntwoord;

    public Vraag(String vraag, String correcteAntwoord) {
        this.vraag = vraag;
        this.correcteAntwoord = correcteAntwoord;
    }

    public String getVraag() {
        return vraag;
    }

    public String getCorrecteAntwoord() {
        return correcteAntwoord;
    }
}
