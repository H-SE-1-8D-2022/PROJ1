package nl.hhs.group8d.ui.menus;

import nl.hhs.group8d.ui.Menu;
import nl.hhs.group8d.ui.MenuOption;
import nl.hhs.group8d.ui.menus.studenten.StudentInschrijvenMenuOption;
import nl.hhs.group8d.ui.menus.studenten.StudentVerwijderenMenuOption;
import nl.hhs.group8d.ui.menus.studenten.StudentenLijstMenuOption;

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
