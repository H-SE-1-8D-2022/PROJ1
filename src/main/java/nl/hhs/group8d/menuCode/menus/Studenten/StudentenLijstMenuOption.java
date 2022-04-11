package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.MenuOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentenLijstMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Studenten.";
    }

    private ArrayList<Student> studentenLijst;

    @Override
    public void executeMenuOption(){


        this.studentenLijst = Student.studentenLijst;

        printStudenten();
        System.out.print("Van welke student wil je de info zien: ");

        processInput( getUserIntInput(0, studentenLijst.size()) );

    }

    private void processInput(int input){
        if(input == 0){
            return;
        } else {
            printStudent(input - 1);

            //Make the user say something before returning to the menu.
            getUserIntInput();
        }
    }

    private void printStudenten(){

        int i = 1;
        for(Student student : this.studentenLijst){
            System.out.print(i+++". ");
            System.out.print(student.getstudentNummer());
            System.out.println(" ("+student.getNaam()+")");

        }

        System.out.println("0. Exit");

    }

    private void printStudent(int index){
        Student student = studentenLijst.get(index);

        System.out.println("Naam: " + student.getNaam());
        System.out.println("Studentnummer: " + student.getstudentNummer());
        getStudentInfo(student.getstudentNummer());
        System.out.println("0. exit");
        getScanner().nextLine();
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
                int totaalAantal = Integer.parseInt(woorden[2]);
                String geslaagd = woorden[3];
                System.out.println("[" + examenNaam + "]" + ", aantal correct: " + aantalCorrect + "/" + totaalAantal + " " + geslaagd);
            }

        }catch(Exception e){
            System.out.println("Deze student heeft nog geen examens gemaakt.");
        }
    }
}
