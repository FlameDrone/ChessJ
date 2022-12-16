package de.schach;
public class Knight extends ChessPiece
{

    public Knight(int row, int col, String color)
    {
        super(row,col,color);
    }

    public boolean validMove(int row, int col){
       if(ChessBoard.getPiece(row,col) != null){
           if(!ChessBoard.getPiece(row,col).getColor().equals(this.color)){
               return (Math.abs(this.row-row)==2 && Math.abs(this.col-col)==1) || (Math.abs(this.row-row)==1 && Math.abs(this.col-col)==2);
           }
           return false;
       }
       return (Math.abs(this.row-row)==2 && Math.abs(this.col-col)==1) || (Math.abs(this.row-row)==1 && Math.abs(this.col-col)==2);
    }

    public char getSymbol(){
        if(this.color == "White"){
            return 'N';
        }
        return 'n';
    }
}
