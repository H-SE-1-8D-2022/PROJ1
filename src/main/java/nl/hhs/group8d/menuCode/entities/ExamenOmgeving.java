package nl.hhs.group8d.menuCode.entities;

import nl.hhs.group8d.menuCode.menus.Examen.Examen;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;
import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExamenOmgeving {
    private final Student student;
    private final Examen examen;
    private int aantalCorrect = 0;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Vraag> vragen = new ArrayList<>();

    public ExamenOmgeving(Student student, Examen examen) {
        this.student = student;
        this.examen = examen;
        vragen.addAll(examen.getVragen());
    }

    public void startExamen() {
        randomizeVragen();
        for (Vraag vraag : vragen) {
            stelVraag(vraag);
        }
    }

    private void randomizeVragen() {
        Collections.shuffle(vragen);
    }

    private void stelVraag(Vraag vraag) {
        vraag.printVraag();
        String antwoord = krijgAntwoord();
        if (vraag.isCorrect(antwoord)) {
            aantalCorrect++;
        } else {
            //todo: code om te zeggen wat het goeie antwoord was.
        }
    }

    private String krijgAntwoord() {
        return scanner.nextLine();
    }

    public ExamenResultaten getResultaten() {
        return new ExamenResultaten(student, examen, aantalCorrect);
    }
}
