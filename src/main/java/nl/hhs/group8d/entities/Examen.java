package nl.hhs.group8d.entities;

import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.List;

public  class Examen
{
    private String name;
    private Integer aantalCorrectNodig;
    public static ArrayList<Examen> examens = new ArrayList<>();
    private List<Vraag> vragen;

    public Examen(String name, Integer aantalCorrectNodig, List<Vraag> vragenN)
    {
        this.name = name;
        this.aantalCorrectNodig = aantalCorrectNodig;
        this.vragen = vragenN;
        examens.add(this);
    }

    public void setName(String name)
    {this.name = name;}
    public String getName()
    {return name;}

    public void setAantalCorrectNodig(Integer aantalCorrectNodig)
    {this.aantalCorrectNodig = aantalCorrectNodig;}
    public Integer getAantalCorrectNodig()
    {return this.aantalCorrectNodig;}

    public static void setExamens(ArrayList<Examen> examens)
    {Examen.examens = examens;}
    public static ArrayList<Examen> getExamens()
    {return examens;}
    
    public void setVragen(List<Vraag> vragen)
    {this.vragen = vragen;}
    public List<Vraag> getVragen()
    {return vragen;}
}
