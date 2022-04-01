package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.MenuOption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class StudentInschrijvenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Student inschrijven.";
    }

    @Override
    public void executeMenuOption() {
        vraagStudentInfo();
    }

    private void vraagStudentInfo() {
        System.out.println("Wat is je naam?");
        String naam = getUserStringInput();
        System.out.println("Wat is je studentennummer?");
        int studentNummer = getUserIntInput(0, 99999999);
        boolean geldigStudentNummer = true;
        for(Student student : Student.studentenLijst){
            if(student.getstudentNummer() == studentNummer){
                geldigStudentNummer = false;
            }
        }
        if(geldigStudentNummer){
            inschrijvenStudent(naam, studentNummer);
        }
        else{
            System.out.println("Studentnummer al in het systeem.");
        }
    }


    private void inschrijvenStudent(String naam, int studentNummer){
        Student student = new Student(naam, studentNummer);
        Student.studentenLijst.add(student);
        try(FileWriter fw = new FileWriter(Student.BESTAND, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)){
            pw.println(naam + "," +studentNummer);
            System.out.println("Student account aangemaakt");
            System.out.println("0. exit");
            getUserStringInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
