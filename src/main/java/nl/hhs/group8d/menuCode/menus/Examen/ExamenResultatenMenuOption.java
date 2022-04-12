package nl.hhs.group8d.menuCode.menus.Examen;


import nl.hhs.group8d.menuCode.Menu;
import nl.hhs.group8d.menuCode.MenuOption;

public class ExamenResultatenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Gemaakte examens";
    }

    @Override
    public void executeMenuOption() {

    }

    @Override
    public Menu getNextSubMenu(){
        Menu menu = new Menu();
        menu.add(new meestGehaaldMenuOption());
        menu.add(new SpecifiekeExamenMenuOption());
        return menu;
    }
}
