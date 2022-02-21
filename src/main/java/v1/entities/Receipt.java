package v1.entities;

import java.util.ArrayList;

public class Receipt {
	private ArrayList<Item> finalPurchase;
	private Double salesTax;
	private Double total;
	
	public Receipt(ArrayList<Item> finalPurchase) {
		double salesTax = (double) 0;
		double total = (double) 0;
		
		this.finalPurchase = finalPurchase;
		
		/** Set the total and the salesTax properties */
		for(int counter= 0; counter< finalPurchase.size(); counter++) {
			Item item= finalPurchase.get(counter);
			salesTax+= item.getTaxApplied();
			total+= item.getpriceAfterTax() * item.getQuantity();
		}
		
		this.salesTax= salesTax;
		this.total= total;
	}
	
	/** @return the finalPurchase */
	public ArrayList<Item> getfinalPurchase() {
		return finalPurchase;
	}
	
	/**  @return the salesTax */
	public Double getSalesTax() {
		return salesTax;
	}
	
	/** @return the total */
	public Double getTotal() {
		return total;
	}
	
}
