package nl.hhs.group8d.menuCode.menus.Studenten;

import nl.hhs.group8d.menuCode.Menu;
import nl.hhs.group8d.menuCode.iMenuOption;
import nl.hhs.group8d.menuCode.menus.Examen.AfnemenExamenMenuOption;
import nl.hhs.group8d.menuCode.menus.ExamenMenuOption;

public class StudentenLijstMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Studenten.";
    }

    @Override
    public Menu getNextSubMenu() {
        Menu menu = new Menu();
        menu.add(new ExamenMenuOption());
        menu.add(new AfnemenExamenMenuOption());
        menu.add(new StudentVerwijderenMenuOption());
        return menu;
    }

    @Override
    public void executeMenuOption(){
    }
}
