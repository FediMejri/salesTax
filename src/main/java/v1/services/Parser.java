package v1.services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import v1.entities.Item;

/**
 This is a service to parse the user Input (file).
 This service returns back the purchase of the Items.
 */
public class Parser {
	private ArrayList<Item> purchase;
	
	public Parser(String file) {
		this.purchase = this.parseFile(file);
	}

	/** Parse the file and return the purchase list */
	private ArrayList<Item> parseFile(String file) {
		try {
			ArrayList<Item> parsedPurchase = new ArrayList<Item>();
			String line;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line= br.readLine()) != null) {
				int quantity = this.parseQuantity(line);
				String description = this.parseDescription(line);
				Double price = this.parsePrice(line);
				parsedPurchase.add(new Item(description, quantity, price));
			}
			return parsedPurchase;
		} catch (FileNotFoundException fileError) {
			fileError.printStackTrace();
		} catch (IOException ioError) {
			ioError.printStackTrace();
		}
		return null;
		
	}
	
	/** Parse the Item quantity */
	private int parseQuantity(String line) {
		Matcher quantity = Pattern.compile("\\d+").matcher(line);
		quantity.find();
		return Integer.parseInt(quantity.group(0));
	}
	
	/** Parse the item's description */
	private String parseDescription(String line) {
		Matcher description = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)").matcher(line);
		description.find();
		return description.group(0);
	}
	
	/** Parse the item's price */
	private Double parsePrice(String line) {
		Matcher price = Pattern.compile("\\d+.\\d+$").matcher(line);
		price.find();
		return Double.parseDouble(price.group(0));
	}
	
	/**
	 * @return the purchase
	 */
	public ArrayList<Item> getPurchase() {
		return purchase;
	}
	
}
