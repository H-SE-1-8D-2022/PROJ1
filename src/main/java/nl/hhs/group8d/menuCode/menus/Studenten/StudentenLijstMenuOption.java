package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.MenuOption;

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
        StudentInfoMenuOption sti = new StudentInfoMenuOption();
        sti.getStudentInfo(student.getstudentNummer());
        System.out.println("0. exit");
        getScanner().nextLine();
    }

}
