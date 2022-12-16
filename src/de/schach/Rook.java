package de.schach;

public class Rook extends ChessPiece
{

    public Rook(int row, int col, String color)
    {
        super(row,col,color);
    }
    
    public boolean validMove(int row, int col){
        int x = 1;
        if(ChessBoard.getPiece(row,col) != null) {
            if (ChessBoard.getPiece(row, col).equals(this.color)) {
                return false;
            }
            if (this.row == row) {
                if (this.col > col) {
                    while (col != this.col - x) {
                        if (ChessBoard.getPiece(row, this.col - x) != null) {
                            return false;
                        }
                        x++;
                    }
                }
                if (this.col < col) {
                    while (col != this.col + x) {
                        if (ChessBoard.getPiece(row, this.col + x) != null) {
                            return false;
                        }
                        x++;
                    }
                }
            }
            if (this.col == col) {
                if (this.row > row) {
                    while (row != this.row - x) {
                        if (ChessBoard.getPiece(this.row - x, col) != null) {
                            return false;
                        }
                        x++;
                    }
                }
                if (this.col < col) {
                    while (row != this.row + x) {
                        if (ChessBoard.getPiece(this.row + x, col) != null) {
                            return false;
                        }
                        x++;
                    }
                }
            }
        }
        return true;
    }

    public char getSymbol(){
        if(this.color == "White"){
            return 'R';
        }
        return 'r';
    }

}