package nl.hhs.group8d.entities;

import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    public static ArrayList<Examen> examens = new ArrayList<>();
    private String name;
    private Integer aantalCorrectNodig;
    private List<Vraag> vragen;

    public Examen(String name, Integer aantalCorrectNodig, List<Vraag> vragenN) {
        this.name = name;
        this.aantalCorrectNodig = aantalCorrectNodig;
        this.vragen = vragenN;
        examens.add(this);
    }

    public String getName() {
        return name;
    }

    public Integer getAantalCorrectNodig() {
        return this.aantalCorrectNodig;
    }

    public List<Vraag> getVragen() {
        return vragen;
    }

}
