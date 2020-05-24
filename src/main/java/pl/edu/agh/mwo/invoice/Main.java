package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.ExciseProduct;
import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.OtherProduct;

public class Main {
    public static void main(String[] args) {
        Invoice fv1 = new Invoice();
        Integer k = fv1.getNumber();
        fv1.addProduct(new OtherProduct("Jablka", new BigDecimal("5.5")),1);
        fv1.addProduct(new OtherProduct("Gruszki", new BigDecimal("5.8")),4);
        fv1.addProduct(new ExciseProduct("pudełko", new BigDecimal("5.0")),2);
        fv1.print();
    }
}
