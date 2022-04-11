package nl.hhs.group8d.vraag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoiceVraag extends Vraag
{
    private List<String> opties;
    private final List<String> alfabet = Arrays.asList("a","b","c","d","e","f","g","h","i");

   public MultipleChoiceVraag(String vraag, String correctAntwoord, List<String> opties)
   {
       super(vraag,correctAntwoord);
       this.opties = opties;
   }

    public List<String> getOpties()
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
            System.out.println(alfabet.get(i).toUpperCase() +")- " + opties.get(i));
        }
    }

    @Override
    public boolean isCorrect(String antwoord){
        int index = alfabet.indexOf(antwoord.toLowerCase());
        if (index < 0 || index >= opties.size()){
            // Geen valide antwoord
            return false;
        }

        return getCorrecteAntwoord().equals(opties.get(index));
    }
}
