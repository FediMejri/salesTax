package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import v1.entities.Item;

public class ItemTest{
	private Item item;
	private String description;
	private int quantity;
	private Double price;
	
	@Before
	public void setUp() throws Exception{
		item = new Item("imported bottle of perfume", 1, 47.50);
		description = "imported bottle of perfume";
		quantity= 1;
		price = 47.50;
	}
	
	@Test
	public void getQuantityShouldReturnQuantity() {
		assertEquals(quantity,item.getQuantity());
	}
	
	@Test
	public void getDescriptionShouldReturnDescription() {
		assertEquals(description, item.getDescription());
	}
	
	@Test
	public void getPriceShouldReturnPrice() {
		assertEquals(price, item.getPrice());
	}
}
