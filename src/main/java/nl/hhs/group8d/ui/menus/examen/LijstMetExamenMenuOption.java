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
        System.out.println("Er zijn "+Examen.examens.size()+" examens.");
        System.out.println("Examens:");
        for (int i = 0; i < Examen.examens.size(); i++) {
            System.out.println("- " + Examen.examens.get(i).getName());
        }
        System.out.println("0. exit");
        getUserIntInput();


    }
}
