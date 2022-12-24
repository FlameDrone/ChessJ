package de.schach;

public class ChessBoard {
	private final static ChessPiece[][] board = new ChessPiece[8][8];

	public static ChessPiece[][] getBoard() {
		return board;
	}

	public static ChessPiece getPiece(int x, int y) {
		return board[x][y];
	}

	public static void setPiece(int x, int y, ChessPiece piece) { 
		board[x][y] = piece;
	}

}