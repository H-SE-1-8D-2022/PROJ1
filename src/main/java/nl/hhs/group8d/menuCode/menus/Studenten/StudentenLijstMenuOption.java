package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.iMenuOption;

public class StudentenLijstMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Studenten.";
    }

    @Override
    public void executeMenuOption() {
        iMenuOption.super.executeMenuOption();
    }
}
