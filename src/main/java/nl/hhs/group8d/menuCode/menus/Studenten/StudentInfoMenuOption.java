package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

import java.util.Scanner;

public class StudentInfoMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Student Informatie.";
    }

    @Override
    public void executeMenuOption() {
        System.out.println("Hier komt student informatie te staan");

        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
    }
}
