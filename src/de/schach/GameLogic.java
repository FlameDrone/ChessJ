package de.schach;

import  java.util.Scanner;
public class GameLogic {
	private final Scanner sc;
	private final List<ChessPiece> whitePieces;
	private final List<ChessPiece> blackPieces;
	private King wKing;
	private King bKing;

	public GameLogic() {
		this.sc = new Scanner(System.in);
		this.whitePieces = new List<>();
		this.blackPieces = new List<>();
		
		setupBoard();
	}

	public void setupBoard() {
		ChessPiece piece = new Rook(0, 0, "White");
		ChessBoard.setPiece(0,0, piece);
		this.whitePieces.append(piece);

		piece = new Bishop(0, 2, "White");
		ChessBoard.setPiece(0,2, piece);
		this.whitePieces.append(piece);

		piece = new Knight(0, 1, "White");
		ChessBoard.setPiece(0,1, piece);
		this.whitePieces.append(piece);

		piece = new Queen(0, 3, "White");
		ChessBoard.setPiece(0,3, piece);
		this.whitePieces.append(piece);

		this.wKing = new King(0, 4, "White");
		ChessBoard.setPiece(0,4, wKing);
		this.whitePieces.append(wKing);

		piece =  new Bishop(0, 5, "White");
		ChessBoard.setPiece(0,5, piece);
		this.whitePieces.append(piece);

		piece = new Knight(0, 6, "White");
		ChessBoard.setPiece(0,6, piece);
		this.whitePieces.append(piece);

		piece = new Rook(0, 7, "White");
		ChessBoard.setPiece(0,7, piece);
		this.whitePieces.append(piece);

		for (int i = 0; i < 8; i++) {
			piece = new Pawn(1, i, "White");
			ChessBoard.setPiece(1, i, piece);
			this.whitePieces.append(piece);
		}

		piece = new Rook(7, 0, "Black");
		ChessBoard.setPiece(7,0, piece);
		this.blackPieces.append(piece);

		piece = new Knight(7, 1, "Black");
		ChessBoard.setPiece(7,1, piece);
		this.blackPieces.append(piece);

		piece = new Bishop(7, 2, "Black");
		ChessBoard.setPiece(7,2, piece);
		this.blackPieces.append(piece);

		piece = new Queen(7, 3, "Black");
		ChessBoard.setPiece(7,3, piece);
		this.blackPieces.append(piece);

		this.bKing = new King(7, 4, "Black");
		ChessBoard.setPiece(7,4, bKing);
		this.blackPieces.append(bKing);

		piece = new Bishop(7, 5, "Black");
		ChessBoard.setPiece(7,5, piece);
		this.blackPieces.append(piece);

		piece = new Knight(7, 6, "Black");
		ChessBoard.setPiece(7,6, piece);
		this.blackPieces.append(piece);

		piece = new Rook(7, 7, "Black");
		ChessBoard.setPiece(7,7, piece);
		this.blackPieces.append(piece);

		for (int i = 0; i < 8; i++) {
			piece = new Pawn(6, i, "Black");
			ChessBoard.setPiece(6, i, piece);
			this.blackPieces.append(piece);
		}
	}

	public void play() {
		String from;
		String to;
		String letters = "ABCDEFGH";
		boolean whiteTurn = true;
		int row1, col1, row2, col2;
		while (true){
			if(whiteTurn) {
				if(wKing.getWasCaptured()){
					System.out.println("Black Won!");
					return;
				}
				System.out.println("~~~~~~~~~~~~~White~~~~~~~~~~~~~");
				blackPieces.toFirst();
				while(blackPieces.hasAccess()){
					if(blackPieces.getContent().validMove(this.wKing.getRow(), this.wKing.getCol())){
						System.out.println("CHECK!");
						break;
					}
					blackPieces.next();
				}
			}
			else {
				if(bKing.getWasCaptured()){
					System.out.println("White Won!");
					return;
				}
				System.out.println("~~~~~~~~~~~~~Black~~~~~~~~~~~~~");
				whitePieces.toFirst();
				while(whitePieces.hasAccess()){
					if(whitePieces.getContent().validMove(this.bKing.getRow(), this.bKing.getCol())){
						System.out.println("CHECK!");
						break;
					}
					whitePieces.next();
				}
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
			}
		}
	}


	private boolean makeMove(int row1, int col1, int row2, int col2, boolean whiteTurn) {
		if (row1 >= 0 && row1 <= 7 && row2 >= 0 && row2 <= 7 && col1 >= 0 && col1 <= 7 && col2 >= 0 && col2 <= 7) {
			ChessPiece piece = ChessBoard.getPiece(row1, col1);
			if (piece != null) {
				if(piece.getColor().equals("White") == whiteTurn) {
					if (piece.validMove(row2, col2)) {
						ChessPiece oldPiece = ChessBoard.getPiece(row2, col2);
						if(oldPiece != null){
							oldPiece.setWasCaptured(true);
							if(oldPiece.getColor().equals("White")){
								whitePieces.toFirst();
								while(whitePieces.hasAccess()){
									if(whitePieces.getContent().equals(oldPiece)){
										whitePieces.remove();
									}
									whitePieces.next();
								}
							}
							else {
								blackPieces.toFirst();
								while (blackPieces.hasAccess()) {
									if (blackPieces.getContent().equals(oldPiece)) {
										blackPieces.remove();
									}
									blackPieces.next();
								}
							}
						}
						ChessBoard.setPiece(row2, col2, piece);
						ChessBoard.setPiece(row1, col1, null);
						piece.setRow(row2);
						piece.setCol(col2);
						piece.setHasMoved(true);
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