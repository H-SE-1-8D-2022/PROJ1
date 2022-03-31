package nl.hhs.group8d.menuCode;

import java.util.Scanner;

public abstract class MenuOption {

    public String getTitle() {
        return "Title to be added.";
    }

    public Menu getNextSubMenu() {
        return null;
    }

    public void executeMenuOption() {
        //todo: override
    }

    protected Scanner getScanner(){
        return new Scanner(System.in);
    }

}
