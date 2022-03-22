package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

public class StudentInfoMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Student Informatie.";
    }

    @Override
    public void executeMenuOption() {
        iMenuOption.super.executeMenuOption();
    }
}
