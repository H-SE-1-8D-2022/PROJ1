package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.MenuOption;
import nl.hhs.group8d.menuCode.entities.ExamenOmgeving;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;

import java.util.Scanner;

public class AfnemenExamenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Examen afnemen.";
    }

    @Override
    public void executeMenuOption() {
        printExamenOpties();
        Examen examen = getExamen();
        if (examen == null){
            return;
        }
        openExamenOmgeving(vraagStudent(), examen);


    }

    private Examen getExamen(){
        int userInput = getUserIntInput(0, Examen.examens.size());
        if (userInput == 0){
            return null;
        }
        return Examen.examens.get(userInput-1);

    }

    private Student vraagStudent(){
        System.out.println("Vul studentnummer in: ");
        int studentnummer = getUserIntInput(0,99999999);
        for (int lsn = 0; lsn < Student.studentenLijst.size(); lsn++){
            if (studentnummer == Student.studentenLijst.get(lsn).getstudentNummer()){
                return Student.studentenLijst.get(lsn);
            }
        }
        System.out.println("Dit studentnummer staat niet in het systeem!");
        return null;
    }

    private void printExamenOpties(){
        System.out.println("Welke examen wilt u afnemen?");
        for (int peo = 0; peo < Examen.examens.size(); peo++){
            System.out.println((peo + 1) + ". " + Examen.examens.get(peo).getName() );
        }
        System.out.println("0. exit");
    }



    private void openExamenOmgeving(Student student, Examen examen){
        new ExamenOmgeving(student, examen);

    }
}
