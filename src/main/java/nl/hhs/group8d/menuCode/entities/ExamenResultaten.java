package nl.hhs.group8d.menuCode.entities;

import nl.hhs.group8d.menuCode.menus.Examen.Examen;
import nl.hhs.group8d.menuCode.menus.Studenten.Student;

public class ExamenResultaten {
    private final Student student;
    private final Examen examen;
    private final int aantalCorrect;

    public ExamenResultaten(Student student, Examen examen, int aantalCorrect) {
        this.student = student;
        this.examen = examen;
        this.aantalCorrect = aantalCorrect;
    }


    public Student getStudent() {
        return student;
    }

    public int getAantalCorrect() {
        return aantalCorrect;
    }

    public Examen getExamen() {
        return examen;
    }

    public boolean heeftGehaald() {
        return aantalCorrect >= examen.getAantalCorrectNodig();
    }
}

