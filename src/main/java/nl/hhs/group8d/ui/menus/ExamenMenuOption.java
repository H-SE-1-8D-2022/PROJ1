package nl.hhs.group8d.ui.menus;

import nl.hhs.group8d.ui.Menu;
import nl.hhs.group8d.ui.MenuOption;
import nl.hhs.group8d.ui.menus.examen.AfnemenExamenMenuOption;
import nl.hhs.group8d.ui.menus.examen.ExamenResultatenMenuOption;
import nl.hhs.group8d.ui.menus.examen.LijstMetExamenMenuOption;
import nl.hhs.group8d.ui.menus.examen.MaakExamenMenuOption;

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
        menu.add(new ExamenResultatenMenuOption());
        menu.add(new MaakExamenMenuOption());

        return menu;
    }


}
