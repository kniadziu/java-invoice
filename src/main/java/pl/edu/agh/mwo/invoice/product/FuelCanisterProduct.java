package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanisterProduct extends Product {

    public FuelCanisterProduct(String name, BigDecimal price) {
        super(name, price, BigDecimal.ZERO);
    }
}
