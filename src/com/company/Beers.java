package com.company;


public class Beers {
    private String brewery;
    private String name;
    private String style;
    private int bitterness;
    private boolean withLactose;

    public Beers(String brewery, String name, String style, int bitterness, boolean withLactose) {
        this.brewery = brewery;
        this.name = name;
        this.style = style;
        this.bitterness = bitterness;
        this.withLactose = withLactose;
    }

    public String getBrewery() {
        return brewery;
    }


    public String getStyle() {
        return style;
    }

    public void displayBeerInformation(){
        {
            String isWithLactose = withLactose ? "Tak" : "Nie";
            System.out.println("Browar: " + brewery + " | Nazwa piwa: " + name + " | Styl: " + style
                    + " | Goryczka: " + bitterness + " | Czy jest z laktozą? " + isWithLactose);
        }
    }
}
