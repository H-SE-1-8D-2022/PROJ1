package nl.hhs.group8d.element;

import java.util.function.Consumer;

public class TekstInputElement implements Element {
    private String tekst;
    private Consumer<String> enterGedrukt;

    public TekstInputElement(String tekst, Consumer<String> enterGedrukt) {
        this.tekst = tekst;
        this.enterGedrukt = enterGedrukt;
    }

    @Override
    public void geefWeer() {
        System.out.print(tekst + " ");
    }

    @Override
    public void verwerkInput(String input) {
        this.enterGedrukt.accept(input);
    }
}
