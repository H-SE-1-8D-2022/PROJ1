package nl.hhs.group8d.menuCode.menus.Studenten;

import java.io.*;
import java.util.ArrayList;

public class Student {
    private String naam;
    private int studentNummer;
    private static ArrayList<Student> studentenLijst = new ArrayList<>();



    public Student(String naam, int studentNummer){
        this.naam = naam;
        this.studentNummer = studentNummer;

        try(FileWriter fw = new FileWriter("Student.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw))
        {
            pw.println(this.naam + "," +this.studentNummer);
            System.out.println("Student account aangemaakt");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getstudentNummer() {
        return studentNummer;
    }

    public void setstudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

}
