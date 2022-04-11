package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Menu;
import nl.hhs.group8d.menuCode.MenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentVerwijderenMenuOption;
import nl.hhs.group8d.menuCode.menus.Studenten.StudentenLijstMenuOption;

public class StudentMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Studenten";
    }


    @Override
    public Menu getNextSubMenu() {
        Menu menu = new Menu();
        menu.add(new StudentenLijstMenuOption());
        menu.add(new StudentInschrijvenMenuOption());
        menu.add(new StudentVerwijderenMenuOption());

        return menu;
    }

    @Override
    public void executeMenuOption() {

    }


}
