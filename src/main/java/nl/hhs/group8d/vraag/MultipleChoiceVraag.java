package nl.hhs.group8d.vraag;

import java.util.ArrayList;

public class MultipleChoiceVraag extends Vraag
{
    private ArrayList<String> opties;
    private final String[] alfabet = new String[]{"a","b","c","d","e","f","g","h","i"};

   public MultipleChoiceVraag(String vraag, String correctAntwoord,ArrayList<String> opties)
   {
       super(vraag,correctAntwoord);
       this.opties = opties;
   }

    public ArrayList<String> getOpties()
    {
        return this.opties;
    }

    public void setOpties(ArrayList<String> opties) {
        this.opties = opties;
    }

    @Override
    public void printVraag()
    {
        System.out.println(super.getVraag());
        for (int i =0;i<opties.size();i++){
            System.out.println(alfabet[i].toUpperCase() +")- " + opties.get(i));
        }
    }

    @Override
    public boolean isCorrect(String antwoord)
    {
        if (antwoord.equals(super.getCorrecteAntwoord()))
        {
            return true;
        }
        return false;
    }
}
