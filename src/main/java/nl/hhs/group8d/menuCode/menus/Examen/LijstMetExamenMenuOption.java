package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.iMenuOption;

import java.util.Scanner;

public class LijstMetExamenMenuOption implements iMenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Examens.";
    }

    @Override
    public void executeMenuOption() {

        System.out.println("""
                
                fdslf das
                dsf asdf d 
                          dsfadsfd saf dsf 
                          
                """);

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

    }
}
