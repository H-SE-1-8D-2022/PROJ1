package nl.hhs.group8d.ui.menus.studenten;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.MenuOption;

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
        inschrijvenStudent(vraagStudentInfo());
    }

    private Student vraagStudentInfo() {
        System.out.println("Als je wilt stoppen met student aanmaken type 0");
        System.out.print("Vul de naam in: ");
        String naam = getUserStringInput();
        if (naam.equals("0")) {
            return null;
        }
        System.out.print("Vul de studentnummer in: ");
        int studentNummer = getUserIntInput(0, 99999999);
        if (studentNummer == 0) {
            return null;
        }
        boolean geldigStudentNummer = true;
        for (Student student : Student.studentenLijst) {
            if (student.getstudentNummer() == studentNummer) {
                geldigStudentNummer = false;
            }
        }
        if (geldigStudentNummer) {
            System.out.println("Kloppen de volgende gegevens?");
            System.out.println("Naam: "+naam);
            System.out.println("Studentnummer: "+studentNummer);
            System.out.println("1. ja\n0. Annuleer");
            System.out.print("Keuze: ");
            int input = getUserIntInput(0,1);
            if(input == 0){
                System.out.println("Student is niet aangemaakt.\n0. Exit");
                getUserStringInput();
                return null;
            }


            return new Student(naam, studentNummer);
        } else {
            System.out.println("Studentnummer al in het systeem.");
        }
        return null;
    }


    private void inschrijvenStudent(Student student) {
        if(student == null) return;
        Student.studentenLijst.add(student);
        try (FileWriter fw = new FileWriter(Student.BESTAND, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(student.getNaam() + "," + student.getstudentNummer());
            System.out.println("Student account aangemaakt");
            System.out.println("0. exit");
            getUserStringInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
