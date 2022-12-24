package de.schach;

public class Queen extends ChessPiece
{

    public Queen(int row, int col, String color)
    {
        super(row,col,color);
    }
    
    public boolean validMove(int row, int col){
        if(ChessBoard.getPiece(row,col) != null){
            if(ChessBoard.getPiece(row,col).getColor().equals(this.color)){
                return false;
            }
        }
        int x = 1;
        if (this.row == row) {
            if (this.col > col) {
                while (col != this.col - x) {
                    if (ChessBoard.getPiece(row, this.col - x) != null) {
                        return false;
                    }
                    x++;
                }
                return true;
            }
            if (this.col < col) {
                while (col != this.col + x) {
                    if (ChessBoard.getPiece(row, this.col + x) != null) {
                        return false;
                    }
                    x++;
                }
                return true;
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
                return true;
            }
            if (this.row < row) {
                while (row != this.row + x) {
                    if (ChessBoard.getPiece(this.row + x, col) != null) {
                        return false;
                    }
                    x++;
                }
                return true;
            }
        }
        if(Math.abs(this.row-row) != Math.abs(this.col-col)){
            return false;
        }
        int cRow = Integer.compare(row, this.row);
        int cCol= Integer.compare(col, this.col);

        row -= cRow;
        col -= cCol;

        while(this.row != row && this.col != col){
            if(ChessBoard.getPiece(row,col) != null){
                return false;
            }
            row -= cRow;
            col -= cCol;
        }

        return true;
    }

    public char getSymbol(){
        if(this.color.equals("White")){
            return 'Q';
        }
        return 'q';
    }

}