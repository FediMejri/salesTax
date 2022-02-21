package v1.entities;

public class Item {
	private String description;
	private int quantity;
	private Double price;
	private Double priceAfterTax;
	private Double taxApplied;
	
	public Item(String desc, int qty, Double price ) {
		this.description= desc;
		this.quantity= qty;
		this.price= price;
		this.priceAfterTax= price;
		this.taxApplied= (double) 0;
	}

	/**  @return the description */
	
	public String getDescription() {
		return description;
	}

	/** @return the quantity */
	public int getQuantity() {
		return quantity;
	}

	/**  @return the price */
	public Double getPrice() {
		return price;
	}

	/** @return the priceAfterTax  */
	public Double getpriceAfterTax() {
		return priceAfterTax;
	}
	
	/**  @return the taxApplied */
	public Double getTaxApplied() {
		return taxApplied;
	}
	
	/** @Set the priceAfterTax */
	private void setPriceAfterTax(Double price) {
		this.priceAfterTax= price;
	}
	
	/** @Set the taxApplied */
	private void setTaxApplied(Double amount) {
		this.taxApplied = amount;
	}
	
	/** Apply the tax on the Item  */
	public void ApplyTax(Double taxRate) {
		double additionalCost = roundOff(this.getPrice() * taxRate * this.getQuantity());
		this.setPriceAfterTax(additionalCost+ (this.getPrice()*this.getQuantity()));
		this.setTaxApplied(additionalCost);
	}

	/** Takes the nearest 0.05 to the double */
	private Double roundOff(Double amount){
        return Math.ceil((amount * 20.00)) / 20.00;
    }
}
