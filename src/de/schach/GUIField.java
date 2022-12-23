package de.schach;

import javax.swing.JButton;
import javax.swing.Icon;
public class GUIField extends JButton {
    private String color;
    private int row,col;

    public GUIField(String color, int row, int col, Icon icon){
        super(icon);
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    
    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
