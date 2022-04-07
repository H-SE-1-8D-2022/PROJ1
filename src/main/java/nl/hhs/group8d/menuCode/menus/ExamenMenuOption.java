package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Menu;
import nl.hhs.group8d.menuCode.MenuOption;
import nl.hhs.group8d.menuCode.menus.Examen.AfnemenExamenMenuOption;
import nl.hhs.group8d.menuCode.menus.Examen.LijstMetExamenMenuOption;

public class ExamenMenuOption extends MenuOption {

    @Override
    public String getTitle() {
        return "Examen";
    }

    @Override
    public void executeMenuOption() {

    }

    @Override
    public Menu getNextSubMenu() {
        Menu menu = new Menu();
        menu.add(new AfnemenExamenMenuOption());
        menu.add(new LijstMetExamenMenuOption());
        return menu;
    }


}
