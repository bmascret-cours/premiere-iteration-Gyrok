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
	
	
	public boolean isPieceHere(int x,int y) {
		// boucle sur les 2 listes de pi�ces (?)
		return true; // true si une pi�ce se trouve aux coordonn�es indiqu�es
	}
	
	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return true; // true si d�placement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		// appelle is moveOk puis collision
		return true; // true si d�placement effectu�
	}
}
