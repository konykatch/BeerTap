package com.company;

import java.util.*;

public class fridge {
    private List<Beers> beers = new ArrayList<>();
    private Set<String> styleOf = new HashSet<>();
    private List<String> styleOfBeers= new ArrayList<>();
    private HashMap<Integer,Beers> bitternessOfBeer = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addingBeers() {
        beers.add(new Beers("Pinta","Kwas Epsilon","Sour",1,true));
        beers.add(new Beers("Pinta","Atak Chmielu","IPA",7,false));
        beers.add(new Beers("Trzech Kumpli","Rusty","Stout",3,false));
        beers.add(new Beers("Funky Fluid","Where are my googles?","Russian Imperial Stout",2,true));
        beers.add(new Beers("Moczymorda","Light, Sour, Delicious","Sour",1,true));
        beers.add(new Beers("Trzech Kumpli","Califia","West Coast IPA",8,false));
        beers.add(new Beers("Artezan","Friends Reminder #2","New England IPA",6,false));
        beers.add(new Beers("Fortuna","ArcyIPA","IPA",6,false));
    }

    public void addBeer(){
        System.out.println("Podaj browar:");
        String brewery = scanner.nextLine();

        System.out.println("Podaj nazwę:");
        String name = scanner.nextLine();

        System.out.println("Podaj styl");
        String style = scanner.nextLine();

        System.out.println("Stopień goryczki:");
        int bitterness =Integer.parseInt(scanner.nextLine());

        System.out.println("Czy jest z laktozą?(Y/N)");
        String choice = scanner.nextLine().toLowerCase();
        boolean withLactose;
        if (choice.equals("y")){
            withLactose = true;
        }else{
            withLactose = false;
        }


        Beers beer = new Beers(brewery,name,style,bitterness,withLactose);

        styleOf.add(style);
        bitternessOfBeer.put(bitterness,beer);
        this.beers.add(beer);
    }

    public void displayBeers() {
        for(Beers i:beers){
            i.displayBeerInformation();
        }
    }
    public void displayStyle(){
        for(String i : styleOf){
            System.out.println(i);
        }
    }
    public void displayBeerByBitterness(){
        Integer search = Integer.parseInt(scanner.nextLine());
        Beers beers = bitternessOfBeer.get(search);

        beers.displayBeerInformation();
    }

    public void searching(){
        boolean search = true;
        while(search) {
            System.out.println("1.Szukaj po browarze");
            System.out.println("2. Szukaj po stylach");
            System.out.println("3. Wyjście");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> searchByBrewery();
                case 2 -> searchByStyle();
                case 3 -> search = false;
            }
        }
    }

    public void searchByBrewery(){
        System.out.println("Szukaj:");
        String choice = scanner.next().toLowerCase();
            beers.stream()
                    .filter(beers -> beers.getBrewery().toLowerCase().contains(choice))
                    .forEach(Beers::displayBeerInformation);
    }

    public void searchByStyle(){
        System.out.println("Szukaj:");
        String choice = scanner.next();
        beers.stream()
                .filter(beers -> beers.getStyle().toLowerCase().contains(choice))
                .forEach(Beers::displayBeerInformation);
    }


}
