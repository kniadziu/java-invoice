package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class ExciseProduct extends Product{
    public ExciseProduct(String name, BigDecimal price, BigDecimal tax) {
        super(name, price,  tax);
    }
}
