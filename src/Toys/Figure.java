package Toys;

/**
 * Class to create a figure, extends toy
 * @author Emilio
 * @author Pasha
 */
public class Figure extends Toy {
	
	private char classification;
	private String type = "figure";
	
	/**
	 * Constructor for Figure
	 * @param serial number of toy
	 * @param name of toy
	 * @param brand of toy
	 * @param price of toy
	 * @param available in inventory
	 * @param ageApp, appropriate age for board game 
	 * @param classification of figure
	 */
	public Figure(String serial, String name, String brand, double price, int available, int ageApp, char classification) {
		super(serial, name, brand, price, available, ageApp);
		this.classification = classification;
	}

	/**
	 * Getter method to return classification
	 * @return classification of toy
	 */
	public char getClassification() {
		return classification;
	}
	
	/**
	 * Method to display toy inventory to the user
	 * @return a string the user can interpret
	 */
	public String toString() {
		return "Category: Figure, Serial Number: " + getSerial() + ", Name: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailable() + 
				", Age Appropiate: +" + getAgeApp() + ", Classification: " + classification; 
	}
	
	/**
	 * Method to format to text file
	 * @return proper string format to write to file
	 */
	public String formatToInventory() {
		return getSerial() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailable() + ";" + getAgeApp() + ";" + classification;
	}

	/**
	 * Getter method to return type of toy
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
}
