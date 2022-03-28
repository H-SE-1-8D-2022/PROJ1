package nl.hhs.group8d.menuCode.menus;

import nl.hhs.group8d.menuCode.Menu;

public class StartMenu extends Menu {

    public StartMenu(){
        super();

        add(new StudentMenuOption());
        add(new ExamenMenuOption());
    }


}
