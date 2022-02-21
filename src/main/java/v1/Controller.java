package v1;

import java.text.DecimalFormat;

import v1.entities.Item;
import v1.entities.Receipt;
import v1.services.Parser;
import v1.services.TaxApplier;

public class Controller {

	public static void main(String[] args) {
		
		/** Set Input container */
		String[] testFiles = {
				"src/main/resources/Input/testInput/testInput1.txt",
				"src/main/resources/Input/testInput/testInput2.txt",
				"src/main/resources/Input/testInput/testInput3.txt"
		};
		
		/** Controller Core */
		for(String file : testFiles) {
			
			Parser fileParser = new Parser(file);
			TaxApplier taxApplier = new TaxApplier(fileParser.getPurchase());
			Receipt receipt = new Receipt(taxApplier.getPurchaseWithTax());
			
			/** Console Output */
			for (Item item: receipt.getfinalPurchase()) {
				System.out.println(item.getQuantity() + " " + item.getDescription() + ": " + new DecimalFormat("##.##").format(item.getpriceAfterTax()));
			}
			System.out.println("Sales Taxes: " + new DecimalFormat("##.##").format(receipt.getSalesTax()) + "\n" + "Total: " + new DecimalFormat("##.##").format(receipt.getTotal()) + "\n");
		}

	}

}
