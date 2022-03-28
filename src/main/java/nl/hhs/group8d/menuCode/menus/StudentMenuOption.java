package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Menu;
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
    public Menu getNextSubMenu() {
        Menu menu = new Menu();
        menu.add(new StudentInfoMenuOption());
        menu.add(new StudentenLijstMenuOption());
        menu.add(new StudentInschrijvenMenuOption());
        menu.add(new StudentVerwijderenMenuOption());

        return menu;
    }

}
