package de.schach;

public class Pawn extends ChessPiece {

	public Pawn(int row, int col, String color) {
		super(row, col, color);
	}

	public boolean validMove(int row, int col) {
		boolean correct;
		if (this.getColor().equals("White")) {
			if (!this.getHasMoved() )
				correct =  (row == this.getRow() + 2 || row == this.getRow() + 1) && col == this.getCol();
			else
				correct = (row == this.getRow() + 1 && col == this.getCol());
		} else {
			if (!this.getHasMoved())
				correct = (row == this.getRow() - 2 || row == this.getRow() - 1) && col == this.getCol();
			else
				correct = (row == this.getRow() - 1 && col == this.getCol());
		}
		if(ChessBoard.getPiece(row, col) == null) {
			return correct;
		} else if (!ChessBoard.getPiece(row, col).getColor().equals(color)) {
			if(this.color.equals("White")){
				return row == this.row+1 && Math.abs(this.col-col) == 1 && ChessBoard.getPiece(row,col).getColor().equals("Black");
			}
			else{
				return row == this.row-1 && Math.abs(this.col-col) == 1 && ChessBoard.getPiece(row,col).getColor().equals("White");
			}
		}
		return false;

	}

	public char getSymbol(){
		if(this.color.equals("White")){
			return 'P';
		}
		return 'p';
	}

}