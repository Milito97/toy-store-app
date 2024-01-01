package Toys;

public class Animal extends Toy {
	
	private String material="";
	private char size;
	private String type = "animal";
	
	/**
	 * Constructor for Animal
	 * @param serial number of toy
	 * @param name of toy
	 * @param brand of toy
	 * @param price of toy
	 * @param available in inventory
	 * @param ageApp, appropriate age for board game
	 * @param material the toy is made from
	 * @param size of the toy 
	 */
	public Animal(String serial, String name, String brand, double price, int available, int ageApp, String material, char size) {
		super(serial, name, brand, price, available, ageApp);
		this.material = material;
		this.size = size;
	}

	/**
	 * Getter method to return material of the toy
	 * @return the material the toy is made from
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Getter method to return the size of the toy
	 * @return the size of the toy
	 */
	public char getSize() {
		return size;
	}

	/**
	 * Method to display toy inventory to the user
	 * @return a string the user can interpret
	 */
	public String toString() {
		return "Category: Animal, Serial Number: " + getSerial() + ", Name: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailable() + 
				", Age Appropiate: +" + getAgeApp() + ", Material: " + material + ", Size: " + size; 
	}
	
	/**
	 * Method to format to text file
	 * @return proper string format to write to file
	 */
	public String formatToInventory() {
		return getSerial() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailable() + ";" + getAgeApp() + ";" + material + ";" + size;
	}

	/**
	 * Getter method to return type of toy
	 * @return type
	 */
	public String getType() {
		return type;
	}

	
}