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
    private static final Examen testExamen = new Examen("test examen", 2, Arrays.asList(
            new MultipleChoiceVraag("test vraag", "abc", Arrays.asList("abc", "def", "ghi")),
            new MultipleChoiceVraag("test vraag 2", "ghi", Arrays.asList("abc", "def", "ghi")),
            new OpenVraag("test vraag 3", "qwerty")
    ));

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
