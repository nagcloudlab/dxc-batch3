package com.example.model;

import com.example.model.com.example.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
