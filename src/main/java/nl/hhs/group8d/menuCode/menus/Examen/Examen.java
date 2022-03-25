package nl.hhs.group8d.menuCode.menus.Examen;

import java.util.ArrayList;

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
}
