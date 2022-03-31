package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static nl.hhs.group8d.menuCode.menus.Studenten.Student.getStudentenLijst;

public class StudentInschrijvenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Student inschrijven.";
    }

    @Override
    public void executeMenuOption() {
        vraagStudentInfo(getScanner());
    }

    private void vraagStudentInfo(Scanner scanner) {
        System.out.println("Wat is je naam?");
        String naam = scanner.nextLine();
        System.out.println("Wat is je studentennummer?");
        int studentNummer;
        ArrayList<Student> stud = getStudentenLijst();
        boolean noValidStudentnummer = true;

        while(noValidStudentnummer) {
                boolean geldigStudentNummer = true;
                boolean message = false;
                studentNummer = scanner.nextInt();
                if(studentNummer > 99999999) {
                    geldigStudentNummer = false;
                    message = true;
                }
                for(Student student : stud){
                    if(student.getstudentNummer() == studentNummer){
                        geldigStudentNummer = false;
                        message = true;

                    }
                }
                if(message){
                    System.out.println("Vul een geldig studentnummer in.");
                }

                if(geldigStudentNummer){
                    inschrijvenStudent(naam, studentNummer);
                    return;
                }
        }
    }

    private void inschrijvenStudent(String naam, int studentNummer){
            Student student = new Student(naam, studentNummer);
            student.studentAdd(student);
            try(FileWriter fw = new FileWriter("Student.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw)){
                pw.println(naam + "," +studentNummer);
                System.out.println("Student account aangemaakt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}


