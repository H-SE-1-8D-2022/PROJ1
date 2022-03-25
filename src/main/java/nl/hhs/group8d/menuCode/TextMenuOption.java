package nl.hhs.group8d.menuCode;

public class TextMenuOption implements iMenuOption {

    private String title;

    @Override
    public String getTitle() {
        return title;
    }

    public TextMenuOption(String title){
        this.title = title;
    }
}
