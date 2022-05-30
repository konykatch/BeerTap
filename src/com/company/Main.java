package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        fridge fridge = new fridge();
        fridge.addingBeers();

        Scanner scanner = new Scanner(System.in);
        User kony = new User("kony","kony420","IPA",new ArrayList<>());
        System.out.println("-----------------");
        System.out.println("1. Logowanie");
        System.out.println("2. Rejestracja");
        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> User.login();
            case 2 -> User.register();
        }


    }
}
