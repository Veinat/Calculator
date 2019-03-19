package com.veinat.calculated.Converter;

public class Converts {

    private String name;
    private int image;
    private int id;

    public Converts(int id, String name, int image){
        this.id = id;
        this.name=name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }
    public int getImage() {
        return this.image;
    }

    public int getId() {
        return id;
    }
}
