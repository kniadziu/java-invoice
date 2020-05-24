package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class OtherProduct extends Product {
    public OtherProduct(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }
}
