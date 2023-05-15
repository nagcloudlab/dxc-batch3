package com.example.entity.com.example;

import com.example.entity.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsApi_Ex {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // display Low-caloric ( < 400) dish names in sorted by calorie
        System.out.println(
                getLocalCaloricDishNamesV3(menu)
        );


    }

    //--------------------------------------------------------------
    // Internal Iteration => streams api
    //--------------------------------------------------------------

    private static List<String> getLocalCaloricDishNamesV3(List<Dish> dishList) {
        return dishList
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


    private static List<String> getLocalCaloricDishNamesV2(List<Dish> dishList) {
        return dishList
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted((d1,d2)->Integer.compare(d1.getCalories(), d2.getCalories()))
                .map(d-> d.getName())
                .collect(Collectors.toList());
    }


    //--------------------------------------------------------------
    // External iteration + partial code in imperative style
    // No good for concurrent processing
    //--------------------------------------------------------------
    private static List<String> getLocalCaloricDishNamesV1(List<Dish> dishList) {
        // filtering low caloric dishes into new list
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishList) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        // sorting low caloric dishes
        lowCaloricDishes.sort(( d1,  d2) ->Integer.compare(d1.getCalories(), d2.getCalories()));
        // extracting dish names into new list
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;
    }


}
