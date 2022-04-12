package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.MenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static nl.hhs.group8d.menuCode.menus.Studenten.Student.studentenLijst;

public class meestGehaaldeMenuOption extends MenuOption {

    @Override
    public String getTitle() {
        return "Student(en) met meest gehaalde examens";
    }

    @Override
    public void executeMenuOption() {
        meestBehaald();
    }

    private void meestBehaald(){
        ArrayList<Student> besteStudenten = new ArrayList<>();
        int hoogsteAantal = 0;
        for(Student student : studentenLijst) {
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
                if(aantalGehaald > hoogsteAantal){
                    hoogsteAantal = aantalGehaald;
                    besteStudenten.clear();
                    besteStudenten.add(student);
                }
                else if(aantalGehaald == hoogsteAantal){
                    besteStudenten.add(student);
                }

            } catch (Exception e) {
            }
        }
        for(Student student : besteStudenten) {
            System.out.println(student.getNaam() + " heeft " + hoogsteAantal + " examens gehaald.");
        }

        System.out.println("0. exit");
        getUserIntInput();


    }



}
