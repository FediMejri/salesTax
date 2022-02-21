package v1.entities;

public class Tax {
	private String type;
	private Double rate;
	
	public Tax(String type) {
		this.type = type;
		this.rate = getRate(type);
	}

	/**
	 * Getter for the rate property.
	 * It is static to be called without instantiating from the tax
	 * to avoid creating many objects in the memory
	 */
	public static Double getRate(String type) {
		Double rate = 0.00;
		if(type.length()!=0) {
			switch(type){
			case "basic":
				rate = 0.10;
				break;
			case "Import":
				rate= 0.05;
				break;
			case "basicImport":
				rate = 0.15;
				break;
			default:
				return rate;
			}
		}else {
			return rate;
		}
		return rate;
	}
	
	
}
