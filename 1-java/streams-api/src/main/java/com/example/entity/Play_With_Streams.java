package com.example.entity;

import java.util.List;

public class Play_With_Streams {

    public static void main(String[] args) {

        List<Dish> menu=Dish.menu;

        boolean isHealthyMenu=
                menu
                        .stream()
                        .noneMatch(d->d.getCalories()>=1000);

    }

}
