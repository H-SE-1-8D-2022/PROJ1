package nl.hhs.group8d.scherm;

import nl.hhs.group8d.element.Element;

import java.util.List;

public abstract class Scherm {
    private List<Element> elementen;

    protected Scherm(List<Element> elementen) {
        this.elementen = elementen;
    }

    public void geefWeer() {
        for (Element element : elementen) {
            element.geefWeer();
        }
    }
    public abstract Scherm verwerkInput(String input);
}
