package nl.hhs.group8d.element;

import java.util.List;

public class MenuElement implements Element {
    private List<ButtonElement> buttons;

    public MenuElement(List<ButtonElement> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void geefWeer() {

    }
}
