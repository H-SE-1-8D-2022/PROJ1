package nl.hhs.group8d;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.entities.ExamenOmgeving;
import nl.hhs.group8d.entities.ExamenResultaten;
import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.vraag.MultipleChoiceVraag;
import nl.hhs.group8d.vraag.OpenVraag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

class TestExamenOmgeving {
    /**
     * Voorbeel examen met 3 vragen en minimaal 2 goed
     */
    private static final Examen testExamen = new Examen("test examen", 2, Arrays.asList(
            new MultipleChoiceVraag("test vraag", "abc", Arrays.asList("abc", "def", "ghi")),
            new MultipleChoiceVraag("test vraag 2", "ghi", Arrays.asList("abc", "def", "ghi")),
            new OpenVraag("test vraag 3", "qwerty")
    ));

    /**
     * Test examen met alle 3 de juiste antwoorden
     * - Aantal correct = 3
     * - Gehaald = true
     *
     * Deze test word uitgevoerd omdat dit één van de belangerijkste functie is in de app,
     * als het uitvoeren van een examen niet soepel verloopt is er iets goed mis.
     */
    @Test
    void testExamenOmgeving() {
        Student student = Student.studentenLijst.get(0);

        String input = "qwerty\nC\nA\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        ExamenOmgeving omgeving = new ExamenOmgeving(student, testExamen);

        omgeving.startExamenRandom(new Random(0));
        ExamenResultaten results = omgeving.getResultaten();
        Assertions.assertEquals(3, results.getAantalCorrect());
        Assertions.assertTrue(results.heeftGehaald());
    }

    /**
     * Test examen met 1 fout antwoord
     * - Aantal correct = 2
     * - Gehaald = true
     *
     * Net als de test hierboven wordt deze test uitgevoerd omdat dit een heel belangrijk functie is om goed te hebben werken.
     */
    @Test
    void testExamenOmgeving1Fout() {
        Student student = Student.studentenLijst.get(0);

        String input = "qwerty\nA\nA\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        ExamenOmgeving omgeving = new ExamenOmgeving(student, testExamen);

        omgeving.startExamenRandom(new Random(0));
        ExamenResultaten results = omgeving.getResultaten();
        Assertions.assertEquals(2, results.getAantalCorrect());
        Assertions.assertTrue(results.heeftGehaald());
    }

    /**
     * Test examen met 3 foute antwoorden
     * - Aantal correct = 0
     * - Gehaald = false
     */
    @Test
    void testExamenOmgevingAllesFout() {
        Student student = Student.studentenLijst.get(0);

        String input = "\n\n\n";  // Geen antwoorden
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        ExamenOmgeving omgeving = new ExamenOmgeving(student, testExamen);

        omgeving.startExamenRandom(new Random(0));
        ExamenResultaten results = omgeving.getResultaten();
        Assertions.assertEquals(0, results.getAantalCorrect());
        Assertions.assertFalse(results.heeftGehaald());
    }
}
