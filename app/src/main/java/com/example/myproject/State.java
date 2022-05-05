package com.example.myproject;

public class State {

    private String id;
    private String poroda;
    private int imagedog;

    public State(String id, String poroda, int imagedog) {

        this.id = id;
        this.poroda = poroda;
        this.imagedog = imagedog;
    }

    public int getImagedog() {
        return imagedog;
    }

    public void setImagedog(int imagedog) { this.imagedog = imagedog;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getPoroda() {
        return poroda;
    }

    public void setPoroda(String poroda) { this.poroda = poroda;}
}
