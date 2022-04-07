package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.menus.Studenten.Student;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentVerwijderenMenuOption;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestStudentToevoegenEnVerwijderen {
    @Test
    public void studentToevoegen(){

        String input = "Stephan\n147852\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        StudentInschrijvenMenuOption studentInschrijven = new StudentInschrijvenMenuOption();
        studentInschrijven.executeMenuOption();

        Student expectedResult = new Student("Stephan", 147852);

        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        assertEquals(expectedResult.getNaam(), actualResult.getNaam());

        assertEquals(expectedResult.getstudentNummer(), actualResult.getstudentNummer());


    }

    @Test
    public void productVerwijderen(){
        String input = "147852\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        StudentVerwijderenMenuOption studentVerwijderen = new StudentVerwijderenMenuOption();

        studentVerwijderen.executeMenuOption();

        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        int expectedResult = 147852;
        assertNotEquals(expectedResult, actualResult.getstudentNummer());
    }


}