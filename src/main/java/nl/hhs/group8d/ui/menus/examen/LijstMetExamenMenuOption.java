package nl.hhs.group8d.ui.menus.examen;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.ui.MenuOption;

public class LijstMetExamenMenuOption extends MenuOption {
    @Override
    public String getTitle() {
        return "Lijst met Examens.";
    }

    @Override
    public void executeMenuOption() {
        if (Examen.examens.size() == 0) {
            System.out.println("Er zijn nog geen examens.");
            System.out.println("0. Exit");
            getUserStringInput();
            return;
        }

        krijgLijstMetExamens();

    }

    @SuppressWarnings("SameReturnValue")
    private void krijgLijstMetExamens() {
        for (int peo = 0; peo < Examen.examens.size(); peo++) {
            System.out.println((peo + 1) + ". " + Examen.examens.get(peo).getName());
        }
        System.out.println("0. exit");
        getUserIntInput();


    }
}