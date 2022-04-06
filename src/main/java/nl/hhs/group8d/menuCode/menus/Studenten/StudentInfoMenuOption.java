package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.MenuOption;

import java.io.BufferedReader;
import java.io.FileReader;

public class StudentInfoMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Student Informatie.";
    }

    @Override
    public void executeMenuOption() {
        getStudentInfo();

    }

    public int vraagStudentNummer(){
        System.out.println("Van welke student wil je de gegevens zien:");
        return getUserIntInput();
    }

    public void getStudentInfo(){
        int nummer = vraagStudentNummer();
        System.out.println("Gemaakte examens: ");
        try(BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + nummer + ".txt"))){
            String regel;
            while ((regel = in.readLine()) != null) {
                String[] woorden = regel.split(",");
                String examenNaam = woorden[0];
                int aantalCorrect = Integer.parseInt(woorden[1]);
                System.out.println("Examennaam: " + examenNaam + ", aantal correct: " + aantalCorrect);
            }
            System.out.println("0. exit");
            getUserStringInput();
        }catch(Exception e){
            System.out.println("Vul een geldig studentnummer in!");;
            getStudentInfo();
        }
    }
}
