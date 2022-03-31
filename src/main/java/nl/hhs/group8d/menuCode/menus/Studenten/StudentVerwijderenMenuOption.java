package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import static nl.hhs.group8d.menuCode.menus.Studenten.Student.getStudentenLijst;

public class StudentVerwijderenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Verwijder een student.";
    }

    @Override
    public void executeMenuOption() {
        vraagStudentnummer(getScanner());
    }

    private void vraagStudentnummer(Scanner scanner) {
        boolean check = true;
        while(check) {
            System.out.println("Wat is je studentnummer:");
            int studentNummer = scanner.nextInt();
            check = checkVoorStudentnr(studentNummer);
        }
    }

    private boolean checkVoorStudentnr(int studentNummer){
            for (Student st : getStudentenLijst()) {
                if (st.getstudentNummer() == studentNummer) {
                    verwijderStudent(st);
                    return false;
                }
            }
            System.out.println("Dit studentnummer staat niet in het systeem!");
            return true;
        }

    private void verwijderStudent(Student st){
            Student student = new Student();
            student.studentRemove(st);
            try(PrintWriter writer = new PrintWriter("Student.txt"))
            {
                writer.print("");
            } catch (Exception e) {
                e.printStackTrace();
        }
            for(Student stud : getStudentenLijst()) {
                try (FileWriter fw = new FileWriter("Student.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw)) {
                    pw.println(stud.getNaam() + "," + stud.getstudentNummer());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        System.out.println("Student: " + st.getNaam() + " met het nummer: " + st.getstudentNummer() +  " verwijderd.");
    }
}
