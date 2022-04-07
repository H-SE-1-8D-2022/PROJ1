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
    }


    public void getStudentInfo(int nummer){
        if(nummer == 0){
            return;
        }
        try(BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + nummer + ".txt"))){
            String regel;
            System.out.println("Gemaakte examens: ");
            while ((regel = in.readLine()) != null) {
                String[] woorden = regel.split(",");
                String examenNaam = woorden[0];
                int aantalCorrect = Integer.parseInt(woorden[1]);
                System.out.println("Examennaam: " + examenNaam + ", aantal correct: " + aantalCorrect);
            }

        }catch(Exception e){
            System.out.println("Deze student heeft nog geen examens gemaakt.");
        }
    }
}
