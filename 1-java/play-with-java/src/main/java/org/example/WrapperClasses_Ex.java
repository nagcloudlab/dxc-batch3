package org.example;


/*

    data types

    -> values / primitives
    -> objects

    we should treat values/primitives as objects

        => while storing values in collections/readily available datastructures
        => for serialization

     how ?

     => using wrapper classes


 */

public class WrapperClasses_Ex {
    public static void main(String[] args) {

        int val = 12;
        Integer i = val; // auto boxing
        val = i; // auto unboxing

    }
}
