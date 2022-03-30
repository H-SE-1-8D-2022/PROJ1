package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Examen
{
    private String name;
    private Integer aantalCorrectNodig;
    private static ArrayList<Examen> examens = addExamens();

    public Examen(String name, Integer aantalCorrectNodig)
    {
        this.name = name;
        this.aantalCorrectNodig =aantalCorrectNodig;
    }

    public String getName()
    {
        return name;
    }

    public Integer getAantalCorrectNodig()
    {
        return aantalCorrectNodig;
    }

    private static ArrayList<Examen> addExamens()
    {
        ArrayList<Examen> ex = new ArrayList<>();
        ex.add(new WiskundeExamen());
        ex.add(new ScheikundeExamen());
        return ex;
    }

    public static ArrayList<Examen> getExamens()
    {
        return examens;
    }

    public ArrayList<Vraag> getVragen() {
        return null;
    }
}
