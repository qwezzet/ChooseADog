package com.example.myproject;

public class State {

    private String id;
    private String filtid;
    private String poroda;
    private String secondporoda;
    private String description;
    private int imagedog;

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

    public void setSecondporoda(String secondporoda) {
        this.secondporoda = secondporoda;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagedog() {
        return imagedog;
    }

    public void setImagedog(int imagedog) {
        this.imagedog = imagedog;
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

    public void setPoroda(String poroda) {
        this.poroda = poroda;
    }

    public String getFiltid() { return filtid; }

    public void setFiltid(String filtid) { this.filtid = filtid; }
}
