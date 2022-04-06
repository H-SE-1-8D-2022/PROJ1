package nl.hhs.group8d.menuCode.menus.Studenten;


import nl.hhs.group8d.menuCode.entities.ExamenResultaten;


import java.io.*;
import java.util.ArrayList;

public class Student {
    private String naam;
    private int studentNummer;
    public final static ArrayList<Student> studentenLijst = getStudentenLijst();
    public final static String BESTAND = "Student.txt";


    public Student(String naam, int studentNummer){
        this.naam = naam;
        this.studentNummer = studentNummer;
    }

    private static ArrayList<Student> getStudentenLijst(){
        int stnummer;
        ArrayList<Student> studentenLijst = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader(Student.BESTAND))){
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

  public  static void addGemaakteExamen(ExamenResultaten examenResultaat){
      File bestand = new File("Studentenlijst");
      bestand.mkdir();
      try(FileWriter fw = new FileWriter("Studentenlijst/" + examenResultaat.getStudent().getstudentNummer() + ".txt", true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter pw = new PrintWriter(bw)){
          pw.println(examenResultaat.getExamen().getName() + "," + examenResultaat.getAantalCorrect());
          System.out.println("Examen toegevoegd");
      } catch (Exception e) {
          e.printStackTrace();
      }
  }


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
