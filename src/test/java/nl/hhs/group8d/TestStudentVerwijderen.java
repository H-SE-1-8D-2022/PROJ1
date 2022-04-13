package nl.hhs.group8d;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.menus.studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.ui.menus.studenten.StudentVerwijderenMenuOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertNotEquals;

public class TestStudentVerwijderen {
    @BeforeEach
    public void studentAanmaken(){
        String input = "Stephan\n1921689\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        StudentInschrijvenMenuOption studentInschrijven = new StudentInschrijvenMenuOption();
        studentInschrijven.executeMenuOption();
    }

    @Test
    public void studentVerwijderen(){
        //Arrange
        int expectedResult = 192168;
        String input =  "2\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        StudentVerwijderenMenuOption studentVerwijderen = new StudentVerwijderenMenuOption();

        //Act
        studentVerwijderen.executeMenuOption();
        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        //Assert
        Assertions.assertNotEquals(expectedResult, actualResult.getstudentNummer());
    }

}
