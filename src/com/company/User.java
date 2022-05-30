package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static String username;
    private static String password;
    private String favBeer;
    private ArrayList<Beers> beers;

    public User(String username, String password, String favBeer, ArrayList beers) {
        this.username = username;
        this.password = password;
        this.favBeer = favBeer;
        this.beers = beers;
    }


    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }




    public static void login(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Podaj login");
            String login = scanner.nextLine();
            System.out.println("Podaj hasło");
            String password = scanner.nextLine();
            if(!getUsername().equals(login)||!getPassword().equals(password)){
                System.out.println("Błędne hasło lub login");
            }else{
                System.out.println("Logowanie poprawne");
                mainMenu();
            }
        }
    }
    public static void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        System.out.println("Jeśli chcesz wygenerować hasło, wciśnij 1");
        String password = scanner.nextLine();
        if(password.equals("1")){
            password = passwordGenerator();
            System.out.println("Twoje hasło to "+password);
        }
        System.out.println("Podaj swoje ulubiony styl:");
        String style = scanner.nextLine();

        User user = new User(login,password,style,new ArrayList<>());

        mainMenu();

    }

    public static String passwordGenerator() {
        String bigLetters = "ABCDEFGHIJKLMNOPQRSTWYZ";
        String smallLetters = bigLetters.toLowerCase();
        String nums = "0123456789";
        String[] chars = (bigLetters+smallLetters+nums).split("");
        StringBuilder password = new StringBuilder();
        for(int i=0;i<10;i++){
            password.append(chars[(int) (Math.random() * 49 + 1)]);
        }

        return password.toString();
    }

    public static void mainMenu(){
        fridge fridge = new fridge();
        Scanner scanner = new Scanner(System.in);
        boolean systemCondition = true;
        System.out.println("-----------------");
        System.out.println("Witaj "+ getUsername());
        while(systemCondition){
            System.out.println("-----------------");
            System.out.println("1. Lista piw");
            System.out.println("2. Dodaj piwo");
            System.out.println("3. Wyświetl style");
            System.out.println("4. Szukaj");
            System.out.println("5. Wyjście");
            System.out.println("-----------------");
            try {
                String userChoice = scanner.nextLine();

                switch (Integer.parseInt(userChoice)) {
                    case 1 -> fridge.displayBeers();
                    case 2 -> fridge.addBeer();
                    case 3 -> fridge.displayStyle();
                    case 4 -> fridge.searching();
                    case 6 -> fridge.addingBeers();
                    case 5 -> systemCondition = false;
                }
            }catch(Exception e){
                System.out.println("Podaj liczbe 1-5");
            }

        }
    }

}
