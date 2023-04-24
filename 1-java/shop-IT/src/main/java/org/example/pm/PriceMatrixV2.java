package org.example.pm;

import org.apache.log4j.Logger;

/**
 * author: foo
 */

public class PriceMatrixV2 implements PriceMatrix{

    private static final Logger logger=Logger.getLogger("shop-IT");

    public PriceMatrixV2(){
        logger.info("PriceMatrixV2 com created");
    }

    public double getPrice(String itemCode){
        logger.info("getPrice():"+itemCode);
        return 200.00;
    }

}
