package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

	private Map<Product, Integer> products = new HashMap<>();

	private static Integer nextNumber=0;
	private Integer number=++nextNumber; //nr faktury

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	//private Collection<Product> products;

	public void addProduct(Product product) { //konstruktor z nazwa zwraz=ca 1 produkt
		//dodac ify
		this.products.put(product,1);
	}

	public void addProduct(Product product, Integer quantity) { //konstruktor zwraza produkt i jego ilsc
		//walidujemy czy parametry sa poprawne dla quantity =0
		if (quantity <=0){ //sprawdzenie quantity jest zero lub mniejsze
			throw new IllegalArgumentException("Ilośc nie może być zero.");
		}
		
		this.products.put(product,quantity);

	}

	public BigDecimal getNetPrice() {
		BigDecimal sum = BigDecimal.ZERO; //przypisujemy do zmiennej zero
		for  (Product product: this.products.keySet()) {
			Integer quantity = this.products.get(product);
			sum= sum.add(product.getPrice().multiply(new BigDecimal(quantity)));
		}
		return sum;
	}

	public BigDecimal getTax() {
		return this.getGrossPrice().subtract(this.getNetPrice());
	}

	public BigDecimal getGrossPrice() {
		BigDecimal sum = BigDecimal.ZERO; //przypisujemy do zmiennej zero
		for  (Product product: this.products.keySet()) {
			Integer quantity = this.products.get(product);
			sum= sum.add(product.getPriceWithTax().multiply(new BigDecimal(quantity)));
		}
		return sum;
	}

	public void print(){
		System.out.println("Faktura  nr: " + getNumber());
		System.out.println("--------------------------------------------------");

	}
}
