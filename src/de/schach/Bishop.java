package de.schach;

public class Bishop extends ChessPiece
{

    public Bishop(int row, int col, String color)
    {
        super(row,col,color);
    }

    public boolean validMove(int row, int col){
        if(ChessBoard.getPiece(row,col) != null){
            if(ChessBoard.getPiece(row,col).getColor().equals(this.color)){
                return false;
            }
        }
        if(this.row == row){
            return false;
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
            return 'B';
        }
        return 'b';
    }

}