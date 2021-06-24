package chess;

import java.lang.Math;

public class Pawn extends Piece{	
	public Pawn(PieceColour p){
		colour = p;

		switch (p)
		{
			case BLACK:
				this.setSymbol("♟︎");
				break;
			case WHITE:
				this.setSymbol("♙");
				break;
			default:
				this.setSymbol("?");
				break;
		}
	}

	@Override
	public boolean isLegitMove(int i1, int j1, int i2, int j2){
		// a pawn can move two pieces forward if this piece has not made any moves before
		if (getColour() == PieceColour.BLACK && i1 == 1 && i2 == 3 && j1 == j2){
			if (!Board.hasPiece(2, j1) || !Board.hasPiece(3, j1)){
				return true;
			}
		}
		else if (getColour() == PieceColour.WHITE && i1 == 6 && i2 == 4 && j1 == j2){
			if (!Board.hasPiece(5, j1) || !Board.hasPiece(4, j1)){
				return true;
			}
		}
		else if (Math.abs(i2 - i1) == 1 && j1 == j2 && !Board.hasPiece(i2, j2)){
			return true;
		}
		// can move diagonally by one piece if a pawn is trying to capture other player's piece
		else if (Math.abs(i2 - i1) == 1 && Math.abs(j2 - j1) == 1 && Board.hasPiece(i2, j2)){
			if (getColour() != Board.getPiece(i2, j2).getColour()){
				return true;
			}
		}
		return false;
	}
}
