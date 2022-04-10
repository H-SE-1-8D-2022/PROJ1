package nl.hhs.group8d.vraag;

public class OpenVraag extends Vraag
{


    public OpenVraag(String vraag, String correcteAntwoord)
    {
        super(vraag, correcteAntwoord);
    }


    @Override
    public void printVraag()
    {
        System.out.println(super.getVraag());
    }

    @Override
    public boolean isCorrect(String antwoord)
    {
        return antwoord.equals(getCorrecteAntwoord());
    }
}
