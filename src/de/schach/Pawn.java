package de.schach;

public class Pawn extends ChessPiece {

	public Pawn(int row, int col, String color) {
		super(row, col, color);
	}

	public boolean validMove(int row, int col) {
		boolean correct = false;
		if (this.getColor().equals("White")) {
			if (this.getHasMoved() == false)
				correct =  (row == this.getRow() + 2 || row == this.getRow() + 1) && col == this.getCol();
			else
				correct = (row == this.getRow() + 1 && col == this.getCol());
		} else {
			if (this.getHasMoved() == false)
				correct = (row == this.getRow() - 2 || row == this.getRow() - 1) && col == this.getCol();
			else
				correct = (row == this.getRow() - 1 && col == this.getCol());
		}
		return correct;

	}

	public char getSymbol(){
		if(this.color == "White"){
			return 'P';
		}
		return 'p';
	}

}