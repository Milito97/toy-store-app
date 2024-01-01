package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Toys.Animal;
import Toys.Boardgame;
import Toys.Figure;
import Toys.Puzzle;
import Toys.Toy;
import exceptions.ExceptionsClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class SampleController {
	
	private final String FILE_PATH = "res/toys.txt";
	public ArrayList<Toy> toys;
	private String toySearched;
	int availableInventory;
	char serialOfToy;
	String typeOfToy;
	String serial = "";
	String name = "";
	String brand = "";
	double price;
	int count;
	int age;
	private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Animal","Boardgame", "Figure", "Puzzle");
		
	
	/**
	 * Main controller for our toyfinder
	 */
	
	
	@FXML void initialize() {
		/**
		 * Initialize the dropdown list and the togglebutton/groups and radio toggle to highlight the text label
		 * 
		 */
		choicebox.setItems(choiceBoxList);
		choicebox.setValue(null);		
		ToggleButton tb1 = radioBttnSN;
		ToggleButton tb2 = radioBttnName;
		ToggleButton tb3 = radioBttnType;
		ToggleGroup group = new ToggleGroup();
	    tb1.setToggleGroup(group);
	    tb2.setToggleGroup(group);
	    tb3.setToggleGroup(group);
	    
	    

		tb1.selectedProperty().addListener(((observable, oldValue, newValue) -> {
	    	tb1.setOnAction(e->serial_label.setTextFill(Color.RED));
		}));
		tb2.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			tb2.setOnAction(e->name_label.setTextFill(Color.RED));
		}));
		tb3.selectedProperty().addListener(((observable, oldValue, newValue) -> {
			tb3.setOnAction(e->type_label.setTextFill(Color.RED));
		}));

		
	}
	
	
	/**
	 * Out Javafx buttons, fields and display containers to be assigned through fxml
	 * 
	 */
	
	@FXML
	private TextField serial_field_search;
	@FXML
	private TextField name_field_search;
	@FXML
	private TextField type_field_search;
	@FXML
	private Button button_search;
	@FXML
	private Button button_clear;
	@FXML
	private Button button_buy;
	@FXML
	private TextField serial_field;
	@FXML
	private TextField name_field;
	@FXML
	private TextField brand_field;
	@FXML
	private TextField price_field;
	@FXML
	private TextField available_field;
	@FXML
	private TextField ageApp_field;
	@FXML
	private Button button_add;
	@FXML
	private TextField classification_field;
	@FXML
	private TextField material_field;
	@FXML
	private TextField size_field;
	@FXML
	private TextField type_field;
	@FXML
	private TextField minPlayers_field;
	@FXML
	private TextField maxPlayers_field;
	@FXML
	private TextField designers_field;
	@FXML
	private TextField serial_remove;
	@FXML
	private Button button_remove;
	@FXML
	private RadioButton radioBttnSN;
	@FXML
	private RadioButton radioBttnName;
	@FXML
	private RadioButton radioBttnType;
	@FXML
	private ListView <Toy> listViewHome;
	@FXML
	private Button button_searchRemove;
	@FXML
	private ListView <Toy> listViewRemove;
	@FXML
	private ChoiceBox<String> choicebox;
    @FXML
    private Label name_label;
    @FXML
    private Label type_label;
    @FXML
    private Label serial_label;
    
    
  
	/**
	 * Constructor to create the array of toys
	 */
	public SampleController() {
		toys = new ArrayList<>();
		try {
			loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to load the array list according to what is in the text file
	 * loops through every line in the text file and creates a toy according to the conditions
	 * @throws Exception
	 */
	public void loadData() throws Exception {
		File inventory = new File(FILE_PATH);
		String currentLine;
		String [] splittedLine;
		char typeOfToy;
		
		
		 
		if(inventory.exists()) {
			Scanner fileReader = new Scanner(inventory);
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();

				splittedLine = currentLine.split(";");
				typeOfToy = splittedLine[0].charAt(0);

				//Creates a figure//
				if (typeOfToy == '0' || typeOfToy == '1') {
					
					Figure f = new Figure(splittedLine[0], splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].charAt(0));
					toys.add(f);
					
					
				//Creates an animal//	
				} else if (typeOfToy == '2' || typeOfToy == '3') {
					
					Animal a = new Animal(splittedLine[0], splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6], (splittedLine[7]).charAt(0));
					toys.add(a);
				
				//Creates a puzzle//	
				} else if (typeOfToy == '4' || typeOfToy == '5' || typeOfToy == '6') {
					
					Puzzle p = new Puzzle(splittedLine[0], splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(p);
				//Creates a board game//	
				} else if (typeOfToy == '7' || typeOfToy == '8' || typeOfToy == '9') {
					
					Boardgame b = new Boardgame(splittedLine[0], splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6].charAt(0), splittedLine[6].charAt(2), splittedLine[7]);
					toys.add(b);
					
				}

			}
			
			fileReader.close();
		}
			
	}
	
	/**
	 * This method "saves the file", it writes the current arraylist to the text file
	 * @throws IOException
	 */
	public void save() throws IOException {
		File toysDataBase = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(toysDataBase);
		
		for(Toy t: toys) {
			pw.println(t.formatToInventory());
		}
		pw.close();
	}
	
	/**
	 * Event Listener on Button[#button_search].onAction
	 * @param event
	 */
	

	@FXML
	public void search(ActionEvent event) {
		//Clears List
		listViewHome.getItems().clear();
		if (radioBttnSN.isSelected()) {
			toySearched = serial_field_search.getText();

			for (Toy t: toys) {
				if (t.getSerial().equals(toySearched)) {
					listViewHome.getItems().add(t);
				}
			}
			
		} else if (radioBttnName.isSelected()) {
			toySearched = name_field_search.getText();

			for (Toy t: toys) {
				if (t.getName().toLowerCase().contains(toySearched)) {
					listViewHome.getItems().add(t);
				}
			}
			
		} else if (radioBttnType.isSelected()) {
			toySearched = type_field_search.getText();

			for (Toy t: toys) {
				if (t.getType().equals(toySearched)) {
					listViewHome.getItems().add(t);
				}
			}
		}
	}
	
	/**
	 * Event Listener on Buttons to clear, purchase, and search
	 * @param event
	 */

	@FXML
	public void clearFields(ActionEvent event) {
		serial_field_search.clear();
		name_field_search.clear();
		type_field_search.clear();
		listViewHome.getItems().clear();
	}
	// Event Listener on Button[#button_buy].onAction
	@FXML
	public void purchaseToy(ActionEvent event) throws ExceptionsClass {
		try {
			toyPurchaseValidation();
			listViewHome.getSelectionModel().getSelectedItem().setAvailable(availableInventory - 1);
			try {
				save();
			} catch (IOException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error Dialog");
				a.setHeaderText(null);
				a.setContentText(e.getMessage());
				a.show();
			}
		} catch (ExceptionsClass e) {
			String ErrorMessages = String.join("\n", e.errorMessages);
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error Dialog");
			a.setHeaderText(e.getMessage());
			a.setContentText(ErrorMessages);
			a.show();
		}
	}
	/**
	 * Event Listener on Add button. Catches incorrect inputs, throws exceptions/error messages 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void addToy(ActionEvent event) throws Exception {
		
		try {
		
			toySaveValidation();
			serialOfToy = serial_field.getText().charAt(0);
			typeOfToy = choicebox.getSelectionModel().getSelectedItem();
			
			switch(typeOfToy) {
			 	case "Figure":
			 		if (serialOfToy == '0' || serialOfToy == '1') {
						serial = serial_field.getText();
						name = name_field.getText();
						brand = brand_field.getText();
						price = Double.parseDouble(price_field.getText());
						count = Integer.parseInt(available_field.getText());
						age = Integer.parseInt(ageApp_field.getText());
						String classification = classification_field.getText();
						Figure f = new Figure(serial, name, brand, price, count, age, classification.toUpperCase().charAt(0));
						toys.add(f);
						save();
						JOptionPane.showMessageDialog(null, "Toy Successfully Added");

					}
			 		break;
			 	case "Animal":
			 		if (serialOfToy == '2' || serialOfToy == '3') {
						
						serial = serial_field.getText();
						name = name_field.getText();
						brand = brand_field.getText();
						price = Double.parseDouble(price_field.getText());
						count = Integer.parseInt(available_field.getText());
						age = Integer.parseInt(ageApp_field.getText());
						String material = material_field.getText();
						String size = size_field.getText();
						Animal a = new Animal(serial, name, brand, price, count, age, material, size.toUpperCase().charAt(0));
						toys.add(a);
						save();
						JOptionPane.showMessageDialog(null, "Toy Successfully Added");

			 		}
			 		break;
			 	case "Puzzle":
			 		if (serialOfToy == '4' || serialOfToy == '5' || serialOfToy == '6') {
						
						serial = serial_field.getText();
						name = name_field.getText();
						brand = brand_field.getText();
						price = Double.parseDouble(price_field.getText());
						count = Integer.parseInt(available_field.getText());
						age = Integer.parseInt(ageApp_field.getText());
						String type = type_field.getText();
						Puzzle p = new Puzzle(serial, name, brand, price, count, age, type);
						toys.add(p);
						save();
						JOptionPane.showMessageDialog(null, "Toy Successfully Added");

					}
			 		break;
			 	case "Boardgame":
			 		if (serialOfToy == '7' || serialOfToy == '8' || serialOfToy == '9') {
						
						serial = serial_field.getText();
						name = name_field.getText();
						brand = brand_field.getText();
						price = Double.parseDouble(price_field.getText());
						count = Integer.parseInt(available_field.getText());
						age = Integer.parseInt(ageApp_field.getText());
						int minPlayers = Integer.parseInt(minPlayers_field.getText());
						int maxPlayers = Integer.parseInt(maxPlayers_field.getText());
						String designer = designers_field.getText();
						Boardgame b = new Boardgame(serial, name, brand, price, count, age, minPlayers, maxPlayers, designer);
						toys.add(b);
						save();
						JOptionPane.showMessageDialog(null, "Toy Successfully Added");

					}
			 		break;
			 	default:
			 		// code block
			}
		} catch (ExceptionsClass e) {
			String ErrorMessages = String.join("\n", e.errorMessages);
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error Dialog");
			a.setHeaderText(e.getMessage());
			a.setContentText(ErrorMessages);
			a.show();
		} catch (NumberFormatException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error Dialog");
			a.setHeaderText(null);
			a.setContentText("- Please make sure you entered valid numbers and filled out the correct fields");
			a.show();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error Dialog");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.show();
		}
		

	}
	/**
	 * Listener for remove sections search button
	 * @param event
	 */
	@FXML
	public void searchRemove(ActionEvent event) {
		//Clears List
		listViewRemove.getItems().clear();
		toySearched = serial_remove.getText();
		
		for (Toy t: toys) {
			if (t.getSerial().equals(toySearched)) {
				listViewRemove.getItems().add(t);
			}
		}
	}
	// Event Listener on Button[#button_remove].onAction
	@FXML
	public void deleteToy(ActionEvent event) throws Exception {
		toys.remove(listViewRemove.getSelectionModel().getSelectedItem());
		save();
		JOptionPane.showMessageDialog(null, "Toy Successfully Removed");

	}
	/**
	 * Validation method for toyfinder catches mismatch and throws exception
	 * @throws ExceptionsClass
	 */
	public void toySaveValidation() throws ExceptionsClass {
		
		ArrayList <String> errorMessages = new ArrayList<>();
		
		boolean result = validateRequiredFields(errorMessages);
		
		
		String errorHppn = "An error has occured:";
		if (errorMessages.size() > 0) {
			throw new ExceptionsClass (errorHppn, errorMessages) ;
		}
		
		errorMessages.clear();
		
		if(choicebox.getSelectionModel().getSelectedItem().equals("Boardgame")) {
		
		
		result = validNumOfPlayers(errorMessages);
		if (errorMessages.size() > 0) {
			throw new ExceptionsClass (errorHppn, errorMessages) ;
		}
		}
			
		
	}
	
	public boolean validateRequiredFields(ArrayList <String> errorMessages) {
		boolean isValid = true;
		if (choicebox.getSelectionModel().getSelectedItem() == null) {
			errorMessages.add("- Must select a category first");
			isValid = false;
			return isValid;
		}
		
		if ((serial_field.getText() == null || serial_field.getText().equals("")) && (serial_field.getText().length() == 10)) {
			errorMessages.add("- Must fill out serial number field and be 10 numbers long");
			isValid = false;
		}
		
		for (int i = 0; i < serial_field.getText().length(); i++) {
			if (!Character.isDigit(serial_field.getText().charAt(i))) {
				errorMessages.add("- Serial number can only contain letters");
				isValid = false;
				break;
			}
		}
	
		if (name_field.getText().equals("")) {
			errorMessages.add("- Must fill out name field");
			isValid = false;
		}
		if (brand_field.getText().equals("")) {
			errorMessages.add("- Must fill out brand field");
			isValid = false;
		}
		if (Double.parseDouble(price_field.getText()) < 0) {
			errorMessages.add("- Price must be a positive number");
			isValid = false;
		}
		if (Integer.parseInt(available_field.getText()) < 0) {
			errorMessages.add("- Please enter positive numbers for available count");
			isValid = false;
		}
		if (Integer.parseInt(ageApp_field.getText()) < 0) {
			errorMessages.add("- Please enter positive numbers for age appropiateness");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Animal") && (serial_field.getText().charAt(0) != '2' && serial_field.getText().charAt(0) != '3')) {
			errorMessages.add("- Serial number for animal must start with a 2 or 3");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Figure") && (serial_field.getText().charAt(0) != '0' && serial_field.getText().charAt(0) != '1')) {
			errorMessages.add("- Serial number for animal must start with a 1 or 0");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Puzzle") && (serial_field.getText().charAt(0) != '4' && serial_field.getText().charAt(0) != '5' && serial_field.getText().charAt(0) != '6')) {
			errorMessages.add("- Serial number for puzzle must start with a 4 or 5 or 6");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Boardgame") && (serial_field.getText().charAt(0) != '7' && serial_field.getText().charAt(0) != '8' && serial_field.getText().charAt(0) != '9')) {
			errorMessages.add("- Serial number for boardgame must start with a 7 or 8 or 9");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Animal") && (size_field.getText() == null || size_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the size text field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Animal") && (material_field.getText() == null || material_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the material field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Animal") && (!size_field.getText().toLowerCase().equals("s") && size_field.getText().toLowerCase().equals("m") && !size_field.getText().toLowerCase().equals("l"))) {
			errorMessages.add("- Size can only be s, m, or l");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Boardgame") && (minPlayers_field.getText() == null || minPlayers_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the min players text field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Boardgame") && (maxPlayers_field.getText() == null || maxPlayers_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the max players text field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Boardgame") && (designers_field.getText() == null || designers_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the designers text field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Figure") && (classification_field.getText() == null || classification_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the classification text field");
			isValid = false;
		}
		if (choicebox.getSelectionModel().getSelectedItem().equals("Puzzle") && (type_field.getText() == null || type_field.getText().equals(""))) {
			errorMessages.add("- Must fill out the puzzle type text field");
			isValid = false;
		}
		
		
		return isValid;
	}

		
	
	
	
	
	public boolean validNumOfPlayers(ArrayList <String> errorMessages) {
		boolean isValid = true;
		int minPlayers = Integer.parseInt(minPlayers_field.getText());
		int maxPlayers = Integer.parseInt(maxPlayers_field.getText());
		if (minPlayers > maxPlayers) {
			errorMessages.add("- The minimum number of players cannot be greater than the maximum number of players");
			isValid = false;
		}
		
		
		return isValid;
		
	}
	
	public boolean validInventory(ArrayList <String> errorMessages) {
		boolean isValid = true;
		availableInventory = listViewHome.getSelectionModel().getSelectedItem().getAvailable();
		if (availableInventory <= 0) {
			errorMessages.add("- You cannot buy this toy. The current inventory is 0");
			isValid = false;
		}
		
		return isValid;
	}
	
		
	
	public void toyPurchaseValidation() throws ExceptionsClass {
		ArrayList <String> errorMessages = new ArrayList<>();
		
		boolean result = validInventory(errorMessages);
		
		
		String errorHppn = "An error has occured:";
		if (errorMessages.size() > 0) {
			throw new ExceptionsClass (errorHppn, errorMessages) ;
		}
		
	}

	public void toggleSN() {
		
	}
	
}