package chess;

import java.lang.Math;

public class Knight extends Piece{
	public Knight(PieceColour p){
		colour = p;
		
		switch (p)
		{
			case BLACK:
				this.setSymbol("♞");
				break;
			case WHITE:
				this.setSymbol("♘");
				break;
			default:
				this.setSymbol("?");
				break;
		}
	}

	@Override
	public boolean isLegitMove(int i1, int j1, int i2, int j2){
		// check 4 possible moves 
		if (Math.abs(i1 - i2) == 2 && Math.abs(j1 - j2) == 1 ||
			Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 2){
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
