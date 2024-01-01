package exceptions;

import java.util.ArrayList;

public class ExceptionsClass extends Exception {
	
	public ArrayList<String> errorMessages = new ArrayList<>();
	
	public ExceptionsClass (String error, ArrayList<String> errorMessages) {
		super(error);
		this.errorMessages = errorMessages;
	}

}
