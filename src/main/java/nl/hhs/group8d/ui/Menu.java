package nl.hhs.group8d.ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuOption> menuOptions;

    public Menu(){
        this.menuOptions = new ArrayList<>();
    }

    public List<MenuOption> getMenuOptions() {
        return menuOptions;
    }

    public void add(MenuOption menuOption){
        this.menuOptions.add(menuOption);
    }

}
