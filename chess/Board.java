package chess;


public class Board {
	private static Square [][] board = new Square[8][8];

	public static void initialiseBoard(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square();
		}		
	}
    
	public static void initialisePieces(){
		//Black pieces
		Board.setPiece(0,0,new Rook(PieceColour.BLACK));
		Board.setPiece(0,1,new Knight(PieceColour.BLACK));
		Board.setPiece(0,2,new Bishop(PieceColour.BLACK));
		Board.setPiece(0,3,new Queen(PieceColour.BLACK));
		Board.setPiece(0,4,new King(PieceColour.BLACK));
		Board.setPiece(0,5,new Bishop(PieceColour.BLACK));
		Board.setPiece(0,6,new Knight(PieceColour.BLACK));
		Board.setPiece(0,7,new Rook(PieceColour.BLACK));
		Board.setPiece(1,0,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,1,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,2,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,3,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,4,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,5,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,6,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,7,new Pawn(PieceColour.BLACK));

		//White pieces
		Board.setPiece(6,0,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,1,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,2,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,3,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,4,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,5,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,6,new Pawn(PieceColour.WHITE));
		Board.setPiece(6,7,new Pawn(PieceColour.WHITE));
		Board.setPiece(7,0,new Rook(PieceColour.WHITE));
		Board.setPiece(7,1,new Knight(PieceColour.WHITE));
		Board.setPiece(7,2,new Bishop(PieceColour.WHITE));
		Board.setPiece(7,3,new Queen(PieceColour.WHITE));
		Board.setPiece(7,4,new King(PieceColour.WHITE));
		Board.setPiece(7,5,new Bishop(PieceColour.WHITE));
		Board.setPiece(7,6,new Knight(PieceColour.WHITE));
		Board.setPiece(7,7,new Rook(PieceColour.WHITE));
	}
	
	public static void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && Board.hasPiece(i,j))
						System.out.print(row+" "+Board.getPiece(i,j).getSymbol());	
					else if ((j==0) && !Board.hasPiece(i,j))
						System.out.print(row+"  " );
					else if (Board.hasPiece(i,j))					
						System.out.print("|"+Board.getPiece(i,j).getSymbol());					
					else					
						System.out.print("| ");	
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");	
	}
	
	// method which sets a piece on a new square 
	// (removes previous pieces from the board if they were captured)
	// and checks if a king was captured
	public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		String symbol = new String();

		if (Board.hasPiece(i1, j1)){
			symbol = Board.getPiece(i1, j1).getSymbol();
			board[i1][j1].removePiece();
		}

		// it is not necessary to write 'Board.'
		// as the methods of this class can be accessed 
		// here without it but I found it more readable
		Board.setPiece(i1, j1, p);

		// access the square class to remove the piece 
		// from previous square
		board[i0][j0].removePiece();

		// this method should only return true when a king was captured
		if (symbol == "♚" || symbol == "♔"){
			return true;
		}

		return false;
	}

	public static void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}
	
	public static Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}
	
	public static boolean hasPiece(int i, int j){
		return board[i][j].hasPiece();
	}
}
