package de.schach;
public class King extends ChessPiece
{

    public King(int row, int col, String color)
    {
        super(row,col,color);
    }
    
    public boolean validMove(int row, int col){
        if(ChessBoard.getPiece(row,col) != null){
                    if(!ChessBoard.getPiece(row,col).getColor().equals(this.color)){
                        return Math.abs(this.row-row)<=1 && Math.abs(this.col-col)<=1;
                    }
            return false;
        }
        return Math.abs(this.row-row)<=1 && Math.abs(this.col-col)<=1;
    }

    public char getSymbol(){
        if(this.color.equals("White")){
            return 'K';
        }
        return 'k';
    }
}