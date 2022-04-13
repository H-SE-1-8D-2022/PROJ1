package nl.hhs.group8d;


import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.entities.ExamenResultaten;
import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import nl.hhs.group8d.vraag.Vraag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestaddGemaaktExamen {
    private int studentNummer = 0;
    private File bestand1 = new File("Studentenlijst/" + studentNummer + ".txt");


    @Test
    public void addGemaaktExamenCreatie(){
        //Arrange
        Student student = new Student("Harry", studentNummer);
        Vraag vraag1 = new OpenVraag("Hoeveel is 5+5", "10");
        ArrayList<String> opties1 = new ArrayList<>();
        opties1.add("Den Haag");
        opties1.add("Amsterdam");
        opties1.add("Breda");
        Vraag vraag2 = new MultipleChoiceVraag("Wat is de hoofdstad van Nederland?", "Amsterdam", opties1);
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(vraag1);
        vragen.add(vraag2);
        Examen examen = new Examen("Wiskunde toets", 2, vragen);
        ExamenResultaten examenResultaat = new ExamenResultaten(student, examen, 1);
        int actualResult = 0;
        int expectedResult = 1;

        //Act
        student.addGemaakteExamen(examenResultaat);
        try (BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + student.getstudentNummer() + ".txt"))) {
            while ((in.readLine()) != null) {
                actualResult++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Assert
        Assertions.assertTrue(bestand1.exists());
        Assertions.assertEquals(actualResult, expectedResult);

    }

    @AfterEach
    public void verwijderBestand() {
        bestand1.delete();
    }
}
