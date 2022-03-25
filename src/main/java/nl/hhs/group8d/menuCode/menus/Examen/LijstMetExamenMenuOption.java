package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.iMenuOption;

public class LijstMetExamenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Examens.";
    }

    @Override
    public void executeMenuOption() {
        iMenuOption.super.executeMenuOption();
    }
}
