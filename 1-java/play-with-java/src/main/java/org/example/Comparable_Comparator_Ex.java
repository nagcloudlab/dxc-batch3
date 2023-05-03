package org.example;

import org.example.model.Product;

import java.util.*;
import java.util.Collection;
import java.util.List;

public class Comparable_Comparator_Ex {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
//        Set<Product> products = new TreeSet<>(new ByPrice());
        products.add(new Product("Product-1", 100, 10, ""));
        products.add(new Product("Product-2", 800, 30, ""));
        products.add(new Product("Product-4", 500, 10, ""));
        products.add(new Product("Product-3", 700, 40, ""));

//        Collections.sort(products); // sort by name
//        Collections.sort(products,new ByPrice()); // sort by price
//        display(products);

    }

    private static void display(Collection<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

}

class ByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}