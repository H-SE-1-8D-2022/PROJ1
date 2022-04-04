package nl.hhs.group8d.vraag;

import java.util.ArrayList;

public class MultipleChoiceVraag extends Vraag
{
    private ArrayList<String> opties;

   public MultipleChoiceVraag(String vraag, String correctAntwoord,ArrayList<String> opties)
   {
       super(vraag,correctAntwoord);
       this.opties = opties;
   }

    @Override
    public void printVraag() {
        System.out.println(super.getVraag());
    }

    @Override
    public boolean isCorrect(String antwoord)
    {
        return false;
    }
}
