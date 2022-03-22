package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

public class StudentVerwijderenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Verwijder een student.";
    }

    @Override
    public void executeMenuOption() {
        iMenuOption.super.executeMenuOption();
    }
}
