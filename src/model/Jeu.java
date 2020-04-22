package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	List<Pieces> pieces;
	public Jeu(Couleur couleur) {
		Couleur pieceCouleur = couleur;
		this.pieces = ChessPiecesFactory.newPieces(pieceCouleur);
	}

	// Test main
	public static void main(String[] args) {
		Jeu testConstruction = new Jeu(Couleur.NOIR);
		List<Pieces> listPieces = ChessPiecesFactory.newPieces(Couleur.NOIR);
		testConstruction.toString(listPieces);
	}
	
	public void toString(List<Pieces> pieces) {
		
		// it�rer sur les pieces pour call les toString
		for (Pieces piece : this.pieces) {
		   String testString = piece.toString(); 
		   System.out.println(testString);
		}
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces pieceTrouvee = null;
		for (Pieces piece : this.pieces) {
			
			/* On compare une seule fois vu que de toute fa�on si chevauchement
			*	c'est que cette m�thode a d�j� mal fait son travail
			*/
			if ((piece.getX() == x) && (piece.getY() == y)){
				pieceTrouvee = piece;
			}
		}
		return pieceTrouvee;
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return this.findPiece(xCatch, yCatch).capture();
	}

	public Coord getKingCoord() {
		
		for (Pieces piece : this.pieces) {
			AbstractPiece pieceTest;
			if (pieceTest.nom == "Roi"){
				Coord coordRoi = new Coord(piece.getX(),piece.getY());
				return coordRoi;
			}
		}
	}
	
	public boolean isPieceHere(int x,int y) {
		for (Pieces piece : this.pieces) {
			if ((piece.getX() == x) && (piece.getY() == y)){
				return true; // true si une pi�ce se trouve aux coordonn�es indiqu�es
			}
		}
		return false;
	}

	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return this.findPiece(xInit, yInit).isMoveOk(xFinal,yFinal); // true si d�placement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {

		// on commence par chercher quelle pi�ce est � l'endroit init
		Pieces pieceInit = this.findPiece(xInit, yInit);
		if ((pieceInit != null) && this.isMoveOk(xInit ,yInit ,xFinal ,yFinal)) {
			// Maintenant on v�rifie si on capture
			
			return true;
		}
		 return false;
	}
}
