package v1.services;

import java.util.ArrayList;
import java.util.regex.Pattern;

import v1.entities.Item;
import static v1.entities.Tax.getRate;
/**
 * This is a service class, I will not use dependencies injection because I am coding with basic java.
 * This service applies the tax on the Item depending on its type (description)
 */
public class TaxApplier {
	private ArrayList<Item> purchaseWithTax;
	
	public TaxApplier(ArrayList<Item> purchase) {
		ArrayList<Item> list = new ArrayList<Item>();
		for(Item item: purchase) {
			String type="";
			String descr = item.getDescription();
			Pattern exempted = Pattern.compile("book|chocolate|pill");
			Pattern imported = Pattern.compile("import");
			if(!exempted.matcher(descr).find()) {
				type = "basic";
			}
			
			if(imported.matcher(descr).find()) {
				type+= "Import";
			}
			
			item.ApplyTax(getRate(type));
			list.add(item);
		}
		
		this.purchaseWithTax= list;
	}

	/** @return the purchaseWithTax */
	public ArrayList<Item> getPurchaseWithTax() {
		return purchaseWithTax;
	}
}
