package com.example.myproject;

public class State {

    private String id;
    private final String filtid;
    private final String poroda;
    private final String secondporoda;
    private final String description;
    private final int imagedog;

    public State(String id, String fid, String poroda, String secondporoda, String description, int imagedog) {

        this.id = id;
        this.filtid = fid;
        this.poroda = poroda;
        this.secondporoda = secondporoda;
        this.description = description;
        this.imagedog = imagedog;
    }


    public String getSecondporoda() {
        return secondporoda;
    }

    public String getDescription() {
        return description;
    }

    public int getImagedog() {
        return imagedog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoroda() {
        return poroda;
    }

    public String getFiltid() { return filtid; }

}
