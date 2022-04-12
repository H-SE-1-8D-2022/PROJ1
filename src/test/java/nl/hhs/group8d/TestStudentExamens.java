package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.entities.ExamenResultaten;
import nl.hhs.group8d.menuCode.menus.Examen.Examen;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;
import nl.hhs.group8d.vraag.OpenVraag;
import nl.hhs.group8d.vraag.Vraag;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestStudentExamens {
    @Test
    public void examenToevoegen(){
        int nummer = 123;
        Student student = new Student("Stephan", nummer);
        ArrayList<Vraag> vragenLijst = new ArrayList<>();
        Vraag vraag = new OpenVraag("Hoeveel is 10x10", "100");
        Vraag vraag2 = new OpenVraag("Wat is 5+5", "10");
        vragenLijst.add(vraag);
        vragenLijst.add(vraag2);

        Examen examen = new Examen("Wiskunde Examen", 2, vragenLijst);
        ExamenResultaten examenResultaten = new ExamenResultaten(student, examen, 1);
        student.addGemaakteExamen(examenResultaten);

        student.addGemaakteExamen(examenResultaten);


        String expectedResult = "Wiskunde Examen,1,2,false";
        String actualResult = getGemaaktExamen(nummer);
        assertEquals(expectedResult, actualResult);
    }

    private String getGemaaktExamen(int nummer){
        String woorden = null;
        try(BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + nummer + ".txt"))){
            String regel;
            while ((regel = in.readLine()) != null) {
                woorden = regel;
            }
        }catch(Exception e){
            System.out.println("Vul een geldig studentnummer in!");;
        }
        return woorden;
    }
}
