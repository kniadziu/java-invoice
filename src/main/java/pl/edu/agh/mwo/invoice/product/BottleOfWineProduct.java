package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

//
public class BottleOfWineProduct extends Product{

    public BottleOfWineProduct(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }
}
