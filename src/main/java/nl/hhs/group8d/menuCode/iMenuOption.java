package nl.hhs.group8d.menuCode;

import java.util.Scanner;

public interface iMenuOption {

    String getTitle();

    default Submenu getNextSubMenu() {
        return null;
    }

    default void executeMenuOption() {

    }

    default Scanner getScanner(){
        return new Scanner(System.in);
    }

}
