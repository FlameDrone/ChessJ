package de.schach;

public class ChessBoard {
	private static ChessPiece[][] board = new ChessPiece[8][8];;

	public static ChessPiece[][] getBoard() {
		return board;
	}

	public static void setBoard(ChessPiece[][] newBoard) {
		board = newBoard;
	}

	public static ChessPiece getPiece(int x, int y) {
		return board[x][y];
	}

	public static void setPiece(int x, int y, ChessPiece piece) { 
		board[x][y] = piece;
	}

	public static void removePiece(int x, int y) {
		board[x][y] = null;
	}

	public static void setupBoard() {
		board[0][0] = new Rook(0, 0, "White");
		board[0][1] = new Knight(0, 1, "White");
		board[0][2] = new Bishop(0, 2, "White");
		board[0][3] = new Queen(0, 3, "White");
		board[0][4] = new King(0, 4, "White");
		board[0][5] = new Bishop(0, 5, "White");
		board[0][6] = new Knight(0, 6, "White");
		board[0][7] = new Rook(0, 7, "White");
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(1, i, "White");
		}

		board[7][0] = new Rook(7, 0, "Black");
		board[7][1] = new Knight(7, 1, "Black");
		board[7][2] = new Bishop(7, 2, "Black");
		board[7][3] = new Queen(7, 3, "Black");
		board[7][4] = new King(7, 4, "Black");
		board[7][5] = new Bishop(7, 5, "Black");
		board[7][6] = new Knight(7, 6, "Black");
		board[7][7] = new Rook(7, 7, "Black");
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(6, i, "Black");
		}
	}

}