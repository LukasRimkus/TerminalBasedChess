package chess;

import java.io.Console;

public class Game {
	private static boolean gameEnd = false;

	public static void play(){
		Console keyboardConsole = System.console();

		CheckInput checkInput = new CheckInput();

		// whites start the game
		boolean whitesTurn = true;
		String origin, destination; 
		
		while (!gameEnd){
			if (whitesTurn){
				System.out.println("\n------ Whites move ------");
			}
			else{
				System.out.println("\n------ Blacks move ------");
			}

			boolean validOrigin = false, validDestination = false;

			// required to convert the chars to respective coordinates
			int baseChar = 97, maxChar = 104; 

			int coordXorigin = 0, coordYorigin = 0;

			while(!validOrigin && !gameEnd)
			{
				origin = keyboardConsole.readLine("Enter origin:\n");
				
				// check if a player wants to end the game
				if (origin.equals("END")){
					gameEnd = true;
				}
				else if (!checkInput.checkCoordinateValidity(origin)){
					System.out.println("\nPlease provide valid origin coordinates. Try again\n");
				}
				else{
					// convert to the coordinates 
					coordXorigin = Character.getNumericValue(origin.charAt(0)) - 1;
					
					// as char is a numerical data type, I can increment i (ASCII) and then
					// compare it with a character to find out if they are equivalent 
					boolean foundLetter = false;
					for (int i = baseChar; i <= maxChar && !foundLetter; i++) {
						if (origin.charAt(1) == i){
							coordYorigin = i - baseChar;
							foundLetter = true;
						}
					}

					if (!Board.hasPiece(coordXorigin, coordYorigin)){
						System.out.println("\nThere is not a piece here. Try again\n");
					}
					else{
						// checking if a user took his or her piece (colour)
						if (Board.getPiece(coordXorigin, coordYorigin).getColour() == PieceColour.WHITE && whitesTurn){
							validOrigin = true;
						}
						else if (Board.getPiece(coordXorigin, coordYorigin).getColour() == PieceColour.BLACK && !whitesTurn){
							validOrigin = true;
						}
						else{
							System.out.println("\nIt is not yout piece! Try again\n");
						}
					}
				}
			} 

			// if a player fails to give valid coordinates at the first time
			// he or she will need to provide orgin coordinates again
			// as it is possible to accidentally choose a piece which cannot 
			// perform any valid moves
			if (!gameEnd)
			{
				int coordXdestination = 0, coordYdestination = 0;

				destination = keyboardConsole.readLine("\nEnter destination:\n");
				
				// check if a player wants to end the game
				if (destination.equals("END")){
					gameEnd = true;
				}
				else if (!checkInput.checkCoordinateValidity(destination)){
					System.out.println("\nPlease provide valid destination coordinates\n\nTry Again");
				}
				else{
					// convert to the coordinates 
					coordXdestination = Character.getNumericValue(destination.charAt(0)) - 1;
					
					for (int i = baseChar; i <= maxChar; i++) {
						if (destination.charAt(1) == i){
							coordYdestination = i - baseChar;
						}
					}

					if (!Board.getPiece(coordXorigin, coordYorigin).isLegitMove(coordXorigin, coordYorigin, coordXdestination, coordYdestination)){
						System.out.println("\nThis move is not valid.\n\nTry again");
					}
					else{
						// call a movePiece method from board
						validDestination = true;

						// added for readability
						Piece piece = Board.getPiece(coordXorigin, coordYorigin);
						gameEnd = Board.movePiece(coordXorigin, coordYorigin, coordXdestination, coordYdestination, piece);

						if (gameEnd){
							System.out.println("\nGAME END");

							if (whitesTurn){
								System.out.println("WHITES WON!");
							}
							else{
								System.out.println("BLACKS WON!");
							}
						}
					}
				}
			}

			Board.printBoard();

			// if the destination was not valid, then the same player
			// tries again to make a move
			if (validDestination){
				whitesTurn = !whitesTurn;
			}
		}		
	}
	
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
