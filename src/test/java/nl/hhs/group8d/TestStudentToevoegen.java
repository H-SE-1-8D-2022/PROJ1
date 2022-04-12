package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.menus.Studenten.Student;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentVerwijderenMenuOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


public class TestStudentToevoegen {
    @Test
    public void studentToevoegen(){
        //Arrange
        Student expectedResult = new Student("Stephan", 147852);
        String input = "Stephan\n147852\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        StudentInschrijvenMenuOption studentInschrijven = new StudentInschrijvenMenuOption();

        //Act
        studentInschrijven.executeMenuOption();
        Student actualResult = Student.studentenLijst.get(Student.studentenLijst.size() - 1);

        //Assert
        Assertions.assertEquals(expectedResult.getNaam(), actualResult.getNaam());
        Assertions.assertEquals(expectedResult.getstudentNummer(), actualResult.getstudentNummer());
    }

    @AfterEach
    public void verijwderStudent(){
        String input = Student.studentenLijst.size() + "\n0\n";
        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);
        StudentVerwijderenMenuOption studentVerwijderen = new StudentVerwijderenMenuOption();
        studentVerwijderen.executeMenuOption();
    }



}
