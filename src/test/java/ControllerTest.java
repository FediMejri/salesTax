import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

import v1.entities.Item;
import v1.entities.Receipt;
import v1.services.TaxApplier;



public class ControllerTest{
	private ArrayList<Item> testSet = new ArrayList<Item>();
	private Double salesTaxes;
	private Double total;
	private Double desiredSalesTaxes;
	private Double desiredTotal;
	
	@Test
	public void testFirstReceipt() {
		/** Initialize first testing set */
		testSet.add(new Item("book", 1, 12.49));
		testSet.add(new Item("music CD", 1, 14.99));
		testSet.add(new Item("chocolate bar", 1, 0.85));
		
		TaxApplier taxApplier = new TaxApplier(testSet);
		Receipt receipt = new Receipt(taxApplier.getPurchaseWithTax());
		
		salesTaxes = (double) Math.round(receipt.getSalesTax() * 200) / 200;
		total = (double) Math.round(receipt.getTotal() * 200) / 200 ;
		
		desiredSalesTaxes = 1.5;
		desiredTotal = 29.83;
		
		assertEquals(desiredSalesTaxes, salesTaxes);
		assertEquals(desiredTotal, total);
	}
	
	@Test
	public void testSecondReceipt() {
		/** Initialize first testing set */
		testSet.add(new Item("imported box of chocolates", 1, 10.00));
		testSet.add(new Item("imported bottle of perfume", 1, 47.50));
		
		TaxApplier taxApplier = new TaxApplier(testSet);
		Receipt receipt = new Receipt(taxApplier.getPurchaseWithTax());
		
		salesTaxes = (double) Math.round(receipt.getSalesTax() * 200) / 200;
		total = (double) Math.round(receipt.getTotal() * 200) / 200 ;
		
		desiredSalesTaxes = 7.65;
		desiredTotal = 65.15;
		
		assertEquals(desiredSalesTaxes, salesTaxes);
		assertEquals(desiredTotal, total);
	}
	
	@Test
	public void testThirdReceipt() {
		/** Initialize first testing set */
		testSet.add(new Item("imported bottle of perfume", 1, 27.99));
		testSet.add(new Item("bottle of perfume", 1, 18.99));
		testSet.add(new Item("packet of headache pills", 1, 9.75));
		testSet.add(new Item("box of imported chocolates", 1, 11.25));
		
		TaxApplier taxApplier = new TaxApplier(testSet);
		Receipt receipt = new Receipt(taxApplier.getPurchaseWithTax());
		
		salesTaxes = (double) Math.round(receipt.getSalesTax() * 200) / 200;
		total = (double) Math.round(receipt.getTotal() * 200) / 200 ;
		
		desiredSalesTaxes = 6.70;
		desiredTotal = 74.68;
		
		assertEquals(desiredSalesTaxes, salesTaxes);
		assertEquals(desiredTotal, total);
	}
}
