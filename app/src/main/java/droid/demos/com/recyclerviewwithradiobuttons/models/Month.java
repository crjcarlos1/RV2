package droid.demos.com.recyclerviewwithradiobuttons.models;

public class Month {

    private String name;
    private boolean selected;

    public Month(String title, boolean selected) {
        this.name = title;
        this.selected = selected;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String mTitle) {
        this.name = mTitle;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean mBoolean) {
        this.selected = mBoolean;
    }

}
