package com.example.myproject;

public class State {

    private String id;
    private String poroda;
    private String description;
    private int imagedog;

    public State(String id, String poroda,String description,int imagedog) {

        this.id = id;
        this.poroda = poroda;
        this.description = description ;
        this.imagedog = imagedog;
    }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description; }

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
