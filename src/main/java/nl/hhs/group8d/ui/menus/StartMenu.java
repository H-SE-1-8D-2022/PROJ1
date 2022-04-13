package nl.hhs.group8d.ui.menus;

import nl.hhs.group8d.ui.Menu;

public class StartMenu extends Menu {

    public StartMenu(){
        super();

        add(new StudentMenuOption());
        add(new ExamenMenuOption());
    }


}
