package nl.hhs.group8d.ui.menus.examen;


import nl.hhs.group8d.ui.Menu;
import nl.hhs.group8d.ui.MenuOption;

public class ExamenResultatenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Gemaakte examens";
    }

    @Override
    public void executeMenuOption() {

    }

    @Override
    public Menu getNextSubMenu() {
        Menu menu = new Menu();
        menu.add(new MeestGehaaldMenuOption());
        menu.add(new SpecifiekeExamenMenuOption());
        return menu;
    }
}
