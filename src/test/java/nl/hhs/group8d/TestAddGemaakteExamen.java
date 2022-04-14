package nl.hhs.group8d;


import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.entities.ExamenResultaten;
import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TestAddGemaakteExamen {

    private final Student student = new Student("Harry", 0);
    private final File bestand1 = new File("Studentenlijst/" + student.getstudentNummer() + ".txt");
    private static final Examen testExamen = new Examen("test examen", 2, Arrays.asList(
            new MultipleChoiceVraag("test vraag", "abc", Arrays.asList("abc", "def", "ghi")),
            new MultipleChoiceVraag("test vraag 2", "ghi", Arrays.asList("abc", "def", "ghi")),
            new OpenVraag("test vraag 3", "qwerty")
    ));

    /**
     * Deze test controleert of het bestand op de juiste plek wordt aangemaakt en met de juiste naam.
     * Hij maakt een test resultaat van een examen aan en controleert daarna of er door addGemaakteExamen een bestand is aangemaakt.
     */

    @Test
    public void addGemaaktExamen_bestandCreatie(){
        //Arrange
        ExamenResultaten examenResultaat = new ExamenResultaten(student, testExamen, 1);

        //Act
        student.addGemaakteExamen(examenResultaat);

        //Assert
        Assertions.assertTrue(bestand1.exists());
    }

    /**
     * Deze test controleert of er iets is geschreven naar het student bestand.
     * Hij maakt een test resultaat van een examen aan en controleert daarna of er regels staan in het bestand en of het aantal klopt.
     */
    @Test
    public void addGemaaktExamen_naarBestandSchrijven(){
        //Arrange
        ExamenResultaten examenResultaat = new ExamenResultaten(student, testExamen, 1);
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
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @AfterEach
    public void verwijderBestand() {
        bestand1.delete();
    }
}
