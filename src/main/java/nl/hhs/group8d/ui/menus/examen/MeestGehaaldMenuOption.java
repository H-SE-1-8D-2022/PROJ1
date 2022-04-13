package nl.hhs.group8d.ui.menus.examen;

import nl.hhs.group8d.entities.Student;
import nl.hhs.group8d.ui.MenuOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static nl.hhs.group8d.entities.Student.studentenLijst;

public class MeestGehaaldMenuOption extends MenuOption {

    @Override
    public String getTitle() {
        return "Student(en) met meest gehaalde examens";
    }

    @Override
    public void executeMenuOption() {
        meestGehaald();
    }

    private void meestGehaald() {
        ArrayList<Student> besteStudenten = new ArrayList<>();
        int hoogsteAantal = 0;
        for (Student student : studentenLijst) {
            try (BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + student.getstudentNummer() + ".txt"))) {
                String regel;
                int aantalGehaald = 0;
                while ((regel = in.readLine()) != null) {
                    String[] woorden = regel.split(",");
                    boolean uitslag = Boolean.parseBoolean(woorden[3]);
                    if (uitslag) {
                        aantalGehaald++;
                    }
                }
                if (aantalGehaald > hoogsteAantal) {
                    hoogsteAantal = aantalGehaald;
                    besteStudenten.clear();
                    besteStudenten.add(student);
                } else if (aantalGehaald == hoogsteAantal) {
                    besteStudenten.add(student);
                }

            } catch (Exception e) {
            }
        }
        for (Student student : besteStudenten) {
            System.out.println(student.getNaam() + " heeft " + hoogsteAantal + " examens gehaald.");
        }

        System.out.println("0. exit");
        getUserIntInput();


    }


}
