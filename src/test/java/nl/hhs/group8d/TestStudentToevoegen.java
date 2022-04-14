package nl.hhs.group8d;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.menus.studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.ui.menus.studenten.StudentVerwijderenMenuOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


public class TestStudentToevoegen {
    /**
     * Test of een student op de juiste manier wordt toegevoegd aan de studentenLijst.
     * Hij voert de class StudentInschrijvenMenuOption uit en voert de gegevens van een student in.
     * Daarna wordt de student aangemaakt en toegevoegd aan de lijst.
     */
    @Test
    public void studentToevoegen() {
        Student expectedResult = new Student("Stephan", 147852);
        String input = "Stephan\n147852\n1\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        StudentInschrijvenMenuOption studentInschrijven = new StudentInschrijvenMenuOption();

        studentInschrijven.executeMenuOption();
        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        Assertions.assertEquals(expectedResult.getNaam(), actualResult.getNaam());
        Assertions.assertEquals(expectedResult.getstudentNummer(), actualResult.getstudentNummer());
    }

    @AfterEach
    public void verwijderStudent() {
        String input = Student.studentenLijst.size() + "\n1\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        StudentVerwijderenMenuOption studentVerwijderen = new StudentVerwijderenMenuOption();
        studentVerwijderen.executeMenuOption();
    }


}
