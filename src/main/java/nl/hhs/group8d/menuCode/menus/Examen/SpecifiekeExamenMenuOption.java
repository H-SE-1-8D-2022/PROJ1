package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.MenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

public class SpecifiekeExamenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Specifieke examen";
    }

    @Override
    public void executeMenuOption() {

        Examen examen = getExamen();
        if(examen == null) return;
        Student student = getStudent();
        if(student == null) return;

        controlleerExamen(examen,student);

    }

    private void controlleerExamen(Examen examen, Student student){
        int aantalCorrect = 0;
        int totaalAantalVragen = 0;
        boolean examenGehaald = false;
        try(BufferedReader in = new BufferedReader(new FileReader("Studentenlijst/" + student.getstudentNummer() + ".txt"))){
            String regel;
            while ((regel = in.readLine()) != null) {
                String[] woorden = regel.split(",");
                String examenNaam = woorden[0];
                int aantalCorrectGemaakt = Integer.parseInt(woorden[1]);
                int totaalVragen = Integer.parseInt(woorden[2]);
                boolean gehaald = Boolean.parseBoolean(woorden[3]);

                if(gehaald && examen.getName().equals(examenNaam)){
                    examenGehaald = true;
                    aantalCorrect = aantalCorrectGemaakt;
                    totaalAantalVragen = totaalVragen;
                    break;
                }

            }
        }catch(Exception e){
            System.out.println("Deze student heeft nog geen examens gemaakt.");
        }

        if(examenGehaald){
            System.out.println(student.getNaam()+" Heeft de "+examen.getName()+" gehaald met een score van: "+aantalCorrect+"/"+totaalAantalVragen);
            System.out.println("0. exit");
            getUserStringInput();
        } else {
            System.out.println("Deze student heeft deze examen helaas nog niet gehaald.");
            System.out.println("0. exit");
            getUserStringInput();
        }

    }

    private Examen getExamen(){
        System.out.println("Wat is de naam van de examen die u wilt controlleren?\n0. exit");

        while(true) {
            String naam = getUserStringInput();

            if(naam.equals("0")) return null;

            for (Examen examen : Examen.examens) {
                if (examen.getName().toLowerCase(Locale.ROOT).equals(naam.toLowerCase())) {
                    return examen;
                }
            }
            System.out.println("Deze examen bestaat niet, wat is de naam van de examen?\n0. exit");
        }
    }

    private Student getStudent(){
        System.out.println("Welke student wilt u controlleren? (Voer het studentnummer in.)\n0. exit");

        while(true){
            int studentNummer = getUserIntInput(0,99999999);
            if(studentNummer == 0) return null;

            for(Student student : Student.studentenLijst){
                if(student.getstudentNummer() == studentNummer){
                    return student;
                }
            }

            System.out.println("Dit is geen geldig studentnummer, welke student wilt u controlleren?");

        }
    }
}
