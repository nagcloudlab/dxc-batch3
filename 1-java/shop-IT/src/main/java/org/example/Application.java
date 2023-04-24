package org.example;

import org.example.bill.Billing;
import org.example.bill.BillingImpl;
import org.example.pm.PriceMatrix;
import org.example.pm.PriceMatrixV1;
import org.example.pm.PriceMatrixV2;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // init / boot phase
        PriceMatrix priceMatrixV1=new PriceMatrixV1();
        PriceMatrix priceMatrixV2=new PriceMatrixV2();
        Billing billing = new BillingImpl(priceMatrixV2);


        // use

        List<String> cart1 = List.of("123", "456", "789");
        double total1 = billing.getTotalPrice(cart1);
        System.out.println(total1);

        List<String> cart2 = List.of("123", "456");
        double total2 = billing.getTotalPrice(cart2);
        System.out.println(total2);

        System.out.println("Happy shopping");

    }
}
