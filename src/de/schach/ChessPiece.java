package de.schach;
public abstract class ChessPiece
{
    protected int row;
    protected int col;
    protected String color;
    protected boolean hasMoved;

    protected boolean wasCaptured;
    public ChessPiece(int row, int col, String color)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.hasMoved = false;
        boolean wasCaptured = false;
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

    public boolean getHasMoved(){
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }
    
    public abstract char getSymbol();

    public boolean getWasCaptured() {
        return wasCaptured;
    }

    public void setWasCaptured(boolean wasCaptured) {
        this.wasCaptured = wasCaptured;
    }

    public abstract boolean validMove(int row, int col);

}