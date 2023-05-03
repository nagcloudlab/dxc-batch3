package com.example;

import java.util.function.*;

public class FunctionalInterfaces_Ex {
    public static void main(String[] args) {

        Function<String, Integer> function = s -> {
            return 10 + s.length();
        };

        Predicate<String> predicate = s -> {
            return true;
        };

        Consumer<String> consumer = s -> {
        };

        Supplier<String> supplier = () -> {
            return "hello";
        };

        UnaryOperator<String> unaryOperator=str->{
            return "hello";
        };

        //------------------------------------------------------------------

//        BiFunction<Integer,Integer,Integer> biFunction =(n1,n2)->{
//            return n1+n2;
//        };

        IntBinaryOperator intBinaryOperator= (n1,n2)->{
            return n1+n2;
        };

        int result=intBinaryOperator.applyAsInt(12,13);
        System.out.println(result);
        //-------------------------------------------------------------------



    }
}
