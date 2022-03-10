package nl.hhs.group8d.element;

public class TekstElement implements Element {
    private String tekst;

    public TekstElement(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public void geefWeer() {
        System.out.println(tekst);
    }

    @Override
    public void verwerkInput(String input) {

    }
}
