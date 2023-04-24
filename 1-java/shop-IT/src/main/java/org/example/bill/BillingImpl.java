package org.example.bill;

import org.apache.log4j.Logger;
import org.example.pm.PriceMatrix;

import java.util.List;

public class BillingImpl implements Billing {

    private static final Logger logger=Logger.getLogger("shop-IT");

    private final PriceMatrix priceMatrix;

    public BillingImpl(PriceMatrix priceMatrix){
        this.priceMatrix=priceMatrix;
        logger.info("BillingImpl comp created");
    }

    public double getTotalPrice(List<String> cart){
        logger.info("getTotalPrice()");
        //PriceMatrixV1 priceMatrixV1=new PriceMatrixV1();
        double total = 0;
        for(String itemCode : cart){
            double price = priceMatrix.getPrice(itemCode);
            total += price;
        }
        return total;
    }

}
