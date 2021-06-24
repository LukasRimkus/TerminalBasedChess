package chess;

public class CheckInput {
	
	public boolean checkCoordinateValidity(String input){
		if (input.length() != 2)
		{
			return false;
		}

	   	int number = Character.getNumericValue(input.charAt(0));  

	   	if (number >= 9 || number <= 0){
	   		return false;
		}

		char[] validChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		for (int i = 0; i < validChars.length; i++) {
			if (input.charAt(1) == validChars[i]){
				return true;
			}
		}

		return false;
		
	}
}
