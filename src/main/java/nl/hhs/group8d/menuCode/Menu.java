package nl.hhs.group8d.menuCode;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuOption> menuOptions;

    public Menu(){
        this.menuOptions = new ArrayList<>();
    }

    public ArrayList<MenuOption> getMenuOptions() {
        return menuOptions;
    }

    public void add(MenuOption menuOption){
        this.menuOptions.add(menuOption);
    }

}
