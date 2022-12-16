package de.schach;

public class Bishop extends ChessPiece
{

    public Bishop(int row, int col, String color)
    {
        super(row,col,color);
    }

    public boolean validMove(int row, int col){
        return Math.abs(this.row-row) == Math.abs(this.col-col);
    }

    public char getSymbol(){
        if(this.color == "White"){
            return 'B';
        }
        return 'b';
    }

}