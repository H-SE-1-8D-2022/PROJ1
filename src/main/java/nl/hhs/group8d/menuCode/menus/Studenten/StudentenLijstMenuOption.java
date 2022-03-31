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


        this.studentenLijst = getStudentenLijst();

        printStudenten();

        processInput(getUserInput());

    }

    private ArrayList<Student> getStudentenLijst(){
        return Student.getStudentenLijst();

    }

    private void processInput(int input){
        if(input == 0){
            return;
        } else {
            printStudent(input - 1);
        }
    }

    private int getUserInput(){
        Boolean noValidInput = true;
        while(noValidInput) {
            try {
                int index = getScanner().nextInt();
                if(index < 0 || index > studentenLijst.size()){
                    System.out.println("Please enter a valid input.");
                } else {
                    return index;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        return 0;
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

        System.out.println(student.getNaam());
        System.out.println(student.getstudentNummer());
        System.out.println("0. exit");
        getScanner().nextLine();
    }

}
