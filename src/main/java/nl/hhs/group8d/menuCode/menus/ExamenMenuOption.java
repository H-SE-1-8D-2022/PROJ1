package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Submenu;
import nl.hhs.group8d.menuCode.iMenuOption;
import nl.hhs.group8d.menuCode.menus.Examen.AfnemenExamenMenuOption;
import nl.hhs.group8d.menuCode.menus.Examen.LijstMetExamenMenuOption;

public class ExamenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Examen";
    }

    @Override
    public Submenu getNextSubMenu() {
        Submenu submenu = new Submenu();
        submenu.add(new AfnemenExamenMenuOption());
        submenu.add(new LijstMetExamenMenuOption());
        return submenu;
    }
}
