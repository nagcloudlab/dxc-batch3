package com.example;

import com.example.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class InventoryApp {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );


        System.out.println(
//                filterApples(inventory, apple ->apple.getColor().equals("green"))
//                filterApples(inventory, apple -> apple.getColor().equals("red"))
//                filterApples(inventory, apple -> apple.getWeight() > 100)
//                filterApples(inventory, apple -> apple.getWeight() > 100 && apple.getColor().equals("green"))
        );


    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> obj) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (obj.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}



/*

    in java , first-class citizens

    - values/primitives
     int a=12
    - objects
    String ref=new String()

    - function ( From in Java -8 , Lambda expression / Arrow Function / Function )

    Predicate greenApplePredicate =  (Apple apple) -> {
            return apple.getColor().equals("green");
        }


 */