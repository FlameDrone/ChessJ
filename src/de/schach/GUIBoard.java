package de.schach;

import javax.swing.*;
public class GUIBoard extends JFrame{
    private GUIField[][] board;
    public GUIBoard(){
        super();

    }

    public void createBoard(){
        String color = "White";
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new GUIField(color, i, j, null);
            }
        }
    }
}
