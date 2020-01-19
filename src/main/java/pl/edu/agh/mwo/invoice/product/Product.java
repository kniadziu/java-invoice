package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal; //bigDecimal stosuje się do obliczeń pieniędzy z dokładnością, dodawane nie działa na bigdecimal, wymaga innych operacji

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		//walidujemy czy parametry sa poprawne wg deomeny, gdzie sa implementowane, czy moga byc null
		if (name==null){
			throw new IllegalArgumentException("Nazwa produktu nie może być null.");
		}
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return this.price.add(this.taxPercent.multiply(this.price));
	}
}
