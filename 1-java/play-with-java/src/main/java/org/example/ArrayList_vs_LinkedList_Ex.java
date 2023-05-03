package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayList_vs_LinkedList_Ex {
    public static void main(String[] args) {

        List<String> list0 = new Vector<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        compare(list0);
        compare(list1);
        compare(list2);
    }

    private static void compare(List<String> list1) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list1.add(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
