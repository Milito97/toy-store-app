package Toys;

/**
 * This Class is for a toy type board game, it extends toys.
 * @author Emilio
 * @author Pasha
 */
public class Boardgame extends Toy {
	
	private int minPlayers;
	private int maxPlayers;
	private String designers="";
	private String type = "boardgame";
	
	/**
	 * Constructor for a board game
	 * @param serial number of toy
	 * @param name of toy
	 * @param brand of toy
	 * @param price of toy
	 * @param available in inventory
	 * @param ageApp, appropriate age for board game 
	 * @param minPlayers,  minimum of players required
	 * @param maxPlayers, maximum of players required
	 * @param designers of the game
	 */
	public Boardgame(String serial, String name, String brand, double price, int available, int ageApp, int minPlayers, int maxPlayers, String designers) {
		super(serial, name, brand, price, available, ageApp);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
		
	}

	/**
	 * Getter method to return designers
	 * @return designers
	 */
	public String getDesigners() {
		return designers;
	}

	/**
	 * Getter method to get max players
	 * @return max players
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * Getter method to get min players
	 * @return min players 
	 */
	public int getMinPlayers() {
		return minPlayers;
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
		return "Category: BoardGame, Serial Number: " + getSerial() + ", Name: " + getName() + ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailable() + 
				", Age Appropiate: +" + getAgeApp() + ", Number of Players: " + minPlayers + "-" + maxPlayers + ", Designer: " + designers; 
	}
	
	/**
	 * Method to format to text file
	 * @return proper string format to write to file
	 */
	public String formatToInventory() {
		return getSerial() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailable() + ";" + getAgeApp() + ";" + minPlayers + "-" + maxPlayers + ";" + designers;
	}
	
}
