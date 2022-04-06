package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.MenuOption;
import java.io.BufferedWriter;
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
        if(!checkVoorStudentnr()){
            System.out.println("Dit studentnummer staat niet in het systeem!");
            vraagStudentnummer();
        }
    }

    private boolean checkVoorStudentnr(){
        System.out.println("Vul studentnummer in: ");
        int studentNummer = getUserIntInput(0, 99999999);
        for (Student st : Student.studentenLijst) {
            if (st.getstudentNummer() == studentNummer) {
                verwijderStudent(st);
                return true;
            }
        }
        return false;
    }

    private void verwijderStudent(Student student){
        Student.studentenLijst.remove(student);
        try(PrintWriter writer = new PrintWriter(Student.BESTAND))
        {writer.print("");        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Student stud : Student.studentenLijst) {
            try (FileWriter fw = new FileWriter(Student.BESTAND, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter pw = new PrintWriter(bw)) {
                pw.println(stud.getNaam() + "," + stud.getstudentNummer());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Student: " + student.getNaam() + " met het nummer: " + student.getstudentNummer() +  " is verwijderd.");
        System.out.println("0. exit");
        getUserStringInput();
    }
}
