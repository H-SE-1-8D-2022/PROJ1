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
        vraagStudentnummer();
    }

    private void vraagStudentnummer() {
        int i = 1;
        for (Student student : Student.studentenLijst) {
            System.out.print(i++ + ". ");
            System.out.print(student.getstudentNummer());
            System.out.println(" (" + student.getNaam() + ")");

        }
        System.out.print("Welke student wil je verwijderen: ");
        int keuze = getUserIntInput();
        verwijderStudent(Student.studentenLijst.get(keuze - 1));
    }


    private void verwijderStudent(Student student) {

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
