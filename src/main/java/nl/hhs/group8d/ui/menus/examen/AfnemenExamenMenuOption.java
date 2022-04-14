package nl.hhs.group8d.ui.menus.examen;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.entities.ExamenOmgeving;
import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.MenuOption;

public class AfnemenExamenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Examen afnemen.";
    }

    @Override
    public void executeMenuOption() {
        if (Examen.examens.size() == 0) {
            System.out.println("Er zijn nog geen examens.");
            System.out.println("0. Exit");
            getUserStringInput();
            return;
        }

        printExamenOpties();
        Examen examen = getExamen();
        if (examen == null) {
            return;
        }
        Student student = vraagStudent();
        if (student == null) {
            return;
        }
        openExamenOmgeving(student, examen);


    }

    private Examen getExamen() {
        int userInput = getUserIntInput(0, Examen.examens.size());
        if (userInput == 0) {
            return null;
        }
        return Examen.examens.get(userInput - 1);

    }

    private Student vraagStudent() {
        System.out.println("Vul studentnummer in: ");
        System.out.print("Studentnummer: ");
        int studentnummer = getUserIntInput(0, 99999999);
        for (int i = 0; i < Student.studentenLijst.size(); i++) {
            if (studentnummer == Student.studentenLijst.get(i).getstudentNummer()) {
                return Student.studentenLijst.get(i);
            }
        }
        System.out.println("Dit studentnummer staat niet in het systeem.\n0. exit");
        getUserStringInput();
        return null;
    }

    private void printExamenOpties() {
        System.out.println("Welke examen wilt u afnemen?");
        for (int i = 0; i < Examen.examens.size(); i++) {
            System.out.println((i + 1) + ". " + Examen.examens.get(i).getName());
        }
        System.out.println("0. exit");
    }


    private void openExamenOmgeving(Student student, Examen examen) {
        ExamenOmgeving examenOmgeving = new ExamenOmgeving(student, examen);
        examenOmgeving.startExamen();
        student.addGemaakteExamen(examenOmgeving.getResultaten());

    }
}
