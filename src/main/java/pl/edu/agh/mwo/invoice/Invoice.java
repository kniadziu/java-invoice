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
		//jesli dodajesz ten sam produkt do fv to zwieksz liczbe pozycji
		if (products.containsKey(product)) {
			products.put(product, products.get(product) + quantity);
		} else {
			products.put(product, quantity);
		}
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
		int lp=0;
		System.out.println("Faktura  nr: " + getNumber());
		System.out.println("-------------------------------------------------");
		System.out.printf("%2s | %-20s | %5s | %10s |", "Lp.","Nazwa produktu", "Ilość" , "Cena  ");
		System.out.println("\n-------------------------------------------------");
		for (Product product : products.keySet()){
			lp++;
			System.out.printf(" %2s | %-20s | %5s | %10s |\n",lp, product. getName(),  products.get(product) , product.getPriceWithTax());
		}
		System.out.println("-------------------------------------------------\n");

	}
}
