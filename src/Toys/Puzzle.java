package Toys;

/**
 * Class to create a puzzle object from toy
 * @author Emilio
 * @author Pasha
 */
public class Puzzle extends Toy {
	private String puzzleType = "";
	private String type = "puzzle";

	/**
	 * Constructor for Puzzle
	 * @param serial number of toy
	 * @param name of toy
	 * @param brand of toy
	 * @param price of toy
	 * @param available in inventory
	 * @param ageApp, appropriate age for board game
	 * @param type of puzzle
	 */
	public Puzzle(String serial, String name, String brand, double price, int available, int ageApp, String type) {
		super(serial, name, brand, price, available, ageApp);
		this.puzzleType = type;
	}

	/**
	 * Getter method to return type of toy
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method to display toy inventory to the user
	 * @return a string the user can interpret
	 */
	public String toString() {
		return "Category: Puzzle, Serial Number: " + getSerial() + ", Name: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailable() + 
				", Age Appropiate: +" + getAgeApp() + ", Type: " + type; 
	}
	
	/**
	 * Method to format to text file
	 * @return proper string format to write to file
	 */
	public String formatToInventory() {
		return getSerial() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailable() + ";" + getAgeApp() + ";" + type;
	}

	/**
	 * Getter method to return the type of puzzle
	 * @return the type of puzzle
	 */
	public String getPuzzleType() {
		return puzzleType;
	}
	
}
