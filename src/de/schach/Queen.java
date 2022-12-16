package de.schach;
public class Queen extends ChessPiece
{

    public Queen(int row, int col, String color)
    {
        super(row,col,color);
    }
    
    public boolean validMove(int row, int col){
        return ((this.row == row && this.col != col) || (this.row != row && this.col == col)) || (Math.abs(this.row-row) == Math.abs(this.col-col));
    }

    public char getSymbol(){
        if(this.color == "White"){
            return 'Q';
        }
        return 'q';
    }

}