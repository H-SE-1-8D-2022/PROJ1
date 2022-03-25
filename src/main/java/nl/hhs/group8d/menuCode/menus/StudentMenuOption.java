package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Submenu;
import nl.hhs.group8d.menuCode.iMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInfoMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentVerwijderenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentenLijstMenuOption;

public class StudentMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Studenten";
    }

    @Override
    public Submenu getNextSubMenu() {
        Submenu submenu = new Submenu();
        submenu.add(new StudentInfoMenuOption());
        submenu.add(new StudentenLijstMenuOption());
        submenu.add(new StudentInschrijvenMenuOption());
        submenu.add(new StudentVerwijderenMenuOption());

        return submenu;
    }

}
