package nl.hhs.group8d.vraag;

public abstract class Vraag
{

    private String vraag;
    private String correcteAntwoord;

    public Vraag(String vraag, String correcteAntwoord)
    {
        this.vraag = vraag;
        this.correcteAntwoord = correcteAntwoord;
    }


    public String getVraag()
    {
        return this.vraag;
    }
    public String getCorrecteAntwoord() {
        return this.correcteAntwoord;
    }

    public abstract void printVraag();
    public abstract boolean isCorrect(String antwoord);
}
