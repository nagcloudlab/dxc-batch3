package com.example;

import java.util.ArrayList;
import java.util.List;

// Third party's
class FoodUtilLib {
    public boolean isNonVeg(String foodItem) {
        // check food dictionary for non-veg items
        return foodItem.startsWith("non-");
    }
}


public class MethodReference_Ex {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("veg");
        menu.add("veg");
        menu.add("non-veg");
        menu.add("veg");
        menu.add("non-veg");


        //menu.removeIf(foodItem -> foodItem.startsWith("non-"));
        //menu.removeIf(foodItem->{return FoodUtilLib.isNonVeg(foodItem);});

        FoodUtilLib foodUtilLib=new FoodUtilLib();
        menu.removeIf(foodUtilLib::isNonVeg); // Method reference ==> using existing methods as functions

        System.out.println(menu);

    }
}
