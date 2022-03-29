package nl.hhs.group8d.menuCode;

import java.util.ArrayList;

public class Menu {

    private ArrayList<iMenuOption> menuOptions;

    public Menu(){
        this.menuOptions = new ArrayList<>();
    }

    public ArrayList<iMenuOption> getMenuOptions() {
        return menuOptions;
    }

    public void add(iMenuOption menuOption){
        this.menuOptions.add(menuOption);
    }

}
