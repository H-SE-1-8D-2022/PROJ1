package nl.hhs.group8d.menuCode.menus.Examen;

import nl.hhs.group8d.menuCode.MenuOption;

import java.util.ArrayList;

public class LijstMetExamenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Examens.";
    }

    @Override
    public void executeMenuOption() {
        krijgLijstMetExamens();

    }

    private ArrayList<Examen> krijgLijstMetExamens(){
        for (int peo = 0; peo < Examen.examens.size(); peo++){
            System.out.println((peo + 1) + ". " + Examen.examens.get(peo).getName() );
        }
        System.out.println("0. exit");
        getUserIntInput();

        return null;


    }
}
