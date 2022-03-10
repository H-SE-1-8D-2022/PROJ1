package nl.hhs.group8d.scherm;

import nl.hhs.group8d.element.Element;

import java.util.List;

public class OpenVraagScherm extends VraagScherm {
    protected OpenVraagScherm(List<Element> elementen) {
        super(elementen);
    }

    @Override
    public Scherm verwerkInput(String input) {
        return null;
    }
}
