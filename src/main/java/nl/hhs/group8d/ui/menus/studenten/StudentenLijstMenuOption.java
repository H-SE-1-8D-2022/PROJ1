package nl.hhs.group8d.ui.menus.studenten;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.MenuOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentenLijstMenuOption extends MenuOption {
    private ArrayList<Student> studentenLijst;

    @Override
    public String getTitle() {
        return "Lijst met Studenten.";
    }

    @Override
    public void executeMenuOption() {


        this.studentenLijst = Student.studentenLijst;

        printStudenten();
        System.out.print("Van welke student wil je de info zien: ");

        processInput(getUserIntInput(0, studentenLijst.size()));

    }

    private void processInput(int input) {
        if (input != 0) {
            printStudent(input - 1);

            //Make the user say something before returning to the menu.
            getUserIntInput();
        }
    }

    private void printStudenten() {

        int i = 1;
        for (Student student : this.studentenLijst) {
            System.out.print(i++ + ". ");
            System.out.print(student.getstudentNummer());
            System.out.println(" (" + student.getNaam() + ")");

        }

        System.out.println("0. Exit");

    }

    private void printStudent(int index) {
        Student student = studentenLijst.get(index);

        System.out.println("Naam: " + student.getNaam());
        System.out.println("Studentnummer: " + student.getstudentNummer());

        System.out.println("1. Alle examens");
        System.out.println("2. Behaalde examens");
        System.out.println("0. Exit");
        int optie = getUserIntInput(0, 2);
        if (optie == 0) {
            return;
        } else if (optie == 1) {
            getStudentInfo(student.getstudentNummer());

        } else if (optie == 2) {
            getBehaaldeExamens(student.getstudentNummer());
        }

        System.out.println("0. exit");
        getScanner().nextLine();


    }

    public void getBehaaldeExamens(int nummer) {
        try (BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + nummer + ".txt"))) {
            String regel;
            boolean behaaldExamen = false;
            System.out.println("Gemaakte examens: ");
            while ((regel = in.readLine()) != null) {
                String geslaagd;
                String[] woorden = regel.split(",");
                String examenNaam = woorden[0];
                int aantalCorrect = Integer.parseInt(woorden[1]);
                int totaalAantal = Integer.parseInt(woorden[2]);
                boolean uitslag = Boolean.parseBoolean(woorden[3]);
                if (uitslag) {
                    geslaagd = "Geslaagd";
                    System.out.println("[" + examenNaam + "]" + ", aantal correct: " + aantalCorrect + "/" + totaalAantal + ", " + geslaagd);
                    behaaldExamen = true;
                }

                if (!behaaldExamen) {
                    System.out.println("Deze student heeft nog geen examens gehaald.");
                }

            }

        } catch (Exception e) {
            System.out.println("Deze student heeft nog geen examens gemaakt.");
        }
    }

    public void getStudentInfo(int nummer) {
        try (BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + nummer + ".txt"))) {
            String regel;
            System.out.println("Gemaakte examens: ");
            while ((regel = in.readLine()) != null) {
                String geslaagd;
                String[] woorden = regel.split(",");
                String examenNaam = woorden[0];
                int aantalCorrect = Integer.parseInt(woorden[1]);
                int totaalAantal = Integer.parseInt(woorden[2]);
                boolean uitslag = Boolean.parseBoolean(woorden[3]);
                if (uitslag) {
                    geslaagd = "Geslaagd";
                } else {
                    geslaagd = "Niet geslaagd";
                }
                System.out.println("[" + examenNaam + "]" + ", aantal correct: " + aantalCorrect + "/" + totaalAantal + ", " + geslaagd);
            }

        } catch (Exception e) {
            System.out.println("Deze student heeft nog geen examens gemaakt.");
        }
    }
}
