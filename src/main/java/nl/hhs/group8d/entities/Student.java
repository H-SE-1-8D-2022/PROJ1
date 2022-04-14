package nl.hhs.group8d.entities;


import java.io.*;
import java.util.ArrayList;

public class Student {
    public final static String BESTAND = "Student.txt";
    public final static ArrayList<Student> studentenLijst = getStudentenLijst();
    private final String naam;
    private final int studentNummer;


    public Student(String naam, int studentNummer) {
        this.naam = naam;
        this.studentNummer = studentNummer;
    }

    private static ArrayList<Student> getStudentenLijst() {
        ArrayList<Student> studentenLijst = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(Student.BESTAND))) {
            String regel;
            while ((regel = in.readLine()) != null) {
                String[] woorden = regel.split(",");
                Student student = new Student(woorden[0], Integer.parseInt(woorden[1]));
                studentenLijst.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentenLijst;
    }

    public void addGemaakteExamen(ExamenResultaten examenResultaat) {
        File bestand = new File("Studentenlijst");
        if (!bestand.exists()) {
            bestand.mkdir();
        }
        try (FileWriter fw = new FileWriter("Studentenlijst/" + examenResultaat.getStudent().getstudentNummer() + ".txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(examenResultaat.getExamen().getName() + "," + examenResultaat.getAantalCorrect() + "," + examenResultaat.getExamen().getVragen().size() + "," + examenResultaat.heeftGehaald());
        } catch (Exception e) {
            System.out.println("Error bij het toevoegen van het examen");
        }
    }

    public String getNaam() {
        return naam;
    }

    public int getstudentNummer() {
        return studentNummer;
    }

}
