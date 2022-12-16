package de.schach;

import  java.util.Scanner;
public class GameLogic {
	private Scanner sc;


	public GameLogic() {
		sc = new Scanner(System.in);
		ChessBoard.setupBoard();
	}

	public void play() {
		String from;
		String to;
		String letters = "ABCDEFGH";
		boolean whiteTurn = true;
		int row1, col1, row2, col2;
		while (true){
			if(whiteTurn) {
				System.out.println("~~~~~~~~~~~~~White~~~~~~~~~~~~~");
			}
			else {
				System.out.println("~~~~~~~~~~~~~Black~~~~~~~~~~~~~");
			}
			printBoard();
			System.out.print("From: ");
			from = sc.nextLine();
			row1 = Character.getNumericValue(from.charAt(0))-1;
			col1 = letters.indexOf(from.charAt(1));
			System.out.print("To: ");
			to = sc.nextLine();
			row2 = Character.getNumericValue(to.charAt(0))-1;
			col2 = letters.indexOf(to.charAt(1));
			if(makeMove(row1, col1, row2, col2, whiteTurn)){
				whiteTurn = !whiteTurn;
			};
		}
	}


	private boolean makeMove(int row1, int col1, int row2, int col2, boolean whiteTurn) {
		if (row1 >= 0 && row1 <= 7 && row2 >= 0 && row2 <= 7 && col1 >= 0 && col1 <= 7 && col2 >= 0 && col2 <= 7) {
			ChessPiece piece = ChessBoard.getPiece(row1, col1);
			if (piece != null) {
				if(piece.getColor().equals("White") == whiteTurn) {
					if (piece.validMove(row2, col2)) {
						ChessBoard.setPiece(row2, col2, piece);
						ChessBoard.setPiece(row1, col1, null);
						piece.setRow(row2);
						piece.setCol(col2);
						return true;
					}
				}
			}
		}
		return false;
	}

	private void printBoard() {
		for (int i = ChessBoard.getBoard().length - 1; i > -1; i--) {
			System.out.print(i+1+" ");
			for (ChessPiece piece : ChessBoard.getBoard()[i]) {
				if (piece != null) {
					System.out.print("[" + piece.getSymbol() + "]");
				} else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		System.out.println("   A  B  C  D  E  F  G  H");
	}
}