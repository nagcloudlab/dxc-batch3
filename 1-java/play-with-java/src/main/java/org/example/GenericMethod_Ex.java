package org.example;


class Util{
    public static <T> void display(T s){
        System.out.println(s.getClass().getName());
    }
}


public class GenericMethod_Ex {
    public static void main(String[] args) {

        Util.display("Hello World");
        Util.display(123);

    }
}
