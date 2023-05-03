package org.example;

import org.example.util.LinkedList;

public class Collections_Ex {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
