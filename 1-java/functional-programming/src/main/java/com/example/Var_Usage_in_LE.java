package com.example;

import java.util.function.Consumer;

class Abc{
    static int staVar=13;
    int insVar=12;
    public Consumer<String> getConsumer() {
        final int localVar=10;
        return str->{
            System.out.println(str);
            System.out.println(localVar);
            System.out.println(insVar);
            System.out.println(staVar);
        };
    }
}

public class Var_Usage_in_LE {
    public static void main(String[] args) {

        Consumer<String> consumer= new Abc().getConsumer();
        consumer.accept("hello");

    }
}
