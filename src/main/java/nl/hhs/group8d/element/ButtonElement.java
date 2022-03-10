package nl.hhs.group8d.element;

import java.util.function.Consumer;

public class ButtonElement implements Element {
    private String tekst;
    private Consumer<ButtonElement> gekozen;

    public ButtonElement(String tekst, Consumer<ButtonElement> gekozen) {
        this.tekst = tekst;
        this.gekozen = gekozen;
    }

    @Override
    public void geefWeer() {
        System.out.println(tekst);
    }

    @Override
    public void verwerkInput(String input) {
        gekozen.accept(this);
    }
}
