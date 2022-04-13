package nl.hhs.group8d.entities;

import nl.hhs.group8d.vraag.Vraag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ExamenOmgeving {
    private final Student student;
    private final Examen examen;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Vraag> vragen = new ArrayList<>();
    private int aantalCorrect = 0;

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
            System.out.println("Correct!");
            aantalCorrect++;
        } else {
            System.out.println("Fout, het correcte antwoord was: " + vraag.getCorrecteAntwoord());
        }
    }

    private String krijgAntwoord() {
        return scanner.nextLine();
    }

    public ExamenResultaten getResultaten() {
        return new ExamenResultaten(student, examen, aantalCorrect);
    }

    // Alleen voor tests
    public void startExamenRandom(Random random) {
        randomizeVragenRandom(random);
        for (Vraag vraag : vragen) {
            stelVraag(vraag);
        }
    }

    private void randomizeVragenRandom(Random random) {
        Collections.shuffle(vragen, random);
    }
}
