package org.example;

import org.example.model.Product;

import java.util.HashSet;
import java.util.Set;

public class HashTable_Colln_Ex {
    public static void main(String[] args) {

        Product product1=new Product("Product-1", 800, 30, "");
        Product product2=new Product("Product-2", 800, 30, "");
        Product product3=new Product("Product-2", 800, 30, "");


        System.out.println(product2.hashCode());
        System.out.println(product3.hashCode());
        System.out.println(product2.equals(product3));

        Set<Product> products=new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        System.out.println(products.size());

    }
}
