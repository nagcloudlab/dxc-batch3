package org.example.pm;

import org.apache.log4j.Logger;

/**
 * author: foo
 */

public class PriceMatrixV1 implements  PriceMatrix{

    private static final Logger logger=Logger.getLogger("shop-IT");

    public PriceMatrixV1(){
        logger.info("PriceMatrixV1 com created");
    }

    public double getPrice(String itemCode){
        logger.info("getPrice():"+itemCode);
        return 100.00;
    }

}
