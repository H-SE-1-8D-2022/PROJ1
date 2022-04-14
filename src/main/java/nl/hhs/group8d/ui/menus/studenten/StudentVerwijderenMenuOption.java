package nl.hhs.group8d.ui.menus.studenten;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.MenuOption;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class StudentVerwijderenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Verwijder een student.";
    }

    @Override
    public void executeMenuOption() {
        verwijderStudent(vraagStudent());
    }

    private Student vraagStudent() {
        int i = 1;
        for (Student student : Student.studentenLijst) {
            System.out.print(i++ + ". ");
            System.out.print(student.getstudentNummer());
            System.out.println(" (" + student.getNaam() + ")");
        }
        System.out.print("Welke student wil je verwijderen: ");
        int keuze = getUserIntInput();

        System.out.println("Weet u het zeker dat u "+Student.studentenLijst.get(keuze-1).getNaam()+" wilt verwijderen uit het systeem?");
        System.out.println("1. Ja.\n0. Annuleer.");
        System.out.print("Keuze: ");
        if(getUserIntInput(0,1) == 0){
            System.out.println("Student is niet verwijderd.\n0. Exit");
            getUserStringInput();
            return null;
        }
        return Student.studentenLijst.get(keuze - 1);
    }
    
    private void verwijderStudent(Student student) {
        if(student == null) return;
        Student.studentenLijst.remove(student);
        try (PrintWriter writer = new PrintWriter(Student.BESTAND)) {
            writer.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Student stud : Student.studentenLijst) {
            try (FileWriter fw = new FileWriter(Student.BESTAND, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter pw = new PrintWriter(bw)) {
                pw.println(stud.getNaam() + "," + stud.getstudentNummer());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File bestand = new File("Studentenlijst/" + student.getstudentNummer() + ".txt");
        bestand.delete();
        System.out.println("Student: " + student.getNaam() + " met het nummer: " + student.getstudentNummer() + " is verwijderd.");
        System.out.println("0. exit");
        getUserStringInput();
    }
}
