package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.Collection;

public  class Examen
{
    private String name;
    private Integer aantalCorrectNodig;
    public static ArrayList<Examen> examens;
    private ArrayList<Vraag> vragen;

    public Examen(String name, Integer aantalCorrectNodig,ArrayList<Vraag> vragenN)
    {
        this.name = name;
        this.aantalCorrectNodig = aantalCorrectNodig;
        this.vragen = vragenN;
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
    
    public void setVragen(ArrayList<Vraag> vragen)
    {this.vragen = vragen;}
    public ArrayList<Vraag> getVragen()
    {return vragen;}
}
