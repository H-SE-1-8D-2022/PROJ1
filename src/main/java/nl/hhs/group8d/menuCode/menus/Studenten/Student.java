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
    }

    public Student(){}


    public void studentAdd(Student student){
        studentenLijst.add(student);
    }
    public void studentRemove(Student student){
        studentenLijst.remove(student);
    }

    public static ArrayList<Student> getStudentenLijst(){
        int stnummer;
        if(studentenLijst.size() > 0){
            return studentenLijst;
        }
        try(BufferedReader in = new BufferedReader(new FileReader("Student.txt"))){
            String regel;
            while ((regel = in.readLine()) != null) {
                String[] woorden = regel.split(",");
                String naam = woorden[0];
                stnummer = Integer.parseInt(woorden[1]);
                Student student = new Student(naam, stnummer);
                studentenLijst.add(student);
            }
            }catch(Exception e){
            e.printStackTrace();
            }
        return studentenLijst;
    }

//    public void addGemaakteExamen(Examen : examenResultaten){
//
//    }


    @Override
    public String toString() {
        return "Student{" +
                "naam='" + naam + '\'' +
                ", studentNummer=" + studentNummer +
                '}';
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
