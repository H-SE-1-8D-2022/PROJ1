package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.menus.Studenten.Student;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentVerwijderenMenuOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertNotEquals;

public class TestStudentVerwijderen {
    @BeforeEach
    public void studentAanmaken(){
        String input = "Stephan\n192168\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        StudentInschrijvenMenuOption studentInschrijven = new StudentInschrijvenMenuOption();
        studentInschrijven.executeMenuOption();
    }

    @Test
    public void studentVerwijderen(){
        //Arrange
        StudentVerwijderenMenuOption studentVerwijderen = new StudentVerwijderenMenuOption();
        String input = Student.studentenLijst.size() + "\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        int expectedResult = 192168;

        //Act
        studentVerwijderen.executeMenuOption();
        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        //Assert
        Assertions.assertNotEquals(expectedResult, actualResult.getstudentNummer());
    }

}
