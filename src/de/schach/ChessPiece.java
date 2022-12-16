package de.schach;
public abstract class ChessPiece
{
    protected int row;
    protected int col;
    protected String color;
    protected boolean hasMoved;
    public ChessPiece(int row, int col, String color)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.hasMoved = false;
    }

    
    public int getRow(){
        return this.row;
    }
    
    public void setRow(int row){
        this.row = row;
    }

    public int getCol(){
        return this.col;
    }

    public void setCol(int col){
        this.col = col;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean getHasMoved(){
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }
    
    public abstract char getSymbol();
    
    public abstract boolean validMove(int row, int col);

}