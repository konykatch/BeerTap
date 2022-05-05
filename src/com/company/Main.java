package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean systemCondition = true;

        fridge fridge = new fridge();
        fridge.addingBeers();
        while(systemCondition){
            System.out.println("1. Lista piw");
            System.out.println("2. Dodaj piwo");
            System.out.println("3. Wyświetl style");
            System.out.println("4. Szukaj");
            System.out.println("5. Wyjście");
            int userChoice = scanner.nextInt();



            switch (userChoice){
                case 1 -> fridge.displayBeers();
                case 2 -> fridge.addBeer();
                case 3 -> fridge.displayStyle();
                case 4 -> fridge.searching();
                case 6 -> fridge.addingBeers();
                case 5 -> systemCondition = false;
            }
        }


    }
}
