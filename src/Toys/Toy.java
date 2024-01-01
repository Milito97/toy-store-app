package Toys;


/**
 * This is the super class which all toys will extend from
 * @author Emilio
 *
 */
public abstract class Toy{
	
	private String serial ="";
	private String name ="";
	private String brand ="";
	private double price;
	private int available;
	private int ageApp;
	
	/**
	 * Toy constructor which will create a toy object
	 * @param serial, serial number of toy
	 * @param name, name of toy
	 * @param brand, brand of toy
	 * @param price, price of toy
	 * @param available, how many are in stock 
	 * @param ageApp, appropriate age for toy
	 */
	public Toy(String serial, String name, String brand, double price, int available, int ageApp) {
		this.serial = serial;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.available = available;
		this.ageApp = ageApp;
	}
	
	/**
	 * Getter method for serial number
	 * @return the serial number
	 */
	public  String getSerial() {
		return serial;
	}

	/**
	 * Getter method for Name of toy
	 * @return the name of the toy
	 */
	public  String getName() {
		return name;
	}

	/**
	 * Getter method for brand
	 * @return the brand of toy
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Getter method for the price of the toy
	 * @return the price of the toy
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Getter method for current inventory of Toy
	 * @return how many toys there are
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Setter Method for toy in inventory
	 * @param available number of toys in inventory
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Getter method for age appropriate
	 * @return age appropriate
	 */
	public int getAgeApp() {
		return ageApp;
	}
	
	/**
	 * Abstract method that all toys will have to implement
	 * to get the type of toy
	 * @return
	 */
	public abstract String getType();
	
	/**
	 * Abstract method for proper format to text file
	 * @return proper format to write to file
	 */
	public abstract String formatToInventory();
	
	
}





	
	
