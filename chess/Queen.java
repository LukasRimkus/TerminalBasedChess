package chess;

public class Queen extends Piece{
	public Queen(PieceColour p){
		colour = p;
		
		switch (p)
		{
			case BLACK:
				this.setSymbol("♛");
				break;
			case WHITE:
				this.setSymbol("♕");
				break;
			default:
				this.setSymbol("?");
				break;
		}
	}
	/*
	First of all, I try to identify a specific range of coordinates 
	which needs checking while trying to determine what kind of move 
	could have been made by comparing the origin and destination 
	coordinates.

	for loops check only those squares where a specific piece 
	could theoretically go (only good moves). If a for loop did not 
	find a matching coordinate then the given destination was invalid.

	if an obstacle (another piece) was found between the origin 
	and destination coordinates then it means the move is invalid as well.
	*/
	@Override
	public boolean isLegitMove(int i1, int j1, int i2, int j2){
		if (i1 > i2){
			// top right side
			if (j1 < j2){
				for (int i = i1-1, j = j1+1; i >= 0 && j <= 7; i--, j++) {
					if (Board.hasPiece(i, j) && i != i2 && j != j2){
						return false;
					} 
					else if (i == i2 && j == j2){
						if (Board.hasPiece(i, j)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
			//top left side
			else if (j1 > j2){
				for (int i = i1-1, j = j1-1; i >= 0 && j >= 0; i--, j--){
					if (Board.hasPiece(i, j) && i != i2 && j != j2){
						return false;
					} 
					else if (i == i2 && j == j2){
						if (Board.hasPiece(i, j)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
			//top when j1=j2
			else{
				for (int i = i1 - 1; i >= i2; i--) {
					if (i != i2 && Board.hasPiece(i, j2)){
						return false;
					}
					else if (i == i2){
						if (Board.hasPiece(i, j2)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}

		}
		else if (i1 < i2){
			// bottom right
			if (j1 < j2){
				for (int i = i1+1, j = j1+1; i <= 7 && j <= 7; i++, j++){
					if (Board.hasPiece(i, j) && i != i2 && j != j2){
						return false;
					} 
					else if (i == i2 && j == j2){
						if (Board.hasPiece(i, j)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
			//bottom left
			else if (j1 > j2){
				for (int i = i1+1, j = j1-1; i <= 7 && j >= 0; i++, j--){
					if (Board.hasPiece(i, j) && i != i2 && j != j2){
						return false;
					} 
					else if (i == i2 && j == j2){
						if (Board.hasPiece(i, j)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
			// bottom when j1=j2
			else{
				for (int i = i1 + 1; i <= i2; i++) {
					if (i != i2 && Board.hasPiece(i, j2)){
						return false;
					}
					else if (i == i2){
						if (Board.hasPiece(i, j2)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
		}
		else if (i1 == i2){
			// left side
			if (j1 > j2){
				for (int i = j1 - 1; i >= j2; i--) {
					if (i != j2 && Board.hasPiece(i2, i)){
						return false;
					}
					else if (i == j2){
						if (Board.hasPiece(i2, i)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
			// right side
			else if (j1 < j2){
				for (int i = j1 + 1; i <= j2; i++) {
					if (i != j2 && Board.hasPiece(i2, i)){
						return false;
					}
					else if (i == j2){
						if (Board.hasPiece(i2, i)){
							if (getColour() != Board.getPiece(i2, j2).getColour()){
								return true;
							}
							else{
								return false;
							}
						}
						return true;
					}
				}
			}
		}
		return false;
	}
}
