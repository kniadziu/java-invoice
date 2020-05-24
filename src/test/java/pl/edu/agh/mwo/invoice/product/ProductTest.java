package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import pl.edu.agh.mwo.invoice.product.Product;

public class ProductTest {


	//WINE TEST
	@Test
	public void testBottleOfWinePriceWithTaxAndExcise() {
		Product product = new BottleOfWineProduct("Dwikozy 1999", new BigDecimal("10.0"));

		Assert.assertThat(new BigDecimal("10.0"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("12.30"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

///

	//CANISTER TEST
	@Test
	public void testFuelCanisterPriceWithExcise() {
		Product product = new FuelCanisterProduct("Oil", new BigDecimal("50.0"));

		Assert.assertThat(new BigDecimal("50.0"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("50.0"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}


	@Test
	public void testExciseProductValue() {
		Product product = new ExciseProduct("product 1", new BigDecimal("100.0"));

		Assert.assertThat(new BigDecimal("100.0"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("128.56"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	//Excesive PRODUCT TEST
	@Test
	public void testProductNameIsCorrect() {
		Product product = new OtherProduct("buty", new BigDecimal("100.0"));
		Assert.assertEquals("buty", product.getName());
	}


	@Test
	public void testProductPriceAndTaxWithDefaultTax() {
		Product product = new OtherProduct("Ogorki", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.23"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testProductPriceAndTaxWithDairyProduct() {
		Product product = new DairyProduct("Szarlotka", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.08"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testPriceWithTax() {
		Product product = new DairyProduct("Oscypek", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("108"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullName() {
		new OtherProduct(null, new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithEmptyName() {
		new TaxFreeProduct("", new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullPrice() {
		new DairyProduct("Banany", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNegativePrice() {
		new TaxFreeProduct("Mandarynki", new BigDecimal("-1.00"));
	}
}
