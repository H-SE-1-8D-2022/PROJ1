package nl.hhs.group8d.element;

import java.util.List;

public class MenuElement implements Element {
    private List<ButtonElement> buttons;

    public MenuElement(List<ButtonElement> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void geefWeer() {
        int i = 1;
        for (ButtonElement button : buttons) {
            System.out.print(i++);
            button.geefWeer();
        }
    }

    @Override
    public void verwerkInput(String input) {
        int index = Integer.getInteger(input);
        if (index > 0 && index <= buttons.size()) {
            buttons.get(index - 1).verwerkInput(input);
        }
    }
}
