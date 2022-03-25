package nl.hhs.group8d.menuCode;

import java.util.ArrayList;

public class Submenu {

    private ArrayList<iMenuOption> menuOptions = new ArrayList<>();

    public Submenu(){
        this.menuOptions = new ArrayList<>();
    }

    public Submenu(ArrayList menuOptions){
        setMenuOptions(menuOptions);
    }

    public void setMenuOptions(ArrayList<iMenuOption> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public ArrayList<iMenuOption> getMenuOptions() {
        return menuOptions;
    }

    public void add(iMenuOption menuOption){
        this.menuOptions.add(menuOption);
    }

}
