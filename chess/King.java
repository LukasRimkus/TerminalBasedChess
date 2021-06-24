package chess;

import java.lang.Math;

public class King extends Piece{
	public King(PieceColour p){
		colour = p;
		
		switch (p)
		{
			case BLACK:
				this.setSymbol("♚");
				break;
			case WHITE:
				this.setSymbol("♔");
				break;
			default:
				this.setSymbol("?");
				break;
		}
	}

	@Override
	public boolean isLegitMove(int i1, int j1, int i2, int j2){
		// check 3 conditions :
		// 1) for moving to top or bottom
		// 2) for moving to left or right
		// 3) for moving diagonally
		if (i1 == i2 && Math.abs(j1 - j2) == 1 ||
			j1 == j2 && Math.abs(i1 - i2) == 1 ||
			Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 1){
			
			if (Board.hasPiece(i2, j2)){
				if (getColour() != Board.getPiece(i2, j2).getColour()){
					return true;
				}
				else{
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
