package com.example;


/*
    2 types tasks
    -------------------
    => computational task
    => io task
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread ioThread = new Thread(App::io);
        Thread computationThread = new Thread(App::computation);

        ioThread.start(); // allocate new stack
        computationThread.start();

    }

    private static void computation() {
        for (int i = 0; i<100; i++) {
            System.out.println(i);
        }
    }

    private static void io() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        scanner.close();
    }
}
